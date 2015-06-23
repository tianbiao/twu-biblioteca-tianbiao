package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public final static int MENU_LIST_BOOKS = 1;
    public final static int MENU_CHECK_OUT_BOOK = 2;
    public final static int MENU_RETURN_BOOK = 3;
    public final static int MENU_LIST_MOVIES = 4;
    public final static int MENU_CHECK_OUT_MOVIE = 5;
    public final static int MENU_QUIT = 6;

    public final static int UserLoginInfoLength = 2;
    public final static int UserInfoLength = 5;
    public static List<User> userLists = new ArrayList<User>();
    public static List<User> userListsBackup = new ArrayList<User>();
    public static User userTemp = new User();

    public final static int BookInfoLength = 3;
    public static List<Book> bookLists = new ArrayList<Book>();
    public static List<Book> bookListsBackup = new ArrayList<Book>();
    public static Book bookTemp = new Book();

    public final static int MovieInfoLength = 4;
    public static List<Movie> movieLists = new ArrayList<Movie>();
    public static List<Movie> movieListsBackup = new ArrayList<Movie>();
    public static Movie movieTemp = new Movie();

    public static void main(String[] args) throws Exception{
        welcomeMessage();
        readUserTextFile("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\users.txt");
        if(login()){
            readBookTextFile("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");
            readMovieTextFile("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\movies.txt");
            while(run()){

            }
            System.out.println("Logout, welcome back again!!");
        }

    }

    //welcome message
    public static void welcomeMessage(){
        System.out.println("************************************");
        System.out.println("        Welcome to Biblioteca        ");
        System.out.println("************************************");
    }

    //show book list
//    public static void showBookList() throws Exception{
//        FileReader fr=new FileReader("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");
//        BufferedReader br=new BufferedReader(fr);
//        while(br.readLine()!=null){
//            String s=br.readLine();
//            System.out.println(s);
//        }
//        br.close();
//    }

//    public static void showBookList2()  throws Exception{
//        FileInputStream fis = null;
//        InputStreamReader isr = null;
//        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
//        try {
//            String str = "";
//            String str1 = "";
//            fis = new FileInputStream("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");// FileInputStream
//            // 从文件系统中的某个文件中获取字节
//            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
//            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
//            while ((str = br.readLine()) != null) {
//                str1 += str + "\n";
//            }
//            // 当读取的一行不为空时,把读到的str的值赋给str1
//            System.out.println(str1);// 打印出str1
//        } catch (FileNotFoundException e) {
//            System.out.println("找不到指定文件");
//        } catch (IOException e) {
//            System.out.println("读取文件失败");
//        } finally {
//            try {
//                br.close();
//                isr.close();
//                fis.close();
//                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public static void readTextFile(String filePath){
//        try {
//            String encoding="GBK";
//            File file=new File("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");
//            if(file.isFile() && file.exists()){ //判断文件是否存在
//                InputStreamReader read = new InputStreamReader(
//                        new FileInputStream(file),encoding);//考虑到编码格式
//                BufferedReader bufferedReader = new BufferedReader(read);
//                String lineTxt = null;
//                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println(lineTxt);
//                }
//                read.close();
//            }else{
//                System.out.println("找不到指定的文件");
//            }
//        } catch (Exception e) {
//            System.out.println("读取文件内容出错");
//            e.printStackTrace();
//        }

