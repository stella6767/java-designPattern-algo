package design_pattern.creational.prototype;

import java.util.Objects;

public class GithubIssue implements Cloneable{

    private int id;
    private String title;

    private GithubRepository repository;

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl(){
        return String.format("https://github.com/stella6767/kotlin-practice",
                repository.getUser(),
                repository.getName(),
                this.getId()
                );
    }


    public GithubRepository getRepository() {
        return repository;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser(this.repository.getUser());
        repository.setName(this.repository.getName());

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(this.id);
        githubIssue.setTitle(this.title);


        /**
         * 깊은 복사
         */

        return githubIssue;
    }


//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//
//        //얕은 복사//얕은 카피 (shallow copy)

//        return super.clone();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubIssue that = (GithubIssue) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, repository);
    }
}
