//Andy Yang
//CSC 422 Assignment 1 Part 2 Pet Database

import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabaase {

    static ArrayList<Pet> petArray = new ArrayList<Pet>(); // Create Pet ArrayList that holds pet objects
    static int userSelection = 0; // Used to store user's display option
    static String addPet = " "; // Store user's pet information

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (userSelection != 7) {
            commandDisplay();
            userSelection = scanner.nextInt();

            while (userSelection > 7 || userSelection < 1) {
                System.out.print("ERROR, Please enter a valid option: ");
                userSelection = scanner.nextInt();
            }

            if (userSelection == 1) {
                viewPets();
            } else if (userSelection == 2) {
                addPets();
            } else if (userSelection == 3) {
                System.out.println("\n  CURRENTLY IN DEVELOPMENT\n");
                userSelection = 0;
            } else if (userSelection == 4) {
                System.out.println("\n  CURRENTLY IN DEVELOPMENT\n");
                userSelection = 0;
            } else if (userSelection == 5) {
                searchName();
            } else if (userSelection == 6) {
                searchAge();
            } else if (userSelection == 7) {
                return;
            }
        }
    }

    static void commandDisplay() { // Method used to display user's options
        System.out.println("What would you like to do?\n");
        System.out.println("  1. View all pets");
        System.out.println("  2. Add more pets");
        System.out.println("  3. Update an existing pet");
        System.out.println("  4. Remove an existing pet");
        System.out.println("  5. Search pets by name");
        System.out.println("  6. Search pets by age");
        System.out.println("  7. Exit program");
        System.out.print("\nYour choice: ");
    }

    static void viewPets() { // Method used to display current stored pet objects in pet database
        if (petArray.isEmpty()) {
            System.out.println("\n  No pets have been saved\n");
            return;
        }

        System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");

        for (Pet currentPet : petArray) {
            System.out.printf("%3d %10s %4d\n", currentPet.getId(), currentPet.getName(), currentPet.getAge());
        }
        System.out.println("\n  " + petArray.size() + " Rows in this Set\n");
    }

    static void addPets() { // Method to add pets by taking in name and age from user and storing in
                            // petArray

        String petName;
        int petAge;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n  To exit add pets option type \"done\"");

        while (addPet != "done" || addPet != "Done") {
            System.out.print("\nAdd pet (name, age): ");
            addPet = scanner.nextLine();
            if (addPet.equalsIgnoreCase("done")) {
                return;
            } else {
                String[] petRow = addPet.split(" ");
                petName = petRow[0];
                petAge = Integer.parseInt(petRow[1]);
                petArray.add(new Pet(petName, petAge));
                System.out.print(petName + " " + petAge + " years old has been added\n");
            }
        }
        addPet = " "; // Reset userinput from "done" to null to allow loop to go through
    }

    static void searchName() { // Method to search current pet objects by name

        ArrayList<Pet> petNameArray = new ArrayList<>(); // Creating temporary Pet array to fill with searched name pet
                                                         // objects
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a name to search: ");
        String petNameSearch = scanner.nextLine();

        for (int i = 0; i < petArray.size(); i++) { // Populates new temporary pet array with pet objects with given
                                                    // name

            if (petArray.get(i).getName().equalsIgnoreCase(petNameSearch)) // Checks if name of row iteration of pet in
                                                                           // petarray matches user's pet name input
                petNameArray.add(petArray.get(i)); // If they match, temporary pet array adds that pet object from
                                                   // original petarray

        }
        if (petNameArray.isEmpty()) // After populating new temporary pet array if it's empty do following
            System.out.println("\nNo pets with name " + petNameSearch + " was found");
        else
            System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age"); // If not empty, print out the temporary pet
                                                                        // array of given name
        for (Pet currentPet : petNameArray) {
            System.out.printf("%3d %10s %4d\n", currentPet.getId(), currentPet.getName(), currentPet.getAge());
        }
        System.out.println("");
    }

    static void searchAge() { // Method to search current pet objects by age

        ArrayList<Pet> petAgeArray = new ArrayList<>(); // Creating temporary Pet array to fill with searched pet
                                                        // objects with given age
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the age of a pet to search: ");
        int petAgeSearch = scanner.nextInt();

        for (int i = 0; i < petArray.size(); i++) { // Populates new temporary pet array with pet objects with given
                                                    // name

            if (petArray.get(i).getAge() == (petAgeSearch)) // Checks if age of row iteration of pet in petarray matches
                                                            // user's pet age input
                petAgeArray.add(petArray.get(i)); // If they match, temporary pet array adds that pet object from
                                                  // original petarray

        }
        if (petAgeArray.isEmpty()) // After populating new temporary pet array if it's empty do following
            System.out.println("\nNo pets with the age of " + String.valueOf(petAgeSearch) + " found");
        else
            System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age"); // If not empty, print out the temporary pet
                                                                        // array with given age
        for (Pet currentPet : petAgeArray) {
            System.out.printf("%3d %10s %4d\n", currentPet.getId(), currentPet.getName(), currentPet.getAge());
        }
        System.out.println("");
    }
}
