package sg.edu.rp.c346.id20006949.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private 	int _id;
    private 	String title;
    private String singers;
    private int year;
    private int stars;

    public Song( String title, String singers, int year, int stars ) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }
    public int get_id() {  return _id;  }
    public String getTitle() { return title; }
    public String getSingers() { return singers; }
    public int getYear() { return year; }
    public int getStar() { return stars; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setSongContent(String title, String singers, int year, int stars ) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }
    @Override
    public String toString() {

        return "ID: " + _id + "\nTitle: "+ title + "\nSingers: " + singers+ "\nYear: " + year + "\nStars: ";
    }
}