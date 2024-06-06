package algorithms;

import javax.swing.JLabel;
import ui.sortVisualizer;
import java.util.ArrayList;
import java.util.List;

public class selectionSort implements sortAlgorithm {

    @Override
    public List<int[]> runSort(int[] array, sortVisualizer panel, JLabel swapLabel) {
        List<int[]> steps = new ArrayList<>();
        int arraySize = array.length;
        int[] swapCount = {0};

        // Record the initial state
        steps.add(array.clone());

        for (int currentIndex = 0; currentIndex < arraySize - 1; currentIndex++) {
            int minimumIndex = currentIndex;
            for (int i = currentIndex + 1; i < arraySize; i++) {
                if (array[i] < array[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            if (minimumIndex != currentIndex) {
                swap(array, currentIndex, minimumIndex, swapCount, swapLabel);
                panel.setSorted(false);
            }
            // Record state after each swap
            steps.add(array.clone());
        }

        // Set sorted state
        panel.setSorted(true);
        steps.add(array.clone());

        // Update swap count label
        swapLabel.setText("Swaps: " + swapCount[0]);

        return steps;
    }

    private static void swap(int[] array, int i, int j, int[] swapCount, JLabel swapLabel) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swapCount[0]++;
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}
