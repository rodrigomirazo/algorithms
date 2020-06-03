package com.algortithms;

public class BillionOfUsers {

    public static void main(String[] args) {
        BillionOfUsers B = new BillionOfUsers();

        int time = B.getBillionUsersDay(new float[]{1.5f});
        System.out.println("time = " + time);
    }

    int getBillionUsersDay(float[] growthRates) {
        int days = calculateDays(growthRates, 0f, 0);

        return days;
    }

    int calculateDays(float[] growthRates, float sum, int days) {

        for(int i = 0; i < growthRates.length; i++) {
            sum += Math.pow(growthRates[i], days);
            if(sum >= 1000000000f) {
                return days;
            }
        }
        days++;
        return calculateDays(growthRates, sum, days);
    }
}
