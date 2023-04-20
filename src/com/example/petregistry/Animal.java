package com.example.petregistry;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String species;
    private List<String> commands;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}

