package model;

import java.util.Collection;

public class Car {
    private String model;
    private int releaseDate;

    public Car(String model, int releaseDate) {
        this.model = model;
        this.releaseDate = releaseDate;
    }

    public String model() {
        return this.model;
    }

    public int releaseDate() {
        return this.releaseDate;
    }
}
