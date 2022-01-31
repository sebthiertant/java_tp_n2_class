package thiertant.airbnb.reservations;

import thiertant.airbnb.lodgings.Lodging;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Journey implements JourneyInterface{
    private Date arrivalDate;
    private int nights;
    private Lodging lodging;
    private int travellersNumber;
    protected int price;

    public Journey(Date arrivalDate, int nights, Lodging lodging, int travelersNumber) {
        this.arrivalDate = arrivalDate;
        this.nights = nights;
        this.lodging = lodging;
        this.travellersNumber = travelersNumber;
        updatePrice();
    }

    public int getNights() {
        return nights;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Lodging getLodging() {
        return lodging;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean checkArrivalDate(){
        return this.arrivalDate.after(new Date());
    }

    @Override
    public boolean checkTravellersNumber(){
        return this.travellersNumber < this.lodging.getMaxTravellers();
    }

    @Override
    public void display(){
        lodging.display();
        String formattedDate = new SimpleDateFormat("dd/MM/yy").format(this.arrivalDate);
        System.out.println("The arrival date is " + formattedDate + " for " + this.nights + " nights.");
    }

    abstract void updatePrice();
}


