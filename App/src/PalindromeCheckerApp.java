import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    char val;
    ListNode next;

    ListNode(char val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args){
        /**
         * ==================================================
         * MAIN CLASS - UseCase1PalindromeCheckerApp
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
         * MAIN CLASS - UseCase2PalindromeCheckerApp
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
         * MAIN CLASS - UseCase3PalindromeCheckerApp
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
         * MAIN CLASS - UseCase4PalindromeCheckerApp
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
                break;
            }

            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a Palindrome.");
        }
//---------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase5PalindromeCheckerApp
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
         * MAIN CLASS - UseCase6PalindromeCheckerApp
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
         * MAIN CLASS - UseCase7PalindromeCheckerApp
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
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase8PalindromeCheckerApp
         * =====================================================
         *
         * Use Case8: Linked List Based Palindrome Checker
         */
        ListNode head = buildList(input);

        if (isLinkedListPalindrome(head)) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a Palindrome.");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase9PalindromeCheckerApp
         * =====================================================
         *
         * Use Case9: Recursive Palindrome Checker
         */
        if (isPalindromeRecursive(input, 0, length - 1)) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a Palindrome.");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase10PalindromeCheckerApp
         * =====================================================
         *
         * Use Case10: Normalized Palindrome Validation
         */
        String normalizedInput = input.replaceAll("\\s+", "");
        boolean isNormalizedPalindrome = true;
        int normLength = normalizedInput.length();

        for (i = 0; i < normLength / 2; i++) {
            if (normalizedInput.charAt(i) != normalizedInput.charAt(normLength - i - 1)) {
                isNormalizedPalindrome = false;
                break;
            }
        }

        if (isNormalizedPalindrome) {
            System.out.println("The normalized string \"" + normalizedInput + "\" is a palindrome.");
        } else {
            System.out.println("The normalized string \"" + normalizedInput + "\" is not a palindrome.");
        }

        sc.close();
    }

    public static boolean isLinkedListPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;

        while (secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static ListNode buildList(String str) {
        if (str == null || str.length() == 0) return null;

        ListNode head = new ListNode(str.charAt(0));
        ListNode current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new ListNode(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    public static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}