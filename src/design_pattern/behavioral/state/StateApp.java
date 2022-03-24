package design_pattern.behavioral.state;

public class StateApp {

    /**
     * 객체 내부 상태 변경에 따라 객체의 행동이 달라지는 패턴.
     * 
     * 상태를 클래스로 옮김
     * @param args
     */


    public static void main(String[] args) {

        OnlineCourse onlineCourse = new OnlineCourse();
        Student student = new Student("whiteship");
        Student keesun = new Student("keesun");
        keesun.addPrivate(onlineCourse);

        onlineCourse.addStudent(student);

        onlineCourse.changeState(new Private(onlineCourse));

        onlineCourse.addReview("hello", student);

        onlineCourse.addStudent(keesun);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getReviews());
        System.out.println(onlineCourse.getStudents());

    }
}
