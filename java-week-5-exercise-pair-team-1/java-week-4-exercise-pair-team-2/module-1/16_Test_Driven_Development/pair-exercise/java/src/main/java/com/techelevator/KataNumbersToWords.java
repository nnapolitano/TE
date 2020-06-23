package com.techelevator;

public class KataNumbersToWords {
    public String kataNumbers(int number) {
        String result = "";

        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "one hundred" , "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};

//        String hundreds = ones[number] + "hundred";

        if (number == 0){
            return "zero";
        }

        if (number < 0) {
            result = "negative ";
            number = number * -1;
        }

        if (number >= 20000) {
            result = tens[number / 10000] + " thousand ";
            number = number % 1000;
        }

        if (number >= 1000) {
            result = ones[(number / 1000)] + " thousand ";
            number = number % 1000;
        }


        if (((number / 100) > 0)) {
            result = result + ones[number / 100] + " hundred " ;
            number %= 100;

        }

        if (number / 10 > 20) {
            result = result + tens[(number / 10)];
            number = number % 10;
        } if (number > 0){
            result = result + ones[number];
        }

if(result.substring(result.length()-1).equals(" ")){
    result = result.substring(0,result.length()-1);
}


        return result;


        //  return ones[number] + "hundred" + result;


        //  result = result + ones[number];
        // return result;
    }

}




