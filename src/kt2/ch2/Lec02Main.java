package kt2.ch2;

public class Lec02Main {

    public static void main(String[] args) {

    }


    public boolean startWithA1(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null not accept");
        }
        return str.startsWith("A");
    }

    public Boolean startWithA2(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("A");
    }

    public boolean startWithA3(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("A");
    }



    public long calculate(Long num){
        if (num == null){
            return 0;
        }
        return 1;
    }

}
