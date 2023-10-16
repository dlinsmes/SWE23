import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.*;
public class YelpAPIDemo {

    public static void main(String [] args) {

        try {

            HttpClient client = HttpClient.newHttpClient();

            String API_KEY = "TsghMGkJt7cGjWSDIhlaEyR93TIQwBL13ORyp_8yLJ80muvvgD10_jDwGxJzhya8vs60Qt0_lXllh8SaMn2T6L0jsTxPQI1_9u4cKnnBl_scK8qvrBn4RR6WMBM7Y3Yx";

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

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
