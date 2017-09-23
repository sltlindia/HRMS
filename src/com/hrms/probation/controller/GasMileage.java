package com.hrms.probation.controller;
import java.util.Scanner;

public class GasMileage {

    public static void main(String[] args) {
        GasMileage mileage1 = new GasMileage();
        GasMileage mileage2 = new GasMileage();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the MPG calculator!");
        double counterM;
        double counterG;
        double mileage;
        double gallons;
        double mpg;
        double average;

        String repeat = "yes";

        while (repeat.equals("Yes") ||
               repeat.equals("yes") ||
               repeat.equals("y") ||
               repeat.equals("Y")) {

            System.out.println("Enter miles driven: ");
            mileage = input.nextDouble();
            counterM = mileage++;
            mileage1.setMilesDriven(mileage);
            mileage2.setMilesDriven(counterM);

            System.out.println("Enter gallons used: ");
            gallons = input.nextDouble();
            counterG = gallons++;
            mileage1.setGallonsUsed(gallons);
            mileage2.setGallonsUsed(counterG);

            mileage1.setMpg(mileage, gallons);
            mileage2.setMpg(counterM, counterG);
            mpg = mileage1.getMpg();
            System.out.println("Your mpg is: " + mpg);

            System.out.println("repeat? ");
            repeat=input.next();
        }

        average = mileage2.getMpg();
        System.out.println("Your total average mpg is: " + average);
    }

    double milesDriven;
    double gallonsUsed;
    double mpg1;

    public void setMilesDriven(double Miles) {
        milesDriven = milesDriven + Miles;
    }
    public void setGallonsUsed(double Gallons) {
        gallonsUsed = gallonsUsed+Gallons;
    }

    public double getMilesDriven() {
        return milesDriven;
    }

    public double getGallonsUSed() {
        return gallonsUsed;
    }

    public void setMpg(double setM, double setG) {
        mpg1 = (setM) / setG;
    }

    public double getMpg() {
            return mpg1;
    }
}