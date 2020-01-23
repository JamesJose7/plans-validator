package com.utpl.plansvalidator.core;

import com.utpl.plansvalidator.nosql.historialvalidacion.HistorialValidacionRepository;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlacesRubricaRepository;
import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.indicador.IndicadorRepository;
import com.utpl.plansvalidator.sql.plandocente.PlanDocenteRepository;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import com.utpl.plansvalidator.sql.rubrica.RubricaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class StartupConfig {
    private static Logger logger = LoggerFactory.getLogger(StartupConfig.class.getName());

    @Autowired
    private RubricaRepository rubricaRepository;
    @Autowired
    private IndicadorRepository indicadorRepository;
    @Autowired
    private PlanDocenteRepository planDocenteRepository;
    @Autowired
    private EnlacesRubricaRepository enlacesRubricaRepository;
    @Autowired
    private HistorialValidacionRepository historialValidacionRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void bootConfiguration() {
        Indicador i1 = new Indicador();
        i1.setNombre("i1");
        Indicador i2 = new Indicador();
        i2.setNombre("i2");
        Indicador i3 = new Indicador();
        i3.setNombre("i3");
        Rubrica r1 = new Rubrica();
        ArrayList<Indicador> indicadores = new ArrayList<>(Arrays.asList(i1, i2, i3));
        indicadores.forEach(i -> i.setRubrica(r1));
        r1.setIndicadores(indicadores);
//        rubricaRepository.save(r1);
    }
}
