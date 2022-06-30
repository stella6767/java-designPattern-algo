package kt2.ch8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec08Main {

    public static void main(String[] args) throws IOException {

        Lec08Main lec07Main = new Lec08Main();

    }


    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.println(str);
            }
        }
    }

    public void repeat(String str, int num) {
        repeat(str, num, true);
    }

    public void repeat(String str) {
        repeat(str, 3, true);
    }

    public void printAll(String... strings){
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
