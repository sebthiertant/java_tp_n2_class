package thiertant.airbnb.lodgings;

import thiertant.airbnb.users.Host;

public class Appartment extends Lodging{

    private int floorNumber;
    private int balconySurface;

    public Appartment(Host host, int priceByNight, String address, int surface, int maxTravelers, int floorNumber, int balconySurface) {
        super(host, priceByNight, address, surface, maxTravelers);
        this.floorNumber = floorNumber;
        this.balconySurface = balconySurface;
    }


    @Override
    public int getTotalSurface() {
        return this.getSurface() + this.balconySurface;
    }

    @Override
    public void display() {
        this.getHost().display();
        System.out.println("The lodging is at " + this.getAddress() + " at " + this.floorNumber + "° floor.");
        System.out.println("Surface : " + this.getSurface() + "m2");
        System.out.println(this.balconySurface != 0 ? "Balcony : Yes (" + this.balconySurface + "m2)" : "Balcony : No");
    }

}
