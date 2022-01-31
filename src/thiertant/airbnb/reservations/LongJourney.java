package thiertant.airbnb.reservations;

import thiertant.airbnb.lodgings.Lodging;

import java.util.Date;

public class LongJourney extends Journey{

    private static final int DISCOUNT_IN_PERCENTAGE = 20;
    private int discount;

    public LongJourney(Date arrivalDate, int nights, Lodging lodging, int travelersNumber) {
        super(arrivalDate, nights, lodging, travelersNumber);
    }

    @Override
    public boolean checkNightsNumber(){
        return super.getNights() > 5 && super.getNights() <= 31;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Price of the journey : " + super.getPrice() + "€ (" + this.discount + "€ of discount).");
    }

    @Override
    public void updatePrice(){
        System.out.println("Long Journey");
        int initialPrice = (super.getNights() * super.getLodging().getPriceByNight());
        this.discount = (initialPrice * DISCOUNT_IN_PERCENTAGE) / 100 ;
        this.price = initialPrice - this.discount;
    }
}
