package javacore.basic;

public class Ch21 {

    public static void main(String[] args) {

        G g = String::new;
        //<F extends Exception> ()->String throws F
       ///
    }
}


interface G1 {
    <E extends Exception> Object m() throws E;
}

interface G2 {
    <E extends Exception> String m() throws Exception;
}

interface G extends G1,G2{}

