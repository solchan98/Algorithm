package implementation;

public class QuickSort {

    private void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private int partition(int arr[], int low, int high) {
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

    public void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int s = partition(arr, low, high);
            quickSort(arr, low, s - 1);
            quickSort(arr, s + 1, high);
        }
    }
}
