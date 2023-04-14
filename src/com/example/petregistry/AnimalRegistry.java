package com.example.petregistry;

import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Animal createAnimal(String type, String name) {
        switch (type) {
            case "Dog":
                return new Dog(name);
            case "Cat":
                return new Cat(name);
            case "Hamster":
                return new Hamster(name);
            case "Horse":
                return new Horse(name);
            case "Camel":
                return new Camel(name);
            case "Donkey":
                return new Donkey(name);
            default:
                throw new IllegalArgumentException("Invalid animal type");
        }
    }

    public void listCommands(Animal animal) {
        System.out.println("Commands for " + animal.getName() + " (" + animal.getSpecies() + "):");
        for (String command : animal.getCommands()) {
            System.out.println("- " + command);
        }
    }

    public void teachCommand(Animal animal, String command) {
        animal.addCommand(command);
    }
}

