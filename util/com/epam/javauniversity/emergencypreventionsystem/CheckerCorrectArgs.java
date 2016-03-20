package com.epam.javauniversity.emergencypreventionsystem;

public final class CheckerCorrectArgs {

    private CheckerCorrectArgs() {
    }

    public static void checkCorrectArgs(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Number arguments not three");
        }
        try {
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
            Double.parseDouble(args[2]);
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
        if (Integer.parseInt(args[0]) < 1 &&
            Integer.parseInt(args[1]) < 1 &&
            Double.parseDouble(args[2]) < 0 && Double.parseDouble(args[2]) > 1) {
            throw new IllegalArgumentException("Arguments incorrect");
        }
    }
}
