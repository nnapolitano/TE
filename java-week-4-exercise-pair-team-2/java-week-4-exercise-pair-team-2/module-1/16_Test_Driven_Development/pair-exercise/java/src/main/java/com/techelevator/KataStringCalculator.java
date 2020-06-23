package com.techelevator;

public class KataStringCalculator {

    int add(String numbers) {
        boolean checkNoLength = numbers.isEmpty();
        if (checkNoLength) {
            return 0;
        }

        int sum = 0;
/*TODO

Fix this:

 */
        if (numbers.length() > 1 && numbers.substring(0, 2).equals("//")) {
            String tempDelimiter = (numbers.substring(2, 3) + ","+"\n");
         //   String[] delimiters = {",", "\n", tempDelimiter};

            String[] stringNumberArray = numbers.split(tempDelimiter);

            int[] intNumberArray = new int[stringNumberArray.length];

            for (int i = 2; i < stringNumberArray.length; i++) {
                intNumberArray[i] = Integer.parseInt(stringNumberArray[i]);
            }
            for (int i : intNumberArray) {
                sum += i;
            }
            return sum;

            //This works:
        } else {
            String[] stringNumberArray = numbers.split("[,|\n]");
            int[] intNumberArray = new int[stringNumberArray.length];
            for (int i = 0; i < stringNumberArray.length; i++) {
                intNumberArray[i] = Integer.parseInt(stringNumberArray[i]);
            }
          //  int sum = 0;
            for (int i : intNumberArray) {
                sum += i;
            }
            return sum;

        }

//
//        int[] intNumberArray = new int[stringNumberArray.length];
//        for (int i = 0; i < stringNumberArray.length; i++) {
//            intNumberArray[i] = Integer.parseInt(stringNumberArray[i]);
//        }
//        int sum = 0;
//        for (int i : intNumberArray) {
//            sum += i;
//        }
//        return sum;
    }


}
