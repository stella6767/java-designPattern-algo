package design_pattern.behavioral.visitor;

public class Keyboard implements ComputerPart {

    /**
     * ElementA
     * @param computerPartVisitor
     */

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
