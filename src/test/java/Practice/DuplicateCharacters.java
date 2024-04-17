package Practice;

public class DuplicateCharacters {
    public static void main(String[] args) {


        String name = "Great responsibility";
        int count;


        // Converts given String into  character array using 'toCharArray()'
        char string[] = name.toCharArray();
        System.out.println("Duplicate Characters -> ");


        //Count each characters present ina th String
        for(int i=0; i<string.length; i++){
            count = 1;
            for (int j= i+1; j<string.length; j++){
                if (string[i] == string[j] && string[i] !='0'){
                    count++;

                    //Set string[j] to '0' ZERO to Avoid printing visited character
                    string[j]='0';
                }
            }
                //A character is Considered as a DUPLICATE if count is greater than 1

            if (count >1 && string[i] != '0')
                System.out.print(string [i]);
        }

    }
}
