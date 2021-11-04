package com.example.BlogAppSpring.otherModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Template {

    @Id
    private String name;

    @Enumerated
    private TemplateCategory category;
    private String textColour;
    private String backgroundColour;

    public Template() {
    }

    public Template(String name, TemplateCategory category, String textColour, String backgroundColour) {
        this.name = name;
        this.category = category;
        this.textColour = textColour;
        this.backgroundColour = backgroundColour;
    }

    @Override
    public String toString() {
        return "Template{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", textColour='" + textColour + '\'' +
                ", backgroundColour='" + backgroundColour + '\'' +
                '}';
    }
}
