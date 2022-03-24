package design_pattern.behavioral.strategy;

import design_pattern.behavioral.state.Private;

public class BlueLightRedLight implements Speed{

    private Speed speed;

    public BlueLightRedLight(Speed speed) {
        this.speed = speed;
    }

    @Override
    public void blueLight() {  //Speed speed
        speed.blueLight();
    }

    @Override
    public void redLight() {
        speed.redLight();
    }


    public void blueLight(Speed speed) {  //Speed speed
        speed.blueLight();
    }

}
