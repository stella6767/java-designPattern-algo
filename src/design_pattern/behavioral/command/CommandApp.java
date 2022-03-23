package design_pattern.behavioral.command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandApp {

    /**
     * https://refactoring.guru/design-patterns/command
     *
     * 요청을 캡슐화하여 호출자와 수신자를 분리하는 패턴.
     *  요청을 처리하는 방법이 바뀌어도 호출자의 코드는 변경되지 않는다.
     *
     *
     */



    private final Button button;

    public CommandApp(Button button) {
        this.button = button;
    }


    public static void main(String[] args) {

        CommandApp client = new CommandApp(new Button());

        Light light = new Light();
        Robot robot = new Robot();

        client.button.addCommand(new LightOnCommand(light));
        client.button.addCommand(new MoveForwordCommand(10, robot));
        client.button.addCommand(new PickUpCommand(robot));
        client.button.addCommand(new TurnCommand(Robot.Direction.LEFT, robot));
        client.button.addCommand(new LightOffCommand(light));

        client.button.allCommandStart();


        //자바에서의 command 패턴 예시
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(light::on);
        executorService.submit(light::off);
        executorService.shutdown();

        //스프링 예시 = SimpleJdbcInsert

    }

}
