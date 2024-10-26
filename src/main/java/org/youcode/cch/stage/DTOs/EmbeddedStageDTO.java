package org.youcode.cch.stage.DTOs;


public class EmbeddedStageDTO {
    private int number;
    private String startLocation;
    private String endLocation;
    private String type;

    public EmbeddedStageDTO(int number, String startLocation, String endLocation, String type) {
        this.number = number;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public String getType() {
        return type;
    }
}

