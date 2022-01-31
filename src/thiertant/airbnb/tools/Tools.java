package thiertant.airbnb.tools;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Tools {


    public static Date buildDateFromString(int day, int month, int year) {
        int formattedYear = year - 1900;
        int formattedMonth = month -1;
        return new Date(formattedYear, formattedMonth, day);
    }

    public static String buildFormattedStringFromDate(Date date){
        return new SimpleDateFormat("dd/MM/yy").format(date);
    }

    public static String buildStringFromDate(Date date){
        int formattedYear = date.getYear() + 1900;
        int formattedMonth = date.getMonth() + 1;
        return date.getDate()+ "/" + formattedMonth + "/" + formattedYear;
    }
}
