package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of existing file: ");
        String path = scanner.nextLine();
        File fileToOpen = new File(path);

        System.out.print("Enter the path to save the new file: ");
        String newPath = scanner.nextLine();
        if(!newPath.contains(".txt")){newPath=newPath+".txt";}


        System.out.print("What word would you like to find and replace? ");
        String searchWordUser = scanner.nextLine();

        System.out.print("What word would you to insert in " + searchWordUser + "'s place? ");
        String replaceWordUser = scanner.next();

        try (Scanner inputSearch = new Scanner(fileToOpen);
             PrintWriter writer = new PrintWriter(
                     new FileWriter(newPath)
             )) {

            while (inputSearch.hasNext()) {
                String checkedLine = inputSearch.nextLine();
                if (checkedLine.contains(searchWordUser)) {
                    checkedLine = checkedLine.replace(searchWordUser, replaceWordUser);
                }
                writer.println(checkedLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist. ");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


