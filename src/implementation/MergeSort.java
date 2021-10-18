package implementation;

import java.util.Arrays;

public class MergeSort {
    private static int sorted[] = new int[30];

    public void merge(int arr[], int low, int middle, int high) {

        int left = low;
        int right = middle + 1;
        int current = low;

        while(left <= middle && right <= high) {
            if(arr[left] <= arr[right]) {
                sorted[current++] = arr[left++];
            } else {
                sorted[current++] = arr[right++];
            }
        }
        if(left > middle) {
            for(int i = right; i <= high; i++) {
                sorted[current++] = arr[i];
            }
        } else {
            for(int i = left; i <= middle; i++) {
                sorted[current++] = arr[i];
            }
        }
        for(int i = low; i <= high; i++) {
            arr[i] = sorted[i];
        }
    }
    public void recursionMergeSort(int arr[], int low, int high) {
        if(low < high) {
            int middle = (low + high) / 2;
            recursionMergeSort(arr, low, middle);
            recursionMergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }
}
