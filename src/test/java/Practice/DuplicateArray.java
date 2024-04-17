package Practice;

public class DuplicateArray {
    public static void main(String[] args) {

        //Initialize array
        int[] arr = {0, 14, 114, 0, 34, 55, 85, 114, 34, 1, 2, 3, 4, 2, 7, 8, 8, 3};

        System.out.println("Duplicate integers: ");

        //Searches for duplicate integers
// Outer loop:  This loop iterates through each element in the array using an index variable i.
        for (int i = 0; i < arr.length; i++) {

// Inner loop: This loop iterates through the elements after the current element (i) to avoid
// comparing the same element twice.
            for (int j = i + 1; j < arr.length; j++) {
//If the element at index i is equal to the element at index j,it means a duplicate is found
                if (arr[i] == arr[j])
 //and the value at index j is printed using System.out.println(arr[j]);.
                    System.out.println(arr[j]);
            }
        }
    }

}
// output : 0
//114
//34
//2
//3
//8