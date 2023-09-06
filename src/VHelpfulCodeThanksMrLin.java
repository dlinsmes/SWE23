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

        //calculate ASCII offset of var c from lowercase 'a'
        return c - 'a';
    }

    public static void main(String[] args) {

        System.out.println("enter a number");
        int input = intInput();
        System.out.println(input + " is a number");

        System.out.println("enter a letter");
        String let = s.nextLine();
        int coord = stringToInt(let);
        System.out.println(let + " was converted to " + coord);

    }


}