package com.poec.exercice11.model;

public class Data {

    private String location;
    private String temperature;
    private String skytext;
    private String humidity;
    private String wind;
    private String date;
    private String day;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSkytext() {
        return skytext;
    }

    public void setSkytext(String skytext) {
        this.skytext = skytext;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getCelciusTemperature() {
        return (Integer.valueOf(getTemperature()) - 32) / 1.8;
    }

}