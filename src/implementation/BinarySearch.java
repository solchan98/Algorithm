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

    public int binarySearch(int arr[], int target, int size) {
        int low = 0;
        int high = size - 1;

        while(low <= high) {
            int middle = (low + high) / 2;
            if(arr[middle] == target) return middle;
            else if(arr[middle] > target) high = middle - 1;
            else if(arr[middle] < target) low = middle + 1;
        }
        return -1;
    }
}
