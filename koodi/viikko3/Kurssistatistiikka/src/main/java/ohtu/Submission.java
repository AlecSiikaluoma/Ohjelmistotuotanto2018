package ohtu;

public class Submission {
    private int week;
    private String course;
    private int hours;
    private int[] exercises;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int[] getExcercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return ""+week;
    }
    
}