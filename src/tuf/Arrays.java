package tuf;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class Arrays {

    public static void main(String[] args) {

        brute_secondLargest();
        optimal_secondLargest();
        brute_secondSmallest();
        optimal_secondSmallest();
        checkArrIsSorted();
        removeDuplicatesInaSortedArrInPlace();
//        brute_leftRotateArrayByNPlaces();
        optimal_leftRotateArrayByNPlaces();
        moveZeroesToEnd();
        unionOftwoSortedArrays();
    }


    public  static void brute_secondLargest() {
        int[] arr = { 1,2,4,5,3,6,7,7,9,8};

        int largest = arr[0];

        for (int i = 1; i< arr.length;i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        int secondLargest = -1;

        for(int i = 0; i< arr.length; i++) {
            if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println(secondLargest);
    }

    public static void optimal_secondLargest() {
        int[] arr = { 1,2,4,5,3,6,7,7,9,8};
        //assuming array with positive numbers and duplicates
        int largest = arr[0];
        int secondLargest = -1;

        for (int i= 1; i<arr.length;i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
        }

        if(arr[arr.length - 1] > secondLargest) {
            secondLargest = arr[arr.length - 1];
        }

        System.out.println(secondLargest);
    }

    public static void brute_secondSmallest() {
        int[] arr = { 1,2,4,5,3,6,7,7,9,8};
        int smallest = arr[0];

        for(int i = 1; i< arr.length;i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > smallest && arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }

        System.out.println(secondSmallest);

    }
    public static void optimal_secondSmallest() {
        int[] arr = { 2,1,2,4,5,3,6,7,7,9,8};
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length;i++) {

            if(arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] > smallest && arr[i] < secondSmallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }

        }

        System.out.println(secondSmallest);

    }

    public static void checkArrIsSorted() {

        int[] arr = {1,1,2,2,2,3,3};

        boolean isSorted  = false;

        for(int i = 1; i< arr.length;i++) {
            isSorted = arr[i] >= arr[i-1];

            if(!isSorted) {
                break;
            }

        }

        System.out.println(isSorted);

    }

    public static void removeDuplicatesInaSortedArrInPlace(){
        int[] arr = {1,1,2,2,2,3,3,3,4,5,6,6,7,7,8};
        int i = 0;
        int j = 1;

        while (j<arr.length) {
            if(arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
            j++;
        }
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println(++i);

    }
    public static void brute_leftRotateArrayByNPlaces() {
        int[] arr = {1,2,3,4,5,6,7,8};

        int n = 3;

        n = n % arr.length;

        int[] temp = new int[n];

        for(int i = 0; i< temp.length; i++) {
            temp[i] = arr[i];
        }

        for(int i = 0; i< n; i++) {
            arr[i] = arr[n+i];
        }

        for(int i = temp.length, j = 0;  i < arr.length; i++) {
            arr[i] = temp[j++];
        }

        System.out.println(java.util.Arrays.toString(arr));

    }

    public static void optimal_leftRotateArrayByNPlaces() {
        int[] arr = {1,2,3,4,5,6,7,8};

        int n = 10;

        n = n % arr.length;

        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length -1);
        reverse(arr, 0 , arr.length - 1);

        System.out.println(java.util.Arrays.toString(arr));

    }

    public static void reverse(int[] arr, int i, int j) {
        while (i<=j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void moveZeroesToEnd() {
        int[] arr = {3,2,0,4,2,0,0,8,0,1,2,0,5};

        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if(arr[i] != 0) {
                i++;
            } else if(arr[j] != 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
            }

            j++;
        }

        System.out.println(java.util.Arrays.toString(arr));

    }

    public static void unionOftwoSortedArrays() {
        int[] a = {1,2,3,4,5,6};
        int[] b = {2,3,4,5,6};

        Set<Integer> temp = new HashSet<>();

        for(int i=0; i< a.length;i++) {
            temp.add(a[i]);
        }

        for(int i = 0;i<b.length;i++) {
            temp.add(b[i]);
        }

        System.out.println(temp);
    }
}
