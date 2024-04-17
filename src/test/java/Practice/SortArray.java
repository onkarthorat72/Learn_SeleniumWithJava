package Practice;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int [] arr = {64, 34, 25, 12, 22, 11, 90 };

        // Sort the array
        Arrays.sort(arr);

        //Print the sorted Array
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
