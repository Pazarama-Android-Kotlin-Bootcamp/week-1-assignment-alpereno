package com.mycompany.bootcampassignmentone;

import java.util.ArrayList;
import java.util.Scanner;

public class BootcampAssignmentOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //-------------------------------------------- 1 ------------
        System.out.println("Question One");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println(usernameValidation(username));
//        
//        //--------------------------------------------- 2 -----------
        System.out.println("Question Two");
        int[] numberArray;
        int lenofNumberArray;
        boolean error = false;
        System.out.println("Enter the numbers you want, leaving spaces.");
        String numbersString = scanner.nextLine();
        String[] numbersWithouthSpace = numbersString.split(" ");
        lenofNumberArray = numbersWithouthSpace.length;
        numberArray = new int[lenofNumberArray];
        
        for (int i = 0; i < lenofNumberArray; i++) {
            try{
               //System.out.println("numbers withouth space [ " + i + " ]" + numbersWithouthSpace[i]);
               numberArray[i] = Integer.parseInt(numbersWithouthSpace[i]);
            }
            catch(Exception e){
                System.out.println("only int numbers!");
                error = true;
                break;
            }
            error = false;
        }
        if(!error){
            System.out.println("Sum of numbers = " + aVeryBigSum(numberArray));
        }
        
//        //------------------------------------------------- 3 -------------
        System.out.println("Question Three");
        System.out.println("Enter the number you want factorial of ");
        try{
            int factorialNum =scanner.nextInt();            
            System.out.println(factorialNum + "'s factorial is = " + firstFactorial(factorialNum));
        }
        catch(Exception e){
            System.out.println("enter a valid number");
        }

        //--------------------------------------------------- 4 ----------------
        System.out.println("Question Four");
//        String inputString = "arrb6???4xxbl5???eee5";
//        String inputString2 = "acc?7??sss?3rr1?????5";
//        String inputString3 = "1ab??cde??ab?9";
        System.out.println("Input String: ");
        String inputString = scanner.next();
        System.out.println(questionMarks(inputString));
        
    }
    
    public static String usernameValidation(String username){
        int len = username.length();
        
        if (4 > len || len > 25) {
            return "false";
        }
        
        char firstLetter = username.charAt(0);
        if (!(((int)firstLetter > 64 && (int)firstLetter < 91) || ((int)firstLetter > 96 && (int)firstLetter < 123))) {
            System.out.println("first letter is not a letter");
            return "false";
        }
        
        char lastLetter = username.charAt(len-1);
        if ((int)lastLetter == 95) {
            System.out.println("it cannot end with underscore");
            return "false";
        }
        
        for(char currentChar : username.toCharArray()){
            int currentCharAsciiValue = (int)currentChar;
            if (!((currentCharAsciiValue > 96 && currentCharAsciiValue < 123) || (currentCharAsciiValue > 64 && currentCharAsciiValue < 91) 
                    || (currentCharAsciiValue > 47 && currentCharAsciiValue < 58) 
                    || currentCharAsciiValue == 95) ) {
                System.out.println("wrong username");
                return "false";
            }
        }
        return "true";
    }
    
    public static long aVeryBigSum(int[] array){
        long sum = 0;
        int len = array.length;
        
        for (int i = 0; i < len; i++) {
            sum +=array[i];
        }
        return sum;
    }
    
    public static int firstFactorial(int factorialNum){
        if (factorialNum < 1 || factorialNum > 18) {
            System.out.println("range should be between 1 and 18");
            return 1;
        }
        int result=1;
        for (int i = factorialNum; i > 1; i--) {
            result*=i;
        }
        return result;
    }
    
    public static String questionMarks(String inputString){
        // reset question mark counter when firs and second values changed.
        int firstNumberIndex = -1;
        int secondNumberIndex = 0;
        int questionMarkCounter = 0;
        int len = inputString.length();
        int currentIndex = 0;
        while(currentIndex <= len){
            for (int i = firstNumberIndex+1; i < len; i++) {
                if (((int)inputString.charAt(i) > 47) && ((int)inputString.charAt(i) < 58)) {
                    firstNumberIndex=i;
                    //System.out.println("first number index = " + firstNumberIndex);
                    questionMarkCounter = 0;
                    break;
                }
            }
            for (int i = firstNumberIndex+1; i < len; i++) {
                if (((int)inputString.charAt(i) > 47)&& ((int)inputString.charAt(i) < 58)) {
                    secondNumberIndex=i;
                    //System.out.println("second number index = " + secondNumberIndex);
                    break;
                }
            }
            for (int i = firstNumberIndex+1; i < secondNumberIndex; i++) {
                if ((int)inputString.charAt(i) == 63) {                    
                    questionMarkCounter++;
                    //System.out.println("question mark counter" +questionMarkCounter);
                    //System.out.println("question mark pos = " + i);
                }
            }
            if (questionMarkCounter == 3) {
                int firstNumber = Character.getNumericValue(inputString.charAt(firstNumberIndex));
                int secondNumber = Character.getNumericValue(inputString.charAt(secondNumberIndex));
                if (firstNumber + secondNumber == 10) {
                    return "True";
                }
                else questionMarkCounter = 0;
            }
            currentIndex++;
        }      
        return "False";
    }
}