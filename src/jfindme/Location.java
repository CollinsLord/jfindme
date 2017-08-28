package jfindme;

public class Location {
    private String city;
    private String region;
    private String country;
    private double latitude;
    private double longitude;

    public Location(String json) {
        String substr = json.substring(1, json.length() - 1).replace("\"", "");
        System.out.println(substr);
        String[] props = substr.split(", ");
        for (String prop : props) {
            String[] keyval = prop.split(":");
            switch (keyval[0].trim()) {
                case "city":
                    setCity(keyval[1].trim());
                    break;

                case "region":
                    setRegion(keyval[1].trim());
                    break;

                case "country":
                    setCountry(keyval[1].trim());
                    break;

                case "loc":
                    String[] coords = keyval[1].split(",");
                    double lat = Double.parseDouble(coords[0]);
                    double lon = Double.parseDouble(coords[1]);
                    setLatitude(lat);
                    setLongitude(lon);
                    break;

                default:
                    break;
            }
        }
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
