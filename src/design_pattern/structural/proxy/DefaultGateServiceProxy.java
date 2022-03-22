package design_pattern.structural.proxy;

public class DefaultGateServiceProxy implements GateService {

    private DefaultGateService defaultGateService;



    @Override
    public void openGate() {
        long before = System.currentTimeMillis();
        if (defaultGateService == null) {  //지연 초기화.. 실제 사용할 때 만듬.
            defaultGateService = new DefaultGateService();
        }

        //defaultGateService.openGate();

        System.out.println(System.currentTimeMillis() - before);

    }
}
