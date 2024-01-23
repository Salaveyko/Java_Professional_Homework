package com.lab11_xmlParsers.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "animal")
public class Animal {
    private List<Cat> cats;

    public Animal(){
        cats = new ArrayList<>();
    }
    @XmlElement(name = "cat")
    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n--Cats--\n");
        for (var c : cats) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }
}
