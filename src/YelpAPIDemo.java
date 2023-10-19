import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.*;
public class YelpAPIDemo {

    public static void main(String [] args) {

        try {

            HttpClient client = HttpClient.newHttpClient();

            String API_KEY = "";

            String term = "taco";
            String location = "Irvine"; //%20 instead of spaces
            //meters
            int radius = 5000;

            URI uri = new URI("https://api.yelp.com/v3/businesses/search?term=" + term
            + "&location=" + location
            + "&radius=" + radius);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("authorization", "Bearer " + API_KEY)
                    .build();

            System.out.println(request);

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            System.out.println(response);
            System.out.println(response.body());

            JSONObject responseObject = new JSONObject(response.body());
            System.out.println(responseObject);

            System.out.println(responseObject.keySet());

            //isolate total
            System.out.println(responseObject.get("total"));
            //total holds an int

            System.out.println(responseObject.get("region"));
            //region is an object - curly braces in output
            //need to cast as object to isolate components of region
            JSONObject region = responseObject.getJSONObject("region");
            System.out.println(region.get("center"));
            System.out.println(region.getJSONObject("center").get("latitude"));

            System.out.println(responseObject.get("businesses"));
            //businesses is an array - square brackets
            JSONArray bArray = responseObject.getJSONArray("businesses");
            System.out.println("length of bArray: " + bArray.length());

            //for each loop - bArray type is Object
            //-need to cast to JSONObject
            for (Object o: bArray) {
                JSONObject j = (JSONObject) o;
                System.out.println(j.getString("name"));
            }

            System.out.println(bArray.get(0));

            JSONObject business = (JSONObject) bArray.get(0);
            System.out.println(business.get("name"));
            //

            //use get(Type) for specific type - get() returns Object
            String n = business.getString("name");

            double rating = business.getDouble("rating");


            //make a YelpRestaurant class that has variables for:
            //-name
            //-street address
            //-city
            //-rating (double)
            //-price range (int)
            //-String ArrayList of all category keywords (values for both aliases and titles)
            //constructor - parameter is a JSON object that represents a yelp business,
            //-parse the object to populate the above variables
            //toString() - nicely formatted string of all variables
            //iterate through up to 20 search results, make objects of each result stored in an ArrayList,
            // and print each object

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
