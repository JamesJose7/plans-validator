package com.utpl.plansvalidator.reportes_api;

import com.utpl.plansvalidator.custom_queries.CustomResultList;
import com.utpl.plansvalidator.custom_queries.PlanDocenteQueryResolver;
import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.plandocente.Plan;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.Collection;
import java.util.List;

@Service
public class RubricaValidatorService {
    @Autowired
    private PlanDocenteQueryResolver planDocenteQueryResolver;

    private Reporte reporte;
    private Long currentPlanId;

    public Reporte validate(List<Rubrica> rubricas, Plan plan) {
        // Build reporte
        currentPlanId = plan.getId();
        reporte = new Reporte();
        reporte.setName(plan.getComponente() + "");
        reporte.setDescription("");
        // Get query results
        rubricas.stream()
                .map(Rubrica::getIndicadores)
                .flatMap(Collection::stream)
                .map(this::executeQuery)
                .forEach(indicadorReporte -> reporte.addIndicador(indicadorReporte));
        return reporte;
    }

    private Reporte.IndicadorReporte executeQuery(Indicador indicador) {
        CustomResultList customResultList = new CustomResultList();
        try {
            customResultList = planDocenteQueryResolver.executeQuery(indicador.getFuncion(), indicador.getCondicion(), currentPlanId);
        } catch (JSQLParserException | SQLSyntaxErrorException e) {
            e.printStackTrace();
            // TODO: Handle exceptions when query running fails
        }
        // Build indicador
        Reporte.IndicadorReporte indicadorReporte = new Reporte.IndicadorReporte();
        indicadorReporte.setName(indicador.getNombre());
        indicadorReporte.setGroupName(indicador.getGrupo());
        indicadorReporte.setSuccessful(!customResultList.getResultList().isEmpty());
        if (customResultList.getResultList().isEmpty())
            indicadorReporte.addError(indicador.getRecomendaciones());
        indicadorReporte.setExpected(indicador.getCondicion());
        return indicadorReporte;
    }
}
