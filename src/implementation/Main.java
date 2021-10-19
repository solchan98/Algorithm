package implementation;

import java.util.Arrays;

public class Main {

    private static int arr[] = {8, 3, 1, 2, 5, 4};

//    // MergeSort
//    public static void main(String[] args) {
////        int arr[] = {5, 2 , 3, 8, 12, 10, 1};
//        int arr[] = {4, 3, 8, 7, 6, 5};
//        System.out.println("합병정렬 전: ");
//        Arrays.stream(arr).forEach(x -> System.out.printf("%d " ,x));
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.recursionMergeSort(arr, 0, arr.length -1);
//        System.out.println("\n합병정렬 후: ");
//        Arrays.stream(arr).forEach(x -> System.out.printf("%d " ,x));
//    }

//    // BinarySearch
//    public static void main(String[] args) {
//        int arr[] = {1, 2, 3, 5, 6, 9, 10};
//        BinarySearch binarySearch = new BinarySearch();
//        System.out.println("(재귀)인덱스 번호: " + binarySearch.recursionBinarySearch(arr, 5,0,arr.length - 1));
//        System.out.println("(비재귀)인덱스 번호: " + binarySearch.binarySearch(arr, 5, arr.length));
//    }

    // QuickSort
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(x -> System.out.printf("%3d", x));
    }
}
