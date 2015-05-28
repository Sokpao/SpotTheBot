package spotthebot;

import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.Timer;
import twitter4j.JSONException;

/**
 * This project is aiming to follow highly retweeted users activity in Twitter.
 * It uses Twitter Streaming API, in order to analyze tweets and get those
 * highly retweeted users. Then, it follows their activity and analyze
 * their behavior. Database will be useful for further analysis.
 * @author Sokratis Papadopoulos
 */
public class SpotTheBot {
    
    private static final int TASK_REPEAT = 600000; // one hour: 3600000 | time-repeat of checking task for updating list of potential spammers | 60.000 milliseconds = 1 minute
    
    public static void main(String[] args) throws JSONException, InterruptedException, MongoException, UnknownHostException {
   
        Crawler crawl = new Crawler(); 

        //create task to be executed every 1 hour
        Timer time = new Timer(); 
        time.schedule(crawl, 0, TASK_REPEAT);
        
    }
}
