package com.techelevator.ssg.model;

public class AlienWeightCalculation {
    private double earthWeight;
    private String planet;
    private double planetMultiplier;
    private double alienWeight;

    public AlienWeightCalculation() {
    }

    public AlienWeightCalculation(double earthWeight, String planet) {
        this.earthWeight = earthWeight;
        this.planet = planet;
    }

    public void calculateWeight(double earthWeight, String planet){

        switch (planet){
            case "Mercury":
                planetMultiplier= 0.37;
                break;
            case "Venus":
                planetMultiplier = 0.90;
                break;
            case "Moon":
                planetMultiplier = 0.17;
                break;
            case "Mars":
                planetMultiplier = 0.38;
                break;
            case "Jupiter":
                planetMultiplier = 2.65;
                break;
            case "Saturn":
                planetMultiplier = 1.13;
                break;
            case "Uranus":
                planetMultiplier = 1.09;
                break;
            case "Neptune":
                planetMultiplier = 1.43;
                break;
            case "Pluto":
                planetMultiplier = 0.04;
                break;
            default:
                planetMultiplier = 1;

        }
        this.setAlienWeight(earthWeight * planetMultiplier);
    }

    public double getEarthWeight() {
        return earthWeight;
    }

    public void setEarthWeight(double earthWeight) {
        this.earthWeight = earthWeight;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public double getPlanetMultiplier() {
        return planetMultiplier;
    }

    public void setPlanetMultiplier(double planetMultiplier) {
        this.planetMultiplier = planetMultiplier;
    }

    public double getAlienWeight() {
        return alienWeight;
    }

    public void setAlienWeight(double alienWeight) {
        this.alienWeight = alienWeight;
    }
}
