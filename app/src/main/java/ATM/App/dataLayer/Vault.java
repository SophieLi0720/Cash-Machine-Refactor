package ATM.App.dataLayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Vault {

    public ArrayList<Integer> cashInVault(Map<Integer, Integer> balanceMap) {
        // An ArrayList that contains denominations as items
        // The length of the ArrayList will be the sum of the number of banknotes of various denominations
        ArrayList<Integer> notes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
            Integer noteValue = entry.getKey();
            Integer noteCount = entry.getValue();
            for (int j = 0; j < noteCount; j++) notes.add(noteValue);
        }
        // Sort the ArrayList to descending order to give preference to the larger denominations in the Dynamic Programming algorithm
        notes.sort(Collections.reverseOrder());
        return notes;
    }

    public int getVaultBalance(Map<Integer, Integer> balanceMap) {
        AtomicInteger balance = new AtomicInteger();
        for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
            Integer noteValue = entry.getKey();
            Integer noteCount = entry.getValue();
            balance.addAndGet(noteValue * noteCount);
        }
        return balance.get();
    }
}
