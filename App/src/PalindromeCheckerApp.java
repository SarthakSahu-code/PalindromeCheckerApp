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

class PalindromeService {
    private String text;

    public PalindromeService(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        if (this.text == null) {
            return false;
        }
        int left = 0;
        int right = this.text.length() - 1;

        while (left < right) {
            if (this.text.charAt(left) != this.text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getText() {
        return text;
    }
}

/**
 * INTERFACE - PalindromeStrategy
 */
interface PalindromeStrategy {
    boolean validate(String text);
}

/**
 * CLASS - StackStrategy
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean validate(String text) {
        if (text == null) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.validate(text);
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
         * Description:
         * This use case initializes the application and
         * displays a welcome message to the user.
         *
         * @author Developer
         * @version 1.0
         * @param args Command-line arguments
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
         *
         * Description:
         * This block demonstrates a basic loop-based
         * palindrome check comparing characters from ends
         * towards the center.
         *
         * @author Developer
         * @version 2.0
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
         *
         * Description:
         * This approach manually constructs a reversed
         * string and compares it to the original input.
         *
         * @author Developer
         * @version 3.0
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
         *
         * Description:
         * This use case utilizes a two-pointer technique on a
         * character array representation of the string.
         *
         * @author Developer
         * @version 4.0
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
         *
         * Description:
         * This block demonstrates checking for a palindrome
         * using a Stack's LIFO (Last-In-First-Out) property.
         *
         * @author Developer
         * @version 5.0
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
         * Use Case 6: Queue + Stack Based Palindrome Checker
         *
         * Description:
         * This class measures and compares the execution
         * performance of palindrome validation algorithms
         * using both a Stack and a Queue.
         *
         * At this stage, the application:
         * - Uses a Stack (LIFO) and Queue (FIFO) structure
         * - Pushes and adds characters respectively
         * - Pops and removes characters respectively
         * - Compares the outputs from both structures
         *
         * This use case focuses purely on combining
         * standard data structures to solve the problem.
         *
         * The goal is to demonstrate multi-structure logic.
         *
         * @author Developer
         * @version 6.0
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
         *
         * Description:
         * This approach leverages a Double-Ended Queue (Deque)
         * to efficiently compare characters from both ends.
         *
         * @author Developer
         * @version 7.0
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
         *
         * Description:
         * This block handles checking for a palindrome when the
         * data is stored in a custom singly linked list.
         *
         * @author Developer
         * @version 8.0
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
         *
         * Description:
         * This block utilizes a recursive function to
         * evaluate if the string is a palindrome.
         *
         * @author Developer
         * @version 9.0
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
         *
         * Description:
         * This use case strips whitespace from the input
         * before performing the palindrome check.
         *
         * @author Developer
         * @version 10.0
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
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase11PalindromeCheckerApp
         * =====================================================
         *
         * Use Case11: Object Oriented Palindrome Service
         *
         * Description:
         * This block instantiates a PalindromeService object
         * to perform the validation, encapsulating state and behavior.
         *
         * @author Developer
         * @version 11.0
         */
        PalindromeService palindromeService = new PalindromeService(input);

        if (palindromeService.isPalindrome()) {
            System.out.println("OOP Service check: \"" + palindromeService.getText() + "\" is a palindrome.");
        } else {
            System.out.println("OOP Service check: \"" + palindromeService.getText() + "\" is not a palindrome.");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase12PalindromeCheckerApp
         * =====================================================
         *
         * Use Case 12: Strategy Pattern for Palindrome Algorithms
         *
         * Description:
         * This class demonstrates how different palindrome
         * validation algorithms can be selected dynamically
         * at runtime using the Strategy Design Pattern.
         *
         * At this stage, the application:
         * - Defines a common PalindromeStrategy interface
         * - Implements a concrete Stack based strategy
         * - Injects the strategy at runtime
         * - executes the selected algorithm
         *
         * No performance comparison is done in this use case.
         * The focus is purely on algorithm interchangeability.
         *
         * The goal is to teach extensible algorithm design.
         *
         * @author Developer
         * @version 12.0
         */
        PalindromeContext context = new PalindromeContext(new StackStrategy());

        if (context.executeStrategy(input)) {
            System.out.println("Strategy Pattern check: \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("Strategy Pattern check: \"" + input + "\" is not a palindrome.");
        }
//-------------------------------------------------------------------------------------------------
        /**
         * =====================================================
         * MAIN CLASS - UseCase13PalindromeCheckerApp
         * =====================================================
         *
         * Use Case 13: Performance Comparison
         *
         * Description:
         * This class measures and compares the execution
         * performance of palindrome validation algorithms.
         *
         * At this stage, the application:
         * - Uses a palindrome strategy implementation
         * - Captures execution start and end time
         * - Calculates total execution duration
         * - Displays benchmarking results
         *
         * This use case focuses purely on performance
         * measurement and algorithm comparison.
         *
         * The goal is to introduce benchmarking concepts.
         *
         * @author Developer
         * @version 13.0
         */
        PalindromeContext benchmarkContext = new PalindromeContext(new StackStrategy());

        long startTime = System.nanoTime();
        boolean benchmarkResult = benchmarkContext.executeStrategy(input);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + benchmarkResult);
        System.out.println("Execution Time : " + executionTime + " ns");

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