package com.pfe2021.PFE2021.service;

import java.util.ArrayList;
import java.util.List;

public class Statistique {

    private List<Integer> data = new ArrayList<>();
    private List<String> label = new ArrayList<>();

    public Statistique(List<Integer> data, List<String> label) {
        this.data = data;
        this.label = label;
    }

    public Statistique() {
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }
}
