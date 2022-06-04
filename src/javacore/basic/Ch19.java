package javacore.basic;


/**
 *  인터페이스
 *
 * 인터페이스(interface)는 서로 다른 두 개의 시스템, 장치 사이에서 정보나 신호를 주고받는 경우의 접점이나 경계면이다.
 * 즉, 사용자가 기기를 쉽게 동작시키는데 도움을 주는 시스템을 의미한다
 * GUI, CLI, API,
 *
 * 역할, 구현
 *
 */


public class Ch19 {

    public static void main(String[] args) {
        Client client = new Client(new 포크레인());
        client.playRemocon();

    }

}


class Client {

    private Remocon remocon;

    public Client(Remocon remocon) {
        this.remocon = remocon; //의존성 주입
    }

    public void playRemocon(){
        remocon.turnOn();
    }
}



class 포크레인 implements Remocon {

    @Override
    public void turnOn() {

        pladdd();
    }

    private void pladdd(){

        System.out.println("porkrain play");
    }

}


class 선풍기 implements Remocon{

    @Override
    public void turnOn() {
        playDefaultOption();
        playWheels();
    }


    private void playWheels(){
        System.out.println("날개가 움직인다.");
    }


    private void playDefaultOption(){

        System.out.println("강풍");
    }

}



class TV implements Remocon{

    @Override
    public void turnOn() {

        turnOnElectric();
        soundOn();
        playTv("tv play");
    }

    private void playTv(String tv_play) {
        System.out.println(tv_play);
    }

    private void turnOnElectric(){
        playTv("전기가 들어옵니다.");
    }

    private void soundOn(){
        playTv("sound on");
    }

}


interface Remocon {
    void turnOn();
}




