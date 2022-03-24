package design_pattern.behavioral.strategy;

public class StrategyApp {

    /**
     * 전략 패턴.
     *
     * 여러 알고리듬을 캡슐화하고 상호 교환 가능하게 만드는 패턴.
     * 컨텍스트에서 사용할 알고리듬을 클라리언트 선택
     *
     * 새로운 전략을 추가하더라도 기존 코드를 변경 X, 상속 대신 위임을 사용, 런타임에 전략변경
     *  단점 은 클라이언트가 구체적인 전략을 알아야 됨..
     *
     *
     *  사용예시 - Comparator. 스프링의 대부분..
     *
     * @param args
     */


    public static void main(String[] args) {
        BlueLightRedLight game = new BlueLightRedLight(new Normal());

        game.blueLight();
        game.redLight();
        
        game.blueLight(new Speed() {
            @Override
            public void blueLight() {
                System.out.println("다른 전략");
            }

            @Override
            public void redLight() {
                System.out.println("추가");
            }
        });
        
    }
}
