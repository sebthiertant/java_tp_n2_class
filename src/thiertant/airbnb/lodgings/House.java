package thiertant.airbnb.lodgings;

import thiertant.airbnb.users.Host;

public class House extends Lodging{

    private int gardenSurface;
    private boolean havePool;

    public House(Host host, int priceByNight, String address, int surface, int maxTravelers, int gardenSurface, boolean havePool) {
        super(host, priceByNight, address, surface, maxTravelers);
        this.gardenSurface = gardenSurface;
        this.havePool = havePool;
    }

    @Override
    public int getTotalSurface() {
        return this.getSurface() + this.gardenSurface;
    }

    @Override
    public void display() {
        this.getHost().display();
        System.out.println("The lodging is at " + this.getAddress() + ".");
        System.out.println("Surface : " + this.getSurface() + "m2");
        System.out.println(this.gardenSurface != 0 ? "Garden : Yes (" + this.gardenSurface + "m2)" : "Garden : No");
        System.out.println(this.havePool ? "Pool : Yes" : "Pool : No");
    }
}
