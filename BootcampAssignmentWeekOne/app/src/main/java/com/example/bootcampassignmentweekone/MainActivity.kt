package com.example.bootcampassignmentweekone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start()
    }

    private fun start(){
        // ---------- Question One ----------
        var username : String = "Koearn"
        println(usernameValidation(username))

        // ---------- Question Two ----------
        val numberArray: IntArray
        val lenofNumberArray: Int
        var error = false
        println("Enter the numbers you want, leaving spaces.")
        val numbersString: String = "1 2 3"
        val numbersWithouthSpace = numbersString.split(" ").toTypedArray()
        lenofNumberArray = numbersWithouthSpace.size
        numberArray = IntArray(lenofNumberArray)

        for (i in 0 until lenofNumberArray) {
            try {
                //System.out.println("numbers withouth space [ " + i + " ]" + numbersWithouthSpace[i]);
                numberArray[i] = numbersWithouthSpace[i].toInt()
            } catch (e: Exception) {
                println("only int numbers!")
                error = true
                break
            }
            error = false
        }
        if (!error) {
            println("Sum of numbers = " + aVeryBigSum(numberArray))
        }

        // ---------- Question Three ----------
        println("Question Three")
        println("Enter the number you want factorial of ")
        try {
            val factorialNum: Int = 5
            println(factorialNum.toString() + "'s factorial is = " + firstFactorial(factorialNum))
        } catch (e: java.lang.Exception) {
            println("enter a valid number")
        }

        // ---------- Question Four ----------
        var inputString1 : String = "arrb6???4xxbl5???eee5"
        var inputString2 : String = "acc?7??sss?3rr1?????5"
        var inputString3 : String = "1ab??cde??ab?9"

        println(questionMarks(inputString1))

    }

    private fun usernameValidation(username : String) : String{
        val len : Int = username.length
        if (4 > len || len > 25){
            return "false"
        }
        val firstLetter : Char = username.get(0)
        if (!((firstLetter.code > 64 && firstLetter.code < 91) || (firstLetter.code > 96 && firstLetter.code < 123))) {
            println("first letter is not a letter")
            return "false"
        }
        val lastLetter : Char=username.get(len-1)
        if (lastLetter.code == 95){
            println("it cannot end with underscore")
            return "false"
        }
        for (currentChar:Char in username.toCharArray()){
            var currentCharAsciiValue : Int = currentChar.code
            if (!((currentCharAsciiValue > 96 && currentCharAsciiValue < 123) || (currentCharAsciiValue > 64 && currentCharAsciiValue < 91)
                        || (currentCharAsciiValue > 47 && currentCharAsciiValue < 58)
                        || currentCharAsciiValue == 95) ) {
                println("wrong username")
                return "false"
            }
        }
        return "true"
    }

    private fun aVeryBigSum(array : IntArray) : Long{
        var sum : Long = 0
        val len : Int = array.size

        for (i in array){
            sum += i
        }
        return sum
    }

    private fun firstFactorial(factorialNum : Int) : Int{
        if (factorialNum < 1 || factorialNum > 18) {
            println("range should be between 1 and 18")
            return 1
        }
        var result = 1
        for (i in factorialNum downTo 2) {
            result *= i
        }
        return result
    }

    private fun questionMarks(inputString : String): String{
        var firstNumberIndex = -1
        var secondNumberIndex = 0
        var questionMarkCounter = 0
        val len: Int = inputString.length
        var currentIndex = 0

        while (currentIndex <= len) {
            for (i in firstNumberIndex + 1 until len) {
                if ((inputString.get(i)).code > 47 && (inputString.get(i)).code < 58) {
                    firstNumberIndex = i
                    //System.out.println("first number index = " + firstNumberIndex);
                    questionMarkCounter = 0
                    break
                }
            }
            for (i in firstNumberIndex + 1 until len) {
                if ((inputString.get(i)).code > 47 && (inputString.get(i)).code < 58) {
                    secondNumberIndex = i
                    //System.out.println("second number index = " + secondNumberIndex);
                    break
                }
            }
            for (i in firstNumberIndex + 1 until secondNumberIndex) {
                if ((inputString.get(i)).code == 63) {
                    questionMarkCounter++
                    //System.out.println("question mark counter" +questionMarkCounter);
                    //System.out.println("question mark pos = " + i);
                }
            }
            if (questionMarkCounter == 3) {
                val firstNumber: Int =
                    Character.getNumericValue(inputString.get(firstNumberIndex))
                val secondNumber: Int =
                    Character.getNumericValue(inputString.get(secondNumberIndex))
                questionMarkCounter = if (firstNumber + secondNumber == 10) {
                    return "True"
                } else 0
            }
            currentIndex++
        }
        return "False"
    }
}