import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class QuickSort {
    private List<Integer> copy = null;
    private Random random = null;

    QuickSort(List<Integer> original) {
        copy = new ArrayList<>();
        random = new Random();

        for(Integer item : original) {
            copy.add(item);
        }
    }

    List<Integer> sort() {
        int low = 0;
        int high = copy.size() - 1;
        quickSort(copy, low, high);

        return copy;
    }

    private List<Integer> quickSort(List<Integer> list, int low, int high) {
        int i = low;
        int j = high;
        // Calculates a random pivot point within the subarray.
        int pivot = list.get(calculatePivot(high, low));
        // Calculates the pivot point to be the middle of the subarray
        // int pivot = list.get((high + low)/2);

        while(i <= j) {
            while(list.get(i).compareTo(pivot) < 0) {
                ++i;
            }
            while(list.get(j).compareTo(pivot) > 0) {
                --j;
            }
            if(i <= j) {
                Collections.swap(list, i, j);
                ++i;
                --j;
            }
        }

        if(j > low) {
            quickSort(list, low, j);
        }
        if(i < high) {
            quickSort(list, i, high);
        }

        return list;
    }

    private int calculatePivot(int high, int low) {
        return low + random.nextInt(high - low + 1);
    }

}
