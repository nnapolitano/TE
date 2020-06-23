package com.techelevator;

import java.util.*;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MartianWeight martianWeight = new MartianWeight();
        martianWeight.MarsWeightCculation();

    }

    public void MarsWeightCculation() {
        String weightOnEarth;


        System.out.print("Enter a series of Earth weights (space-separated): ");
        weightOnEarth = scanner.nextLine();
        String[] separatedWeights = weightOnEarth.split(" ");  //space delimiter to put spaces between values

        for (String i : separatedWeights) {

            int weightEarth = Integer.parseInt(i);
            int weightOnMars = (int) (weightEarth * 0.378);

            System.out.println(weightEarth + " lbs. on Earth, is " + weightOnMars + " lbs. on Mars");
        }
    }

}
