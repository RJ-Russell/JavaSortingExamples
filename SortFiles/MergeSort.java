import java.util.ArrayList;
import java.util.List;

class MergeSort {
    private List<Integer> copy = null;

    MergeSort(List<Integer> original) {
        copy = new ArrayList<>();

        for(Integer item : original) {
            copy.add(item);
        }
    }

    List<Integer> sort() {
        mergeSort(copy);
        return copy;
    }

    private List<Integer> mergeSort(List<Integer> list) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int center;

        if(list.size() == 1) {
            return list;
        } else {
            center = list.size()/2;
            for(int i = 0; i < center; ++i) {
                left.add(list.get(i));
            }
            for(int i = center; i < list.size(); ++i) {
                right.add(list.get(i));
            }
            left = mergeSort(left);
            right = mergeSort(right);

            merge(left, right, list);
        }
        return list;
    }

    private void merge(List<Integer> left, List<Integer> right, List<Integer> list) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;
        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                list.set(listIndex, left.get(leftIndex));
                ++leftIndex;
            } else {
                list.set(listIndex, right.get(rightIndex));
                ++rightIndex;
            }
            ++listIndex;
        }

        List<Integer> rest;
        int restIndex;
        if(leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for(int i = restIndex; i < rest.size(); ++i) {
            list.set(listIndex, rest.get(i));
            ++listIndex;
        }
    }
}
