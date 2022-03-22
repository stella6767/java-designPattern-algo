package design_pattern.behavioral.chain_of_responsibilities;

public class CORApp {

    /**
     * 책임 연쇄 패턴 / 요청을 보내는 쪽과 요청을 처리하는 쪽 분리
     * 클라이언트 코드를 변경하지 않고 언제든지 체인을 추가하고, 순서를 변경할 수 도 있음.
     *
     * 사용예시 - servlet 필터, 스프링 시큐리티 필터
     * @param args
     */

    private RequestHandler requestHandler;

    public CORApp(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }


    public void doWork(){
        Request request = new Request("안녕");
        requestHandler.handle(request);
    }

    public static void main(String[] args) {

        RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));

        CORApp client = new CORApp(chain);
        client.doWork();


    }

}
