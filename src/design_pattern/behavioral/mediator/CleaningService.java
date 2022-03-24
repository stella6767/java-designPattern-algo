package design_pattern.behavioral.mediator;

public class CleaningService {

    private FrontDesk frontDesk = new FrontDesk();

    public void getTowers(Integer id, int numberOfTowels) {
        String roomNumber = this.frontDesk.getRoomNumber(id);
        System.out.println("provide " + numberOfTowels + " to " + roomNumber);
    }
}
