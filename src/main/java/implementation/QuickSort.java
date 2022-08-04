package implementation;

public class QuickSort {

    /* QuickSort for Integer */
    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int s = partition(arr, low, high);
            quickSort(arr, low, s - 1);
            quickSort(arr, s + 1, high);
        }
    }
    
    /* QuickSort for Word */
    public void quickSort(String[] arr, int low, int high) {
        if(low < high) {
            int s = partition(arr, low, high);
            quickSort(arr, low, s - 1);
            quickSort(arr, s + 1, high);
        }
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private int partition(int[] arr, int low, int high) {
        int left = low + 1;
        int right = high;

        while(left <= right) {
            if(arr[left] <= arr[low])
                left++;
            else if(arr[right] > arr[low])
                right--;
            else
                swap(arr, left++, right--);
        }
        swap(arr, low, right);
        return right;
    }

    private int partition(String[] arr, int low, int high) {
        int left = low + 1;
        int right = high;
        while(left <= right) {
            if(arr[left].charAt(0) <= arr[low].charAt(0)) {
                left++;
            } else if(arr[right].charAt(0) > arr[low].charAt(0)) {
                right--;
            } else {
                swap(arr, left++, right--);
            }
        }
        swap(arr, low, right);
        return right;
    }
}
