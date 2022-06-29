package kt2.ch3;

import kt2.ch1.Person;

public class Lec03Main {



    public static void printAgeIfPerson(Object obj){

        if (obj instanceof Person){
            Person person = (Person) obj;
            System.out.println(person.getAge());
        }

    }

}
