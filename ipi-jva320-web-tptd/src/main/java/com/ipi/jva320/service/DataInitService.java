package com.ipi.jva320.service;

import com.ipi.jva320.model.SalarieAideADomicile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Ajoute des données de test si vide au démarrage
 */
@Component
public class DataInitService implements CommandLineRunner {

    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;

    @Override
    public void run(String... argv) throws Exception {
        if (this.salarieAideADomicileService.countSalaries() != 0) {
            return;
        }

        SalarieAideADomicile s1 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Jean", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s2 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s3 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s4 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s5 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s6 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,

                        80, 10, 1));
        SalarieAideADomicile s7 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s8 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s9 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s10 = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s11= this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
        SalarieAideADomicile s12  = this.salarieAideADomicileService.creerSalarieAideADomicile(
                new SalarieAideADomicile("Didine", LocalDate.parse("2022-12-05"), LocalDate.parse("2022-12-05"),
                        20, 0,
                        80, 10, 1));
    }
}
