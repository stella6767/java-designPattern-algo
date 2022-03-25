package design_pattern.behavioral.visitor;


/**
 * Element
 */

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}