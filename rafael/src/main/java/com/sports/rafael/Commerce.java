package com.sports.rafael;

import java.util.ArrayList;
import java.util.List;

public class Commerce {

    public static void main(String[] args) {

        //getRemainingCompanyBalance();
        List<StringBuilder> list = new ArrayList<>();

        //addName(list, new StringBuilder("shailendra"));
        System.out.println(list);

    }

    private static void addName(List<? super StringBuilder> names, String newName) {
        //names.add(newName);
    }

    private static long getRemainingCompanyBalance(long initialBalance, List<PersonalExpense>... departmentExpenses) {
        long remainingBalance = initialBalance;
        for (List<PersonalExpense> departmentExpense : departmentExpenses) {
            for (PersonalExpense personalExpense : departmentExpense) {
                System.out.println(personalExpense.getName());
                remainingBalance = remainingBalance - personalExpense.getCurrentExpenses();
            }
        }
        return remainingBalance;
    }

    class PersonalExpense {
        private long currentExpenses;
        private String name;
        public long getCurrentExpenses() {
            return this.currentExpenses;
        }

        public String getName() {
            return this.name;
        }
    }
}
