package com.cuonghuynh.myapplication;

public class Employee {

    private final String text;
    private boolean isSelected = false;

    public Employee(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }
}