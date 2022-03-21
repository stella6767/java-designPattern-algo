package design.factory;

public class IDCard implements Product{

    private String owner;

    public IDCard(String owner) {
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + " 님의 카드를 사용합니다.");
    }

    public static class Factory{
        //결합도는 올라가지만, 눈에 보이므로, 이 방법도 상황에 맞춰서

        public static IDCard create(String owner){
            return new IDCard(owner);
        }

    }


}
