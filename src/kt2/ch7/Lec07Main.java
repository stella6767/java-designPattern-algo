package kt2.ch7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec07Main {

    public static void main(String[] args) throws IOException {

        Lec07Main lec07Main = new Lec07Main();
        lec07Main.readFile();

    }

    private int parseIntOrThrow(String str) {

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("주어진 문자는 숫자로 변환할 수 없습니다.");
        }
    }

    public void readFile() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        reader.close();
    }

    public void readFile2(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            System.out.println(reader.readLine());
        }
    }

}
