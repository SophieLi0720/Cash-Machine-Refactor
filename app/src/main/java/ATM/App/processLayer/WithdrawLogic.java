package ATM.App.processLayer;

import java.util.ArrayList;

public class WithdrawLogic {

    public static int[][] calculateCombination(int requestAmount, ArrayList<Integer> notes) {

        int noteCount = notes.size();
        // Build up a DP table
        int[][] combinationTable = new int[noteCount + 1][requestAmount + 1];
        int itemNum;
        int combinationVal;

        // combinationTable[itemNum][combinationVal] denote the maximum total value
        // achievable within the combinationVal using items 0, 1, 2, ... , itemNum
        for (itemNum = 0; itemNum <= noteCount; itemNum++) {
            for (combinationVal = 0; combinationVal <= requestAmount; combinationVal++) {
                if (itemNum == 0 || combinationVal == 0) {
                    // If i = 0, we have no items, therefore total value = 0
                    combinationTable[itemNum][combinationVal] = 0;
                } else if (notes.get(itemNum - 1) <= combinationVal) {
                    // If the value of ith note <= combinationVal, try with and without the ith note and see
                    //which gives the best outcome
                    combinationTable[itemNum][combinationVal] = Math.max(notes.get(itemNum - 1) + combinationTable[itemNum - 1][combinationVal - notes.get(itemNum - 1)],
                            combinationTable[itemNum - 1][combinationVal]);
                } else {
                    // If the value of ith note > combinationVal, we can’t use it.
                    combinationTable[itemNum][combinationVal] = combinationTable[itemNum - 1][combinationVal];
                }
            }
        }
        return combinationTable;
    }
}
