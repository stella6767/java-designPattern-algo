package design.bridge;

public class BridgeApp {

    /**
     * 추상적인 것과 구체적인 것을 분리하여 연결
     * 
     * 추상적인 코드를 구체적인 코드변경 없이도 독립적으로 확장
     * 계층 구조가 늘어나 복잡도가 증가할 수 있음.
     *
     * 자바에서의 사용예시, JDBC, SLF4J
     * @param args
     */
    
    public static void main(String[] args) {

        Champion kda아리 = new 아리(new KDA());
        kda아리.skillQ();
        kda아리.skillW();

        Champion poolParty아리 = new 아리(new PoolParty());
        poolParty아리.skillW();
        poolParty아리.skillQ();
    }
    
}
