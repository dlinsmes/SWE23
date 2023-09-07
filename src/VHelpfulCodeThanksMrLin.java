import java.util.Scanner;
public class VHelpfulCodeThanksMrLin {
    static Scanner s = new Scanner(System.in);
    public static int intInput() {
        String uInput = s.nextLine();
        try{
            return Integer.parseInt(uInput);
        }
        catch (Exception e) {
            System.out.println("not a number. try again.");
            return intInput();
        }
    }

    public static int stringToInt(String letter){
        //char data type - a single character
        char c = letter.toLowerCase().charAt(0);

        //calculate ASCII offset of letter held by c from lowercase 'a'
        return c - 'a';
    }

    public static void main(String[] args) {

        //print letters
        for (int i = 0; i < 26; i++)
            System.out.print((char)('A' + i) + " ");
        System.out.println();

        System.out.println("enter a number");
        int input = intInput();
        System.out.println(input + " is a number");

        System.out.println("enter a letter");
        String let = s.nextLine();
        int num = stringToInt(let);
        System.out.println(let + " was converted to " + num);

    }


}