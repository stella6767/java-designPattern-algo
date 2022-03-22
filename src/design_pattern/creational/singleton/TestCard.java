package design_pattern.creational.singleton;

public enum TestCard  {

    /**
     * enum으로 리플렉션 막기..
     */


    INSTANCE;

    private TestCard(){ //기본이 private

    }

    private Integer number;

    public Integer getNumber(){
        return number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

}
