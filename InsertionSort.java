import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InsertionSort {
    private List<Integer> copy = null;

    InsertionSort(List<Integer> original) {
        copy = new ArrayList<>();

        for(Integer item : original) {
            copy.add(item);
        }
    }

    List<Integer> sort() {
        insertionSort();
        return copy;
    }

    private void insertionSort() {
        int j = 0;
        for(int i = 0; i < copy.size(); ++i) {
            j = i;
            while (j > 0 && copy.get(j).compareTo(copy.get(j-1)) < 0) {
                Collections.swap(copy, j, j - 1);
                --j;
            }
        }
    }
}
