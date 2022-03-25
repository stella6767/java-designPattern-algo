package design_pattern.behavioral.visitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VisitorApp {


    /**
     * 기존 코드를 변경하지 않고 새로운 기능을 추가
     * Double dispatch
     * 두 번 찾아감..
     *
     * 사용예시 - FileVisitor, BeanDefinitionVistor
     * @param args
     */



    public static void main(String[] args) throws IOException {

        ComputerPart computer = new Monitor();

        computer.accept(new ComputerPartDisplayVisitor());

        //Path startingDirectory = Path.of("kang/intellijwork/kotiln-practice/src/design_pattern/behavioral/visitor");
        Path startingDirectory = Path.of("src/design_pattern/behavioral");
        SearchFileVisitor searchFileVisitor =
                new SearchFileVisitor("Computer.java", startingDirectory);
        Files.walkFileTree(startingDirectory, searchFileVisitor);

    }
}
