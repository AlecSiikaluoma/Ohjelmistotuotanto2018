package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String coursesText = Request.Get("https://studies.cs.helsinki.fi/courses/courseinfo").execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course[] courses = mapper.fromJson(coursesText, Course[].class);
        
        System.out.println("opiskelijanumero " + studentNr);
        System.out.println("");
        
        int totalExercises = 0;
        int totalHours = 0;
        for (Course course : courses) {
            int courseTotalExercises = 0;
            for(int i = 0; i < course.getExcercises().length; i++) {
                courseTotalExercises += course.getExcercises()[i];
            }
            ArrayList<Submission> courseSubmissions = new ArrayList<>();
            for(int i = 0; i < subs.length; i++) {
                if(subs[i].getCourse().equals(course.getName())) {
                    courseSubmissions.add(subs[i]);
                }
            }
            if(courseSubmissions.size() > 0) {
                System.out.println(course.getFullName());
                System.out.println("");
                int total = 0;
                int totalH = 0;
                for(int j = 0; j < courseSubmissions.size(); j++) {
                    Submission x = courseSubmissions.get(j);
                    total = total + x.getExcercises().length;
                    totalH += x.getHours();
                    System.out.println("viikko " + x.getWeek() + ":");
                    System.out.println(" tehtyjä tehtäviä " + x.getExcercises().length + "/" 
                            + course.getExcercises()[x.getWeek()] + " aikaa kului " + x.getHours() + " tehdyt tehtävät " 
                            + java.util.Arrays.toString(x.getExcercises()));                    
                }
                System.out.println("");
                System.out.println("yhteensä: " + total + "/" + courseTotalExercises + " tehtävää " + totalH + " tuntia");
                System.out.println("");
            }
        }
    }
}