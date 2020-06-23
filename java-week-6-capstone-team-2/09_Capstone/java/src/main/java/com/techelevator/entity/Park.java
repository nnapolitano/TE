package com.techelevator.entity;

import java.time.LocalDate;

public class Park {

    private long parkId;
    private String name;
    private String location;
    private LocalDate establishedDate;
    private long area;
    private long visitors;
    private String description;

    public Park () {}

    public long getParkId() {
        return parkId;
    }
    public String getName() {
        return name;
    }
    public void setParkId(long parkId) {
        this.parkId = parkId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setEstablish_date(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }
    public void setArea(long area) {
        this.area = area;
    }
    public void setVisitors(long visitors) {
        this.visitors = visitors;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void formatDescription() {
        String[] words = description.split(" ");
        String sentence = "";
        String formattedDescription = "";
        for (String value : words) {
            if (sentence.length() <= 80) {
                sentence = sentence + value + " ";
            } else {
                formattedDescription = formattedDescription + sentence + "\n";
                sentence = value + " ";
                }
            }
            if (!sentence.isEmpty()) {
                formattedDescription = formattedDescription + sentence;
            }
            setDescription(formattedDescription);
        }

    @Override
    public String toString() {
        formatDescription();
        return name + "\n" +
                "Location:        " + location + "\n" +
                "Established:     " + establishedDate + "\n" +
                "Area:            " + area + " sq km" + "\n" +
                "Annual Visitors: "  + visitors + "\n\n" +
                description + "\n\n";
    }
}