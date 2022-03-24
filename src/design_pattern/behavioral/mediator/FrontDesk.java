package design_pattern.behavioral.mediator;

import java.time.LocalDateTime;

/**
 * Mediator
 *
 * 모든 의존성을 여기로 모은다.
 */
public class FrontDesk {

    private CleaningService cleaningService = new CleaningService();

    private Restaurant restaurant = new Restaurant();

    public void getTowers(Guest guest, int number) {
       cleaningService.getTowers(guest.getId(), number);

    }

    public String getRoomNumber(Integer guestId) {

        return "111";
    }

    public void dinner(Guest guest, LocalDateTime dateTime) {

        restaurant.dinner(guest.getId(), dateTime);

    }
}
