package ATM.App.processLayer;

import ATM.App.dataLayer.Denomination;

import java.util.HashMap;
import java.util.Map;

public class AtmMemory {
    /* A hash map that stores how many of each type of bank note the device has */
    private static final Map<Integer, Integer> noteMap = new HashMap<>();
    private final int BALANCE_THRESHOLD;
    //private boolean balanceAlert = false; // TODO if get extra time

    /* Constructor */
    public AtmMemory(int defaultNoteCount, int balanceThreshold) {
        // Initialisation with default value
        BALANCE_THRESHOLD = balanceThreshold;
        for (Denomination note : Denomination.values()) {
            noteMap.put(note.getNoteValue(), defaultNoteCount);
        }
    }

    public Map<Integer, Integer> getNoteMap() {
        return noteMap;
    }

    public void updateNoteMap(Map<Integer, Integer> withdrawnResult) {
        for (Map.Entry<Integer, Integer> entry : withdrawnResult.entrySet()) {
            int currentNote = entry.getKey();
            int currentCount = noteMap.get(currentNote) - entry.getValue();
            noteMap.put(currentNote, currentCount);
        }
    }
}
