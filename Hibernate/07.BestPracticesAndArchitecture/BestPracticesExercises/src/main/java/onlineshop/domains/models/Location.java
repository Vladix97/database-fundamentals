package onlineshop.domains.models;


import java.util.Random;

public final class Location {

    private static final Random random = new Random();

    private float latitude;

    private float longitude;

    public Location() {
        this.latitude = Location.random.nextFloat();
        this.longitude = Location.random.nextFloat();
    }
}
