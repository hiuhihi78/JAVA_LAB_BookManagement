/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BMS;

import java.io.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class BookList {
    ArrayList<Book> t;

    public BookList() {
        t = new ArrayList<Book>();
    }
    
    
    public void addBook(){
        boolean check = false;
        Book book = new Book();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new book: ");
        do{
            System.out.print("Enter code: ");
            book.setCode(sc.next());
            check = false;
            for(int i = 0; i < t.size() ; i++){
                if(book.getCode().equalsIgnoreCase(t.get(i).getCode())){
                    check = true;
                    System.out.println("this code was already have, please reeter!");
                }
            }
        }while(check);
        sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        book.setTitle(sc.nextLine());
        System.out.print("Enter quality: ");
        sc = new Scanner(System.in);
        book.setQua(sc.nextInt());
        System.out.print("Enter price: ");
        sc = new Scanner(System.in);
        book.setPrice(sc.nextDouble());
        t.add(book);
        System.out.println("");
        System.out.println("This book has been added in list book!");
    }
    
    public void displayBook(){
        if(t.size() > 0){
            System.out.println("         INFORMATION OF LIST BOOK");
            System.out.println("-----------------------------------------");
        }
        for(int i = 0; i < t.size(); i++){
            System.out.println(t.get(i));
        }
        if(t.size() == 0){
            System.out.println("List of book is empty!");
        }
    }
    
    public void searchBook (){
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book's code want to find: ");
        String findCode = sc.nextLine();
        for(int i = 0; i < t.size(); i++){
            if(findCode.equalsIgnoreCase(t.get(i).getCode())){
                Book x = t.get(i);
                System.out.println("Information of book: (Code: " + x.getCode() + ", title: " + x.getTitle()
                                + ",quality: " + x.getQua() + ", price: " + x.getPrice() + ")");
                check = true;
            }
        }
        if(check == false){
            System.out.println("Invial of code!Please return program!");
        }
    }
    
    public void updatePrice(){
        boolean check = false;
        check = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book's code want to update price: ");
        String findCode = sc.nextLine();
        for(int i = 0; i < t.size(); i++){
            if(findCode.equalsIgnoreCase(t.get(i).getCode())){
                check = true;
            }
        }
        if(check ==true){
            System.out.print("Enter new book's price: ");
            double newPirce = sc.nextDouble();
            for(int i = 0; i < t.size(); i++){
                if(findCode.equalsIgnoreCase(t.get(i).getCode())){
                    t.get(i).setPrice(newPirce);
                    System.out.println("The price of the book has been changed!");
                    check = true;
                }
            }
        }
        if(check == false){
            System.out.println("Invial of code!Please return program!");
        }
    }
    
    public void findMaxPosition(){
        double maxPrice = 0;
        int maxIndex = 0;
        if(t.size() > 0){
            for(int i = 0 ; i < t.size(); i++){
                if(t.get(i).getPrice() > maxPrice){
                maxPrice = t.get(i).getPrice();
                maxIndex = i;
                }
            }
            System.out.println("The position frist max price of book in this list is " + maxIndex);
            Book x = t.get(maxIndex);
            System.out.println("Information of book: (Code: " + x.getCode() + ", title: " + x.getTitle()
                                + ",quality: " + x.getQua() + ", price: " + x.getPrice() + ")");
        }else{
            System.out.println("List of book is empty!");
        }
    }
    
    public void sortList(){
        Collections.sort(t, new Comparator<Book>() {
            @Override
            public int compare(Book t, Book t1) {
                int book1 = Integer.parseInt(t.getCode());
                int book2 = Integer.parseInt(t1.getCode());
                if(book1 > book2){
                    return 1;
                }else if(book1 <book2){
                    return -1;
                }else{
                    return  0;
                }
            }
        });
        System.out.println("List of book has been sorted!");
    }
    
    public void removeBook(){
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book's code want to remove: ");
        String findCode = sc.nextLine();
        for(int i = 0; i < t.size(); i++){
            if(findCode.equalsIgnoreCase(t.get(i).getCode())){
                t.remove(i);
                System.out.println("The book has been remove in list!");
                check = true;
            }
        }
        if(check == false){
            System.out.println("Invial of code!Please return program!");
        }
        
    }
    
    public void add(Book x){
        t.add(x);
    }
        
    public void loadFileFR(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s; String [] a;
        String ID, name;
        int qua = 0;
        double price = 0;
        while(true) {
            s = br.readLine();
            if(s==null || s.trim().length()<4) {
                break;
            }
            a = s.split("\t");
            ID = a[0].trim();
            name = a[1].trim();
            qua = Integer.parseInt(a[2].trim());
            price = Double.parseDouble(a[3].trim());
            add(new Book(ID, name, qua, price));
            
        }
        
        fr.close();
        br.close();
 }
        
    public void saveFileFR( String fname) throws IOException{
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
       
       int n,i; Book x;
        n = t.size();
        for(i=0;i<n;i++) {
            x = t.get(i);
            pw.printf("%s\t%s\t%d\t%.1f\r\n",x.getCode(),x.getTitle(),x.getQua(),x.getPrice());
        }
        fw.close();
        pw.close();
    }    
    
}


