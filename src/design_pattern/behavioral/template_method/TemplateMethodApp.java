package design_pattern.behavioral.template_method;

public class TemplateMethodApp {

    /**
     * 알고리듬 구조를 서브 클래스가 확장할 수 있도록 템플릿으로 제공하는 방법
     * 추상 클래스는 템플릿을 제공하고, 하위 클래스는 구체적인 알고리즘을 제공한다.
     *
     *
     * 비슷한 방법으로 템플릿 콜백 패턴이 있다.
     * 콜백으로 상속 대신 위임을 사용, 익명내부클래스나 람다 표현식을 활용
     *
     * 중복코드를 줄이고, 하위 클래스만 변경가능하지만.. 라스코프 치환 원칙을 어길 수 있음. final을 붙여서 어느정도 방지..
     *
     * 사용예시 - HttpServlet, resttemplate, jdbctemplate
     *
     * @param args
     */


    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("");
        int result = fileProcessor.process();
        System.out.println(result);

        
        
        //템플릿 콜백
        int result2 = fileProcessor.process((result1, number) -> result1 += number);
        System.out.println(result2);
    }

}
