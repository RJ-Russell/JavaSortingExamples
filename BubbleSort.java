import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by reaper6 on 1/2/17.
 */
public class BubbleSort {
    private List<Integer> copy = null;

    BubbleSort(List<Integer> original) {
        copy = new ArrayList<>();

        for(Integer item : original) {
            copy.add(item);
        }
    }

    List<Integer> sort() {
        bubbleSort();
        return copy;
    }

    private void bubbleSort() {
        int k = 0;
        for(int i = copy.size() - 1; i >= 0; --i) {
            for (int j = 0; j < copy.size() - 1; ++j) {
                k = j + 1;
                if (copy.get(j).compareTo(copy.get(k)) > 0) {
                    Collections.swap(copy, j, k);
                }
            }
        }
    }
}