//    }

    public static boolean login(){
        System.out.println("Please login");
        System.out.print("library number(xxx-xxxx):");
        String userInfo;
        Scanner inputScanner = new Scanner(System.in);
        userInfo = inputScanner.nextLine();
        System.out.print("password:");
        userInfo += inputScanner.nextLine();
        if(isExistUser(userLists,userInfo)){
            return true;
        }
        return false;
    }

    public static void readUserTextFile(String filePath) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] info = lineTxt.split(" ");
                    User user = new User();
                    for (int i = 0; i < UserInfoLength; ++i) {
                        user.setUserInfo(info[i], i);
                    }
                    userLists.add(user);
                    userListsBackup.add(user);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public static void readBookTextFile(String filePath) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] info = lineTxt.split(" ");
                    Book book = new Book();
                    for (int i = 0; i < BookInfoLength; ++i) {
                        book.setBookInfo(info[i], i);
                    }
                    bookLists.add(book);
                    bookListsBackup.add(book);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public static void readMovieTextFile(String filePath){
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] info = lineTxt.split(" ");
                    Movie movie = new Movie();
                    for (int i = 0; i < MovieInfoLength; ++i){
                        movie.setMovieInfo(info[i], i);
                    }
                    movieLists.add(movie);
                    movieListsBackup.add(movie);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public static void showBookList(){
        for(int i = 0; i < bookLists.size(); i++){
            Book book = bookLists.get(i);
            String outputString = new String();
            for(int j = 0; j < BookInfoLength; j++){
               outputString += "\t" + book.getBookInfo(j);
            }
            System.out.println(outputString);
        }
    }

    public static void showMovieList(){
        for(int i = 0; i < movieLists.size(); i++){
            Movie movie = movieLists.get(i);
            String outputString = new String();
            for(int j = 0; j < MovieInfoLength; j++){
                outputString += "\t" + movie.getMovieInfo(j);
            }
            System.out.println(outputString);
        }
    }

    public static void showMainMenu(){
        System.out.println("************************************");
        System.out.println("       1.List Books       ");
        System.out.println("       2.Checkout Books       ");
        System.out.println("       3.Return Books       ");
        System.out.println("       4.List Movies       ");
        System.out.println("       5.Checkout Movies       ");
        System.out.println("       6.Quit       ");
        System.out.println("************************************");
    }

    public static void checkOut(){
        System.out.println("please input book info(name+abuthor+pulishedYear(no space))");
        String checkOutBookInfo;
        Scanner inputScanner = new Scanner(System.in);
        checkOutBookInfo = inputScanner.nextLine();
        if(isExistBook(bookLists, checkOutBookInfo)){
            bookLists.remove(bookTemp);
            System.out.println("successful checkout!");
            return;
        }
        System.out.println("unsuccessful checkout!");
    }

    public static void checkOutMovie(){
        System.out.println("please input book info(name+year+director+movieRating(no space))");
        String checkOutMovieInfo;
        Scanner inputScanner = new Scanner(System.in);
        checkOutMovieInfo = inputScanner.nextLine();
        if(isExistMovie(movieLists, checkOutMovieInfo)){
            movieLists.remove(movieTemp);
            System.out.println("successful checkout!");
            return;
        }
        System.out.println("unsuccessful checkout!");
    }

    public static void returnBook(){
        System.out.println("please input book info(name+abuthor+pulishedYear(no space))");
        String returnBookInfo;
        Scanner inputScanner = new Scanner(System.in);
        returnBookInfo = inputScanner.nextLine();
        if(isExistBook(bookListsBackup, returnBookInfo)){
            Book book = bookTemp;
            if(!isExistBook(bookLists, returnBookInfo)){
                bookLists.add(book);
                System.out.println("successful return book!");
                return;
            }
        }
        System.out.println("unsuccessful return book!!");
    }

    public static boolean isExistUser(List<User> users, String info){
        for(int i = 0; i < users.size(); i++) {
            userTemp = users.get(i);
            String userInfo = new String();
            for (int j = 0; j < UserLoginInfoLength; j++) {
                userInfo += userTemp.getUserInfo(j);
            }
            if (info.equals(userInfo)) {
                System.out.println("login successful !");
                String outputString = new String();
                for(int j = 2; j < UserInfoLength; j++){
                    outputString += "\t" + userTemp.getUserInfo(j);
                }
                System.out.println(outputString);
                return true;
            }
        }
        return false;
    }

    public static boolean isExistBook(List<Book> books, String info){
        for(int i = 0; i < books.size(); i++) {
            bookTemp = books.get(i);
            String bookInfo = new String();
            for (int j = 0; j < BookInfoLength; j++) {
                bookInfo += bookTemp.getBookInfo(j);
            }
            if (info.equals(bookInfo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistMovie(List<Movie> movies, String info){
        for(int i = 0; i < movies.size(); i++) {
            movieTemp = movies.get(i);
            String movieInfo = new String();
            for (int j = 0; j < MovieInfoLength; j++) {
                movieInfo += movieTemp.getMovieInfo(j);
            }
            if (info.equals(movieInfo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean run(){
        showMainMenu();
        int choice = 0;
        String inputString;
        Scanner inputScanner = new Scanner(System.in);
        inputString = inputScanner.nextLine();
        choice = Integer.parseInt(inputString);
        switch(choice){
            case MENU_LIST_BOOKS:
                System.out.println("\tname\tauthor\tpublishedYear");
                showBookList();
                return true;
            case MENU_CHECK_OUT_BOOK:
                checkOut();
                return true;
            case MENU_RETURN_BOOK:
                returnBook();
                return true;
            case MENU_LIST_MOVIES:
                System.out.println("\tname\tyear\tdirector\tmovieRating");
                showMovieList();
                return true;
            case MENU_CHECK_OUT_MOVIE:
                checkOutMovie();
                return true;
            case MENU_QUIT:
                return false;
            default:
                System.out.println(" Select a valid option!");
                return true;
        }
    }
}
