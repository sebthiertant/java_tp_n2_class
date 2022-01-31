package thiertant.airbnb.tools;

public class MyDate extends java.util.Date{

    public MyDate(int year, int month, int date) {
        super(year, month, date);
    }

    public MyDate(String s) {
        super(s);
    }

    @Override
    public String toString(){
        int formattedYear = this.getYear();
        int formattedMonth = this.getMonth() + 1;
        return this.getDate()+ "/" + formattedMonth + "/" + formattedYear;
    }
}
