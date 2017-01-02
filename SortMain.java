import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortMain {
    private final static int size = 25;
    private final static int randRange = 1000;
    private final static Random random = new Random();

    private static String sortChoice = null;
    private static boolean options = false;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Invalid number of args!");
            System.err.println("Please choose one option.");
            System.exit(-1);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; ++i) {
            list.add(random.nextInt(randRange));
        }

        List<Integer> newList = option(args[0], list);
        if(newList == null && !options) {
            System.out.println("Option given not found!");
            System.exit(-1);
        } else if(newList == null) {
            System.exit(-1);
        } else {
            show(list, "Pre-Sort");
            show(newList, sortChoice);
        }
    }

    private static List<Integer> option(String arg, List<Integer> list) {
        List<Integer> sortedList;
        switch(arg) {
            case "-bs":
                BubbleSort bs = new BubbleSort(list);
                sortedList = bs.sort();
                sortChoice = "Bubble Sort";
                break;
            case "-cs":
                CombSort cs = new CombSort(list);
                sortedList = cs.sort();
                sortChoice = "Comb Sort";
                break;
            case "-is":
                InsertionSort is = new InsertionSort(list);
                sortedList = is.sort();
                sortChoice = "Insertion Sort";
                break;
            case "-ms":
                MergeSort ms = new MergeSort(list);
                sortedList = ms.sort();
                sortChoice = "Merge Sort";
                break;
            case "-qs":
                QuickSort qs = new QuickSort(list);
                sortedList = qs.sort();
                sortChoice = "Quick Sort";
                break;
            case "-ss":
                SelectionSort ss = new SelectionSort(list);
                sortedList = ss.sort();
                sortChoice = "Selection Sort";
                break;
            case "-h":
                showOptions();
                options = true;
            default:
               sortedList = null;
        }
        return sortedList;
    }

    private static void show(List<Integer> toDisplay, String prompt) {
        System.out.println("=========================================\n");
        System.out.println(prompt);
        System.out.println("-------------------------------------------");
        System.out.println(toDisplay);
        System.out.println("-------------------------------------------");
    }

    private static void showOptions() {
        String toDisplay = String.join("\n"
                , "Usage: java SortMain [option]"
                , "-----------------------"
                , "To view option list run: java Sort -h\n"
                , "Options List"
                , "-----------------------"
                , "-cs\tComb Sort"
                , "-is\tInsertion Sort"
                , "-ms\tMerge Sort"
                , "-qs\tQuick Sort"
                , "-ss\tSelection Sort"
                , "-h\tShow Usage/Option Menu"
        );
        System.out.println(toDisplay);
    }
}
