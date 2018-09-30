package CashMachine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> banknoteSet = new HashSet<Integer>();
        Integer sumOfMoney;

        try {
            System.out.println("Input sum of money, please.");
            String sumString = scanner.nextLine();
            sumOfMoney = Integer.parseInt(sumString);
            if (sumOfMoney <= 0){
                throw new IllegalArgumentException("Incorrect input");
            }

            System.out.println("Input nominals of banknotes, please.");
            final String inputString = scanner.nextLine();
            String[] banknotesChar = inputString.split(" ");
            Integer value;
            for (int i = 0; i < banknotesChar.length; i++) {
                value = Integer.parseInt(banknotesChar[i]);
                if (value <= 0){
                    throw new IllegalArgumentException("Incorrect input");
                }
                else {
                    banknoteSet.add(value);
                }
            }

        } catch (Exception e) {
            System.out.println("Incorrect input");
            System.exit(1);
            return;
        }

        Integer[] banknotes = new Integer[banknoteSet.size()];
        banknotes = banknoteSet.toArray(banknotes);
        Arrays.sort(banknotes);
        CashMachine test = new CashMachine(sumOfMoney, banknotes);
        test.printCombinations();
    }
}