package sg.edu.rp.c346.id21023028.demoweather;

import java.io.Serializable;

public class Car implements Serializable {
    String carparkNumber;

    public Car(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    public String getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    //to string
    @Override
    public String toString() {
        return "Carpark Number: " + carparkNumber;
    }
}
