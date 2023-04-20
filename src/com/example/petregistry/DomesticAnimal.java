package com.example.petregistry;

import java.util.List;
import java.util.ArrayList;


public class DomesticAnimal extends Animal {
    private List<String> commands;

    public DomesticAnimal(String name, String species) {
        super(name, species);
        this.commands = new ArrayList<>();
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}
