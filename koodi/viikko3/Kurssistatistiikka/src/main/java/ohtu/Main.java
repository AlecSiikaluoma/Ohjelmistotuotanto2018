package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
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

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        System.out.println("opiskelijanumero " + studentNr);
        System.out.println("");
        
        int totalExercises = 0;
        int totalHours = 0;
        System.out.println("Oliot:");
        for (Submission submission : subs) {
            totalExercises = totalExercises + submission.getExcercises().length;
            totalHours = submission.getHours() + totalHours;
            System.out.println(submission.getCourse() + ", viikko " + submission.getWeek() 
                    + " tehtyjä tehtäviä yhteensä " + submission.getExcercises().length 
                    + " aikaa kului " + submission.getHours() + " tuntia. Tehdy tehtävät" + java.util.Arrays.toString(submission.getExcercises()));
        }
        
        System.out.println("");
        System.out.println("yhteensä: " + totalExercises + "tehtävää " + totalHours);

    }
}