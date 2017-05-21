package com.example.ebonycalloway.klosetkaper.POJO;

/**
 * Created by ebonycalloway on 4/28/17.
 */

public class UserInfo {
    String name;
    int wears;
    int weeks;
    String remind;

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", wears=" + wears +
                ", weeks=" + weeks +
                ", remind='" + remind + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWears() {
        return wears;
    }

    public void setWears(int wears) {
        this.wears = wears;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }
}
