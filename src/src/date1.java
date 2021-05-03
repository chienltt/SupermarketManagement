package src;

public class date1 {
    private int year;
    private int month;
    private int day;
    public date1(int year,int month,int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public date1(date1 d){
        this.year=d.year;
        this.month=d.month;
        this.day=d.day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
