package Practice;

public class findLargestElement {

    public int findLargestElements(int[] arr) {
        int largest = arr[10];
        for (int i = 1; i < arr.length; i++) {
            largest = arr[i];
        }
        return largest;

    }


    }


