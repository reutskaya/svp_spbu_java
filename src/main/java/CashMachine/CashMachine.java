package CashMachine;

import java.util.ArrayList;

public class CashMachine {
    private Integer[] banknotes;
    private Integer sum;
    private ArrayList<String> listOfCombinations = new ArrayList<>();


    public CashMachine(Integer sum, Integer[] banknotes) {
        this.sum = sum;
        this.banknotes = banknotes;
    }

    public void printCombinations() {
        makeCombinations(sum, banknotes.length - 1, "");

        for (int i = 0; i < listOfCombinations.size(); i++) {
            System.out.println(listOfCombinations.get(i));
        }

        System.out.println("\n There are " + listOfCombinations.size() + " possible combinations.");
    }

    private void makeCombinations(Integer sum, int coinIndex, String combination) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            listOfCombinations.add(combination);
        }
        if (coinIndex == 0) {
            int inclusionNumber = sum / banknotes[coinIndex];
            if (sum % banknotes[coinIndex] != 0)
                return;
            else {
                listOfCombinations.add(combination + lastCombination(inclusionNumber, coinIndex));
                return;
            }
        }

        for (int i = 0; i < sum / banknotes[coinIndex]; i++) {
            makeCombinations(sum - i * banknotes[coinIndex], coinIndex - 1, combination + lastCombination(i, coinIndex));
        }
    }

    private String lastCombination(int numberOfInclusion, int index) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfInclusion; i++) {
            string.append(banknotes[index].toString()).append(" ");
        }

        return string.toString();
    }
}
