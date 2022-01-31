package thiertant.airbnb.reservations;

public interface JourneyInterface {

    boolean checkArrivalDate();
    boolean checkNightsNumber();
    boolean checkTravellersNumber();
    void display();
}
