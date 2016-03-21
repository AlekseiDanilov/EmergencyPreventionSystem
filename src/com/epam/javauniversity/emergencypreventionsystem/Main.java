package com.epam.javauniversity.emergencypreventionsystem;

public class Main {

    public static void main(String[] args) {

        System.out.println("EMERGENCY PREVENTION SYSTEM");

        InputParameters inputParameters = new InputParameters(args);
        inputParameters.printInputParameters();

        Risk.printLevelsRisk();

        Sector sector = new Sector(inputParameters.getN(), inputParameters.getM(), inputParameters.getFillFactor());
        sector.analyseSector();
        sector.printSector();

        Report report = new Report(sector.getListGroupsPerson());
        report.printReport();
    }
}
