package implementation;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int arr[] = {5, 2 , 3, 8, 12, 10, 1};
        int arr[] = {4, 3, 8, 7, 6, 5};
        System.out.println("합병정렬 전: ");
        Arrays.stream(arr).forEach(x -> System.out.printf("%d " ,x));
        MergeSort mergeSort = new MergeSort();
        mergeSort.recursionMergeSort(arr, 0, arr.length -1);
        System.out.println("\n합병정렬 후: ");
        Arrays.stream(arr).forEach(x -> System.out.printf("%d " ,x));
    }
}
