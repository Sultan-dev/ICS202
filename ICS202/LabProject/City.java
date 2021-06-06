public class City {

    private String cityName;
    private double decimalLatitude, decimalLongitude;

    public City(String cityName, double decimalLatitude, double decimalLongitude) {
        this.cityName = cityName;
        this.decimalLatitude = decimalLatitude;
        this.decimalLongitude = decimalLongitude;
    }

    public String getCityName() {
        return cityName;
    }

    public double getDecimalLatitude() {
        return decimalLatitude;
    }

    public double getDecimalLongitude() {
        return decimalLongitude;
    }

    @Override
    public String toString() {
        return String.format("City: %s, Latitude: %.2f, longitude: %.2f", getCityName(), getDecimalLatitude(), getDecimalLongitude());
    }
}
