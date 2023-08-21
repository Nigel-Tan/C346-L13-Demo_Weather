package sg.edu.rp.c346.id21023028.demoweather;

import java.io.Serializable;

public class Car implements Serializable {
    String carparkNumber;
    int totalLots;

    public Car(String carparkNumber, int totalLots) {
        this.carparkNumber = carparkNumber;
        this.totalLots = totalLots;
    }

    public String getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    public int getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(int totalLots) {
        this.totalLots = totalLots;
    }

    //to string
    @Override
    public String toString() {
        return "Carpark Number: " + carparkNumber + '\n' +
                "Lots Available: " + totalLots;
    }
}
