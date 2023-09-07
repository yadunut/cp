package ref;

public class Main {
    public static void main(String[] args) {
//        sll();
        insertionSort();
    }

    static void insertionSort() {
        int[] arr = new int[]{5, 6, 3, 2, 1};
        InsertionSort.sort(arr);
        printArr(arr);
    }


    static void sll() {
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.insert(0, 1);
        sll.insert(0, 2);
        sll.insert(2, 3);
        sll.insert(2, 4);
        sll.insert(2, 5);
        System.out.println(sll);
    }

    static void printArr(int[] arr) {
        for (int a: arr) {
            System.out.printf("%d ", a);
        }
        System.out.println();
    }
}
