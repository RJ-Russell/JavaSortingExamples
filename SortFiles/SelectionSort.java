import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SelectionSort {
    private List<Integer> copy = null;

    SelectionSort(List<Integer> original) {
        copy = new ArrayList<>();

        for(Integer item : original) {
            copy.add(item);
        }
    }

    List<Integer> sort() {
        selectionSort();
        return copy;
    }

    private void selectionSort() {
        int min;
        for(int i = 0; i < copy.size(); ++i) {
            min = i;
            for(int j = i + 1; j < copy.size(); ++j) {
                if(copy.get(j).compareTo(copy.get(min)) < 0) {
                    min = j;
                }
            }
            if(min != i) {
                Collections.swap(copy, i, min);
            }
        }
    }
}
