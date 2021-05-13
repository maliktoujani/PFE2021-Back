package com.pfe2021.PFE2021.service;

public class StatistiquePerDay {

    private int[] data;
    private String label;

    public StatistiquePerDay(int[] data, String label) {
        this.data = data;
        this.label = label;
    }

    public StatistiquePerDay() {
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
