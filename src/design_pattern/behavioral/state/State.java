package design_pattern.behavioral.state;


public interface State {
    void addReview(String review, Student student);

    void addStudent(Student student);
}
