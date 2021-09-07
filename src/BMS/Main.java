/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMS;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        BookList main = new BookList();
        ArrayList<Book> t = new ArrayList<Book>();
        int check = 0;
        int inputcheck = 0;
        boolean txt = false;
        Scanner sc = new Scanner(System.in);
        String choice = "";
        //thay nhap ListBook.txt giup em thay nhe
        do{ 
            System.out.println("BOOK MANAGEMNET SYSTEM");
            System.out.println("---------------------------------------------");
            System.out.println("1.  Input & add book(s) to the end.");
            System.out.println("2.  Display all books.");
            System.out.println("3.  Search a book for given code");
            System.out.println("4.  Update the book’s price for given code.");
            System.out.println("5.  Find the (first) max price value.   ");
            System.out.println("6.  Sort the list ascendingly by code.");
            System.out.println("7.  Remove the book having given code.");
            System.out.println("8.  Load data from file.");
            System.out.println("0.  Exit.");
            System.out.print("Enter your choice: ");
            choice = sc.next();
            System.out.println("");
            
            if(choice.equalsIgnoreCase("0")){
                System.out.println("Thank you!");
                System.exit(0);
            }
            if(choice.equalsIgnoreCase("8")){
                inputcheck = 1;
            }
            if(inputcheck == 0 && !choice.equalsIgnoreCase("8")){
                do{
                    System.out.println("The system must loading data from a file frist. please enter 8!");
                    System.out.print("Enter your choice: ");
                    sc = new Scanner(System.in);
                    choice = sc.next();
                    inputcheck = 1;
                }while(!choice.equalsIgnoreCase("8"));
            }
            
            
            
            switch(choice){
                case "1":
                    main.addBook();
                    break;
                case "2":
                    main.displayBook();
                    break;
                case "3":
                    main.searchBook();
                    break;
                case "4":
                    main.updatePrice();
                    break;
                case "5":
                    main.findMaxPosition();
                    break;
                case "6":
                    main.sortList();
                    break;
                case "7":
                    main.removeBook();
                    break;
                case "8":
                    txt = false;
                    sc = new Scanner(System.in);
                    System.out.print("Enter name of file want to loading: ");
                    String fname = sc.nextLine(); 
                    if(!fname.contains(".txt")){
                        txt = true;
                    }
                    //check name file
                    if(txt){
                        do{
                            txt = false;
                            sc = new Scanner(System.in);
                            System.out.println("This file must be .txt file, please reenter!");
                            System.out.print("Enter path of file want to loading: ");
                            fname = sc.next();
                            if(!fname.contains(".txt")){
                                txt = true;
                            }
                        }while(txt);
                    }
                    //loading file
                    try {
                        if(check == 0){
                            main.loadFileFR(fname);
                            check = check + 1;
                        }
                        System.out.println("Succesfully!");
                    } catch (Exception e) {
                        System.out.println("This file not exits. but was created a new file!");
                        check = 0;
                    }
                    //saving file
                    try {
                        main.saveFileFR(fname);
                    } catch (Exception e) {
                    }
                    break;
                
                default:
                    System.out.println("Invaild of choice, please reenter!");
                    break;         
            }
            System.out.println("");
        }while(!choice.equalsIgnoreCase("0"));
    }
}
