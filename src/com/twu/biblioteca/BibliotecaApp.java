package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    public static void main(String[] args) throws Exception{
        welcomeMessage();
        /*showBookList();
        showBookList2();*/
        readTxtFile("1");
        System.out.println("Hello, world!");
    }

    //welcome message
    public static void welcomeMessage(){
        System.out.println("************************************");
        System.out.println("        Welcome to Biblioteca        ");
        System.out.println("************************************");
    }

    //show book list
    public static void showBookList() throws Exception{
        FileReader fr=new FileReader("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");
        BufferedReader br=new BufferedReader(fr);
        while(br.readLine()!=null){
            String s=br.readLine();
            System.out.println(s);
        }
        br.close();
    }

    public static void showBookList2()  throws Exception{
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            while ((str = br.readLine()) != null) {
                str1 += str + "\n";
            }
            // 当读取的一行不为空时,把读到的str的值赋给str1
            System.out.println(str1);// 打印出str1
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readTxtFile(String filePath){
        try {
            String encoding="GBK";
            File file=new File("D:\\Documents\\GitHub\\twu-biblioteca-tianbiao\\res\\books.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println(lineTxt);
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
}
