package com.utpl.plansvalidator.reportes_api;

import com.utpl.plansvalidator.custom_queries.CustomResultList;
import com.utpl.plansvalidator.custom_queries.PlanDocenteQueryResolver;
import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.plandocente.Plan;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import net.sf.jsqlparser.JSQLParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RubricaValidatorService {
    private static Logger logger = LoggerFactory.getLogger(RubricaValidatorService.class.getSimpleName());

    @Autowired
    private PlanDocenteQueryResolver planDocenteQueryResolver;

    private Reporte reporte;
    private int currentPlanId;

    public Reporte validate(List<Rubrica> rubricas, Plan plan) {
        // Build reporte
        currentPlanId = plan.getId();
        reporte = new Reporte();
        reporte.setNombre(plan.getComponente().getNombre());
        reporte.setDescripcion("");
        // Get query results
        List<Reporte.IndicadorReporte> indicatorsReports = rubricas.stream()
                .map(Rubrica::getIndicadores)
                .flatMap(Collection::stream)
                .map(this::executeQuery)
                .collect(Collectors.toList());
        // Group criterias
        Map<String, List<Reporte.IndicadorReporte>> groupByCriterio = indicatorsReports.stream()
                .collect(Collectors.groupingBy(
                        Reporte.IndicadorReporte::getCriterio,
                        Collectors.mapping(indicadorReporte -> indicadorReporte,
                                Collectors.collectingAndThen(Collectors.toSet(), ArrayList::new))));
        List<Reporte.IndicadorReporteGroup> groups = groupByCriterio.entrySet().stream()
                .map(entry -> new Reporte.IndicadorReporteGroup(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        reporte.setGrupos(groups);
        return reporte;
    }

    private Reporte.IndicadorReporte executeQuery(Indicador indicador) {
        CustomResultList customResultList = new CustomResultList();
        // Build indicador
        Reporte.IndicadorReporte indicadorReporte = new Reporte.IndicadorReporte();
        indicadorReporte.setId(indicador.getId());
        indicadorReporte.setNombre(indicador.getNombre());
        indicadorReporte.setCriterio(indicador.getCriterio());
        indicadorReporte.setDescripcion(indicador.getDescripcion());
        try {
            customResultList = planDocenteQueryResolver.executeQuery(indicador.getFuncion(), indicador.getCondicion(), currentPlanId);
        } catch (JSQLParserException | SQLSyntaxErrorException e) {
            logger.error("SQL Format exception on indicador: " + indicador.getNombre());
            // Build error response
            indicadorReporte.addError(String.format("Error en la función: %s o condición: %s",
                    clean(indicador.getFuncion()), indicador.getCondicion()));
        }
        if (customResultList.getResultList() != null) {
            indicadorReporte.setExitoso(!customResultList.getResultList().isEmpty());
            if (customResultList.getResultList().isEmpty())
                indicadorReporte.addError(indicador.getRecomendaciones());
        }
        indicadorReporte.setCondicion(indicador.getCondicion());
        return indicadorReporte;
    }

    private String clean(String funcion) {
        return funcion.replaceAll("\r", "").replaceAll("\n", " ");
    }
}
