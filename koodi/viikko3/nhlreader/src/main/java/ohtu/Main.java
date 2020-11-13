package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        Player[] finnishPlayers = Arrays.stream(players)
                .filter(player -> player.getNationality().equals("FIN")).toArray(player -> new Player[player]);

        System.out.println("Oliot:");
        for (Player player : finnishPlayers) {
            System.out.println(player.toString());
        }
    }

}