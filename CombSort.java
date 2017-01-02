import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombSort {
    private List<Integer> copy = null;

    CombSort(List<Integer> original) {
        copy = new ArrayList<>();

        for(Integer item : original) {
            copy.add(item);
        }
    }

    List<Integer> sort() {
        combSort();
        return copy;
    }

    private void combSort() {
        int gap = copy.size();
        double shrink = 1.3;
        boolean swapped = false;

        while (gap > 1 || swapped) {
            gap = (int)((double)gap/shrink);
            if(gap < 1) {
                gap = 1;
            }
            int i = 0;
            swapped = false;
            while((i + gap) <= copy.size() - 1) {
                if(copy.get(i).compareTo(copy.get(i+gap)) > 0) {
                    Collections.swap(copy, i, i+gap);
                    swapped = true;
                }
                ++i;
            }
        }
    }
}
