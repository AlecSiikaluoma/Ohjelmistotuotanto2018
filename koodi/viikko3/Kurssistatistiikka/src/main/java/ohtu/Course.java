package ohtu;

public class Course {
    private String fullName;
    private String name;
    private String term;
    private int year;
    private int[] exercises;
    
    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }
    
    public String getTerm() {
        return term;
    }
    
    public int getYear() {
        return year;
    }
    
    public int[] getExcercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return "";
    }
    
}