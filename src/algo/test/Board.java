package algo.test;

public class Board { //객체를 생성하는 틀.

    private String title; //상태, 법칙 길이가 10이 넘으면 안 된다.
    private String content;


    //객체 / 상태와 행위를 한 곳에 묶는 것. 캡슐화


    public Board() {
        System.out.println("응애응애!!!");

    }


//    public Board(String title, String content) { //함수, 객체를 생성해주는 함수, 생성자
//
//
//    }

    public String getTitle() { //행위
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
