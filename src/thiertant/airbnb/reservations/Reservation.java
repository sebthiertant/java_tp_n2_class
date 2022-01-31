package thiertant.airbnb.reservations;

import thiertant.airbnb.users.Person;
import thiertant.airbnb.users.Traveller;

import java.util.Date;

public class Reservation {
    private int id;
    private Journey journey;
    private Traveller traveller;
    private boolean isValidated;
    private Date reservationDate;

    public Reservation(Journey journey, Traveller traveller) {
        this.journey = journey;
        this.traveller = traveller;
        this.reservationDate =  new Date();
        this.isValidated = false;
        this.id = (int)(Math.random()*100000);
    }

    public void display() {
        traveller.display();
        System.out.println("has done a reservation at ");
        journey.display();
    }
}
