package CountInversionInArray;
import java.util.*;
public class CountInversionInArray_{

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;     
        int right = mid + 1;   
        int cnt = 0;    //Modification 1

        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }
        while (left <= mid) {     // if elements on the left half are still left 
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {   //  if elements on the right half are still left
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr 
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int numberOfInversions(int[] a, int n) {
        return mergeSort(a, 0, n - 1); //count pairs
    }


    public static void main(String[] args) {
        int[] a = {5, 3, 2, 4, 1};
        int n = 5;
        int ans = numberOfInversions(a, n);
        System.out.println("The number of inversions are: " + ans);
    }
}
