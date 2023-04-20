package com.example.petregistry;

import java.util.Scanner;

public class PetRegistryApp {
    private AnimalRegistry registry;
    private Scanner scanner;

    public PetRegistryApp() {
        registry = new AnimalRegistry();
        scanner = new Scanner(System.in);
    }

    private void addAnimalWithCounter(String type, String name) {
        try (Counter counter = new Counter()) {
            counter.add();
            Animal animal = registry.createAnimal(type, name);
            registry.addAnimal(animal);
            System.out.println("Animal added successfully. Total animals: " + counter.getValue());
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void run() {
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add an animal");
            System.out.println("2. List commands for an animal");
            System.out.println("3. Teach a command to an animal");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the animal type (Dog, Cat, Hamster, Horse, Camel, Donkey):");
                    String type = scanner.nextLine();
                    System.out.println("Enter the animal's name:");
                    String name = scanner.nextLine();

                    if (!type.isEmpty() && !name.isEmpty()) {
                        addAnimalWithCounter(type, name);
                    } else {
                        System.out.println("Error: Type and name must be provided.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the animal's name:");
                    String animalName = scanner.nextLine();
                    boolean found = false;
                    for (Animal a : registry.animals) {
                        if (a.getName().equalsIgnoreCase(animalName)) {
                            registry.listCommands(a);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the animal's name:");
                    String targetName = scanner.nextLine();
                    boolean targetFound = false;
                    for (Animal a : registry.animals) {
                        if (a.getName().equalsIgnoreCase(targetName)) {
                            System.out.println("Enter the command to teach:");
                            String command = scanner.nextLine();
                            registry.teachCommand(a, command);
                            System.out.println("Command added successfully.");
                            targetFound = true;
                            break;
                        }
                    }
                    if (!targetFound) {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        PetRegistryApp app = new PetRegistryApp();
        app.run();
    }
}

