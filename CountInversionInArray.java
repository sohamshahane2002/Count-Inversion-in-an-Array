//Brute Force
package CountInversionInArray;

public class CountInversionInArray {
    public static int numberOfInversions(int[] arr, int n){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                if(arr[i] >  arr[j])
                cnt++; 
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int arr []= { 5,4,3,2,1};
        int n = 5;
        int ans = numberOfInversions(arr, n);
        System.out.println("The number of inversions is : " + ans);
    }
}
