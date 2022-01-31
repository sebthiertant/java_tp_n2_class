package thiertant.airbnb.lodgings;

import thiertant.airbnb.users.Host;
import thiertant.airbnb.users.Person;

public abstract class Lodging {

    private Host host;
    private int priceByNight;
    private String address;
    private int surface;
    private int maxTravellers;

    public Lodging(Host host, int priceByNight, String address, int surface, int maxTravelers) {
        this.host = host;
        this.priceByNight = priceByNight;
        this.address = address;
        this.surface = surface;
        this.maxTravellers = maxTravelers;
    }

    public int getPriceByNight() {
        return priceByNight;
    }

    public void display() {
        host.display();
        System.out.println("The lodging is at " + this.address + ".");
        System.out.println("Surface : " + this.surface + "m2");
    }

    public Host getHost() {
        return host;
    }

    public String getAddress() {
        return this.address;
    }

    public int getSurface() {
        return surface;
    }

    public int getMaxTravellers() {
        return maxTravellers;
    }

    abstract public int getTotalSurface();
}
