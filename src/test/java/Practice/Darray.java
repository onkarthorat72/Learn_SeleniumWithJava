package Practice;

public class Darray {
    public static void main(String[] args) {
     int []arr = {0,1,2,3,4,0,8,9,2,7,4,56,21,56,2,89};

        System.out.println(" Duplicate values: ");

        for (int i = 0; i<arr.length; i++){
            for (int j = i+1; j<arr.length; j++ )
                if (arr[i] == arr [j])
                    System.out.println(arr[j]);

        }





    }
}
