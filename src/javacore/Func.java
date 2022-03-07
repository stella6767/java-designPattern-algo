package javacore;

public class Func {


    static void printData(int a, int b)  {

        if(a == b){
            return;
        }else{
            System.out.println("Hellog World!!");
        }


        printData(a, b+1);
    }

    public static void main(String[] args) {

        printData(3, 1);


    }
}
