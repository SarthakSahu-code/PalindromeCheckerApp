import java.util.Scanner;
public class PalindromeCheckerApp {

    public static void main(String[] args){
        /**
         * ==================================================
         *      MAIN CLASS - UseCase1PalindromeCheckerApp
         * ==================================================
         *
         * Use Case1: Application Entry and Welcome Message
         *
         * @param args
         */
        System.out.println("Welcome to Palindrome Checker App Management System");
        System.out.println("Version: 1.0");
        /**
         * =====================================================
         *       MAIN CLASS - UseCase2PalindromeCheckerApp
         * =====================================================
         *
         * Use Case2: Hardcoded Palindrome Validation
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Text:");
        String input = sc.nextLine();
        int i;
        input = input.toLowerCase();
        boolean isPalindrome = true;
        int length = input.length();
        for (i=0; i<length/2; i++){
            if (input.charAt(i) != input.charAt(length-i-1)){
                isPalindrome = false; break;
            }
        }
        if (isPalindrome){
            System.out.println("Is it a palindrome: True");}
        else{
            System.out.println("Is it a palindrome: False");
        }
    }
}