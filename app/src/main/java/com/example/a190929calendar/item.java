package com.example.a190929calendar;

import java.util.Objects;

public class item {

    private String day;

    public item(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "item{" +
                "day='" + day + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        item item = (item) o;
        return Objects.equals(day, item.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }
}
