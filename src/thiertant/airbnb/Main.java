package thiertant.airbnb;

import thiertant.airbnb.lodgings.Appartment;
import thiertant.airbnb.lodgings.House;
import thiertant.airbnb.lodgings.Lodging;
import thiertant.airbnb.reservations.Journey;
import thiertant.airbnb.reservations.LongJourney;
import thiertant.airbnb.reservations.Reservation;
import thiertant.airbnb.reservations.ShortJourney;
import thiertant.airbnb.tools.MyDate;
import thiertant.airbnb.users.Host;
import thiertant.airbnb.users.Traveller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Host host1 = new Host("Sébastien", "Thiertant", 30, 3);

        Traveller person2 = new Traveller("Peter", "Bardu", 33);

        House house1 = new House(host1, 50, "23 avenue de l'Europe, 37100 Tours", 75, 4, 500, true);

        Appartment appartment1 = new Appartment(host1, 30, "2221b Baker St, London NW1 6XE, Royaume-Uni",55,2,1, 12);

        Date startDate = new Date(1647298800000L);
//        Journey journey1 = new Journey(startDate, 5, house1, 3);

//        Reservation reservation1 = new Reservation(journey1,person2);

//        reservation1.display();

//        System.out.println(Tools.buildDateFromString(18, 3, 1991));
//        System.out.println(Tools.buildFormattedStringFromDate(startDate));
//        System.out.println(Tools.buildStringFromDate(startDate));

//        house1.display();
//        appartment1.display();
//        MyDate myDate = new MyDate(1800,2,15);
//        System.out.println(myDate.toString());

        int nights = 8;
        if (nights > 5) {
            LongJourney conditionJourney = new LongJourney(startDate, 15, house1,4);
            conditionJourney.display();
        }
        else {
            ShortJourney conditionJourney = new ShortJourney(startDate, 3, appartment1,3);
            conditionJourney.display();
        }
    }
}
