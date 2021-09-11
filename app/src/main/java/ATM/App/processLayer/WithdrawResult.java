package ATM.App.processLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WithdrawResult {

    public static Map<Integer, Integer> getCombinationMap(int requestAmount, int[][] combinationTable, ArrayList<Integer> notes) {

        // back tracking to get the solution
        Map<Integer, Integer> resultMap = new HashMap<>();
        int itemNum = notes.size();
        int combinationVal = requestAmount;
        while (itemNum > 0 && combinationVal > 0) {
            if (combinationTable[itemNum][combinationVal] != combinationTable[itemNum - 1][combinationVal]) {
                // If the maximum total value achieved changed, the ith note was used
                int currentNote = notes.get(itemNum - 1);
                // Add the ith note to the resultMap
                if (resultMap.containsKey(currentNote)) {
                    int currentCount = resultMap.get(currentNote) + 1;
                    resultMap.put(currentNote, currentCount);
                } else {
                    resultMap.put(currentNote, 1);
                }
                combinationVal = combinationVal - notes.get(itemNum - 1);
            }
            itemNum--;
        }
        return resultMap;
    }
}
