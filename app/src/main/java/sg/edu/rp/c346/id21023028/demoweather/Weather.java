package sg.edu.rp.c346.id21023028.demoweather;

import java.io.Serializable;

public class Weather implements Serializable {

    //fields
    private String area;
    private String forecast;

    //constructor
    public Weather(String area, String forecast) {
        this.area = area;
        this.forecast = forecast;
    }

    //getters and setters


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        //write toString to display something like this
        //WEATHER
        //Area: Ang Mo Kio
        //Forecast: Partly Cloudy (Day)
        return "WEATHER\n" +
                "Area: " + area + '\n' +
                "Forecast: " + forecast;
    }
}