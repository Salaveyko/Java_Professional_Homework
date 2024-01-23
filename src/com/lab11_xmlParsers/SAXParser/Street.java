package com.lab11_xmlParsers.SAXParser;

import java.util.ArrayList;

public class Street {
    private ArrayList<Integer> builds;
    private String name;

    public Street() {
        this("");
    }

    public Street(String name) {
        this.name = name;
        this.builds = new ArrayList<>();
    }

    public ArrayList<Integer> getBuilds() {
        return builds;
    }

    public void setBuilds(ArrayList<Integer> builds) {
        this.builds = builds;
    }

    public int getBuild(int index) {
        return builds.get(index);
    }

    public void removeBuild(int index) {
        builds.remove(index);
    }

    public void addBuild(int build) {
        builds.add(build);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append(":\n\t\t").append("Build numbers:");
        for (Integer i : builds) {
            str.append(" ").append(i);
        }
        return str.toString();
    }
}
