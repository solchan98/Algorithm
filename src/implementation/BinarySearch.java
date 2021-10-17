package implementation;

public class BinarySearch {
    public int recursionBinarySearch(int arr[], int target, int low, int high) {
        if(low <= high) {
            int middle = (low + high) / 2;
            if (target == arr[middle]) return middle;
            else if (target < arr[middle]) return recursionBinarySearch(arr, target, low, middle - 1);
            else if (target > arr[middle]) return recursionBinarySearch(arr, target, middle + 1, high);
        }
        return -1;
    }
}
