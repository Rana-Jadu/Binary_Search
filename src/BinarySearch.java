import java.util.Scanner;

public class BinarySearch{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array (should be sorted in ascending order):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (!isSorted(arr)) {
            System.out.println("Error: The entered array is not sorted. Binary search requires a sorted array.");
            return;
        }

        System.out.print("Enter the element to search: ");
        int key = scanner.nextInt();

        int result = binarySearch(arr, key);

        if (result == -1) {
            System.out.println("Element is not found!");
        } else {
            System.out.println("Element found at index: " + result);
        }

        scanner.close();
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}