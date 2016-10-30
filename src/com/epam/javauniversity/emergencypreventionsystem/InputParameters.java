package com.epam.javauniversity.emergencypreventionsystem;

public class InputParameters {
    private int n;
    private int m;
    private double fillFactor;

    public InputParameters(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Number arguments not three");
        }
        try {
            setN(Integer.parseInt(args[0]));
            setM(Integer.parseInt(args[1]));
            setFillFactor(Double.parseDouble(args[2]));
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
        if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[1]) < 1 ||
                Double.parseDouble(args[2]) < 0 || Double.parseDouble(args[2]) > 1) {
            throw new IllegalArgumentException("Arguments incorrect");
        }
    }

    public void printInputParameters() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("N: " + n + "\nM: " + m + "\nFill factor: " + fillFactor + "\n");
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public double getFillFactor() {
        return fillFactor;
    }

    public void setFillFactor(double fillFactor) {
        this.fillFactor = fillFactor;
    }
}
