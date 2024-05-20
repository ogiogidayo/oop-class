package oop06;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class OopTask06 {
    public static void main(String[] args) {
        System.out.println("ファイル名を入力せよ。");
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        try(var sf = new Scanner(Path.of(st), "utf8")){
            while (sf.hasNext()){
                int x =sf.nextInt();
                if (x > 0) {
                    list.add(x);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try(var pw = new PrintWriter("output.txt","utf8")){
            for (Integer i : list) {
                pw.println(i);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
