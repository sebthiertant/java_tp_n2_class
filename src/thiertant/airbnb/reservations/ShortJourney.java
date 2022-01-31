package thiertant.airbnb.reservations;

import thiertant.airbnb.lodgings.Lodging;

import java.util.Date;

public class ShortJourney extends Journey{

    public ShortJourney(Date arrivalDate, int nights, Lodging lodging, int travelersNumber) {
        super(arrivalDate, nights, lodging, travelersNumber);
    }

    @Override
    public boolean checkNightsNumber(){
        return super.getNights() < 6;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Price of the journey : " + super.getPrice() + "€.");
    }

    @Override
    public void updatePrice(){
        System.out.println("Short Journey");
        this.price = super.getNights() * super.getLodging().getPriceByNight();
    }
}
