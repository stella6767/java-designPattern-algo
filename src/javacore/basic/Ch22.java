package javacore.basic;

import java.math.BigInteger;
import java.util.*;

public class Ch22 {


    public static String classify(Set<?> s) {
        return "집합";
    }

    public static String classify(List<?> lst) {
        return "리스트";
    }

    public static String classify(Collection<?> c) {
        return "그 외";
    }

    public static void main(String[] args) {


        List<CollectionClassify> wineList = List.of(
                new SetClassify(), new ListClassify(), new CollectionClassify());


        for (CollectionClassify collectionClassify : wineList) {

            String classify = collectionClassify.classify(new HashSet<String>());

            System.out.println(classify);
        }


        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections){
            //System.out.println(classify(c));
           // System.out.println(classify(c));
        }

    }
}


class CollectionClassify {

    public String classify(Collection<?> c){

        return "그 외";
    };
}



class SetClassify extends CollectionClassify {

    public String classify(Set<?> s) {
        return "집합";
    }
}
class ListClassify extends CollectionClassify {


    public String classify(List<?> c) {
        return "리스트";
    }
}
