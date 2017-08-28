package jfindme;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindMe {
    public static Location findByIp() throws Exception {
        URL url = new URL("https://ipinfo.io/json");
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));

        String json = "";
        String line;
        while ((line = in.readLine()) != null)
            json += line;
        return new Location(json);
    }

    public static void main(String[] args) {
        try {
            Location loc = findByIp();
            System.out.println("City: " + loc.getCity());
            System.out.println("Region: " + loc.getRegion());
            System.out.println("Country: " + loc.getCountry());
            System.out.println("Latitude: " + loc.getLatitude());
            System.out.println("Longitude: " + loc.getLongitude());
        } catch (Exception e) {
            System.err.println("Bad things happened.");
        }
    }
}
