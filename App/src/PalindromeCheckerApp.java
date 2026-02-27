import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

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
//-------------------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         *       MAIN CLASS - UseCase3PalindromeCheckerApp
         * =====================================================
         *
         * Use Case3: Reverse String Based Palindrome Check
         */
        String reversedStr = "";

        for (i = length - 1; i >= 0; i--) {
            reversedStr = reversedStr + input.charAt(i);
        }
        if (input.equals(reversedStr)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is not a Palindrome.");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         *       MAIN CLASS - UseCase4PalindromeCheckerApp
         * =====================================================
         *
         * Use Case4: Character Array based validation
         */
        char[] charArray = input.toCharArray();

        int left = 0;
        int right = length - 1;
        isPalindrome = true;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break; // Exit the loop early
            }

            // Move pointers toward the center
            left++;
            right--;
        }

        // 5. Output the result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a Palindrome.");
        }
//---------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         *       MAIN CLASS - UseCase5PalindromeCheckerApp
         * =====================================================
         *
         * Use Case5: Stack Based Palindrome Checker
         */

        Stack <Character> stack = new Stack<>();
        for (i=0; i<length; i++) {
            stack.push(input.charAt(i));
        }
        isPalindrome = true;
        for (i=0; i<input.length(); i++){
            char reversedChar = stack.pop();
            if (input.charAt(i) != reversedChar) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("'" + input + "' " + "word is a palindrome.");
        }
        else{
            System.out.println("'" + input + "' " + "word is not a palindrome.");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         *       MAIN CLASS - UseCase6PalindromeCheckerApp
         * =====================================================
         *
         * Use Case6: Queue + Stack Based Palindrome Checker
         */
        Queue <Character> queue = new LinkedList<>();
        for (i=0; i<length; i++){
            char c = input.charAt(i);
            stack.push(c);
            queue.add(c);
        }
        isPalindrome =true;
        while (!queue.isEmpty()){
            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            if(fromQueue!=fromStack){
                isPalindrome=false;
                break;
            }
        }

        if (isPalindrome){
            System.out.println("The word "+ input +" is a palindrome");
        }
        else{
            System.out.println("The word "+ input +" is not a palindrome");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         *       MAIN CLASS - UseCase7PalindromeCheckerApp
         * =====================================================
         *
         * Use Case7: Deque based optimized palindrome checker
         */
        Deque<Character> deque = new ArrayDeque<>();
        for (i=0; i<length; i++){
            deque.add(input.charAt(i));
        }
        isPalindrome = true;
        while (deque.size()>1){
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if(first!=last){
                isPalindrome=false;
                break;
            }
        }
        if (isPalindrome){
            System.out.println( input +" is a palindrome word.");
        }
        else{
            System.out.println( input +" is not a palindrome word.");
        }
    }
}
