package design_pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ProtoTypeApp {

    /**
     * 객체 생성 패턴 중 하나
     * 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법
     * object class의 clone을 사용하면 되므로, 인터페이스를 따로 만들 필요 X
     *
     * 자바에서의 사용예시 - ArrayList clone, clone은  상위 인터페이스 List가 clone을 지원하지 않으므로 잘 사용X
     * modelmapper 는 리플렉션을 이용해 클론
     *
     * @param args
     */
    
    
    public static void main(String[] args) throws CloneNotSupportedException {

        GithubRepository repository = new GithubRepository();
        repository.setUser("kang");
        repository.setName("prototype study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("깊은 복사와 얕은 복사");

        String url = githubIssue.getUrl();
        System.out.println(url);

        GithubIssue clone = (GithubIssue) githubIssue.clone();
        System.out.println(clone.getUrl());
        
         repository.setName("kang2"); //얕은 카피면 복사본에도 영향을 미침

        System.out.println(clone != githubIssue);
        System.out.println(clone.equals(githubIssue));
        System.out.println(clone.getClass() == githubIssue.getClass());
        System.out.println(clone.getRepository() == githubIssue.getRepository());

        List<Integer> originList = new ArrayList<>();
        List<Integer> cloneList = new ArrayList<>(originList);



    }

}
