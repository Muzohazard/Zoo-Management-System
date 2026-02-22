package midsemesterquiz;

import java.util.ArrayList;
import java.util.List;

//Animal Class
class Animal {
 private int animalID;
 private String name;
 private String species;
 private int age;
 private String healthStatus;
 private String feedingSchedule;
 private Enclosure enclosure;

 public Animal(int animalID, String name, String species, int age, String healthStatus, String feedingSchedule, Enclosure enclosure) {
     this.animalID = animalID;
     this.name = name;
     this.species = species;
     this.age = age;
     this.healthStatus = healthStatus;
     this.feedingSchedule = feedingSchedule;
     this.enclosure = enclosure;
     enclosure.addAnimal(this);
 }

 public void updateHealthStatus(String newStatus) {
     this.healthStatus = newStatus;
 }

 public void moveEnclosure(Enclosure newEnclosure) {
     this.enclosure.removeAnimal(this);
     this.enclosure = newEnclosure;
     newEnclosure.addAnimal(this);
 }

 public String getSpecies() {
     return species;
 }

 @Override
 public String toString() {
     return "Animal ID: " + animalID + ", Name: " + name + ", Species: " + species +
            ", Age: " + age + ", Health: " + healthStatus + ", Feeding Schedule:" + feedingSchedule + ", Enclosure:" + enclosure.getName();
 }
}

//Enclosure Class
class Enclosure {
 private int enclosureID;
 private String name;
 private List<Animal> animals;

 public Enclosure(int enclosureID, String name) {
     this.enclosureID = enclosureID;
     this.name = name;
     this.animals = new ArrayList<>();
 }

 public void addAnimal(Animal animal) {
     animals.add(animal);
 }

 public void removeAnimal(Animal animal) {
     animals.remove(animal);
 }

 public String getName() {
     return name;
 }

 public void displayAnimals() {
     System.out.println("Animals in " + name + ":");
     for (Animal animal : animals) {
         System.out.println(animal);
     }
 }
}

//Zookeeper Class
class Zookeeper {
 private int zookeeperID;
 private String name;
 private List<Enclosure> assignedEnclosures;

 public Zookeeper(int zookeeperID, String name) {
     this.zookeeperID = zookeeperID;
     this.name = name;
     this.assignedEnclosures = new ArrayList<>();
 }

 public void assignEnclosure(Enclosure enclosure) {
     assignedEnclosures.add(enclosure);
 }

 public void displayEnclosures() {
     System.out.println("Zookeeper " + name + " manages the following enclosures:");
     for (Enclosure enclosure : assignedEnclosures) {
         System.out.println(enclosure.getName());
     }
 }
}

//Zoo Management Class
class ZooManagement {
 private List<Animal> allAnimals;

 public ZooManagement() {
     this.allAnimals = new ArrayList<>();
 }

 public void addAnimal(Animal animal) {
     allAnimals.add(animal);
 }

 public void displayAnimalsBySpecies(String species) {
     System.out.println("Animals of species " + species + ":");
     for (Animal animal : allAnimals) {
         if (animal.getSpecies().equalsIgnoreCase(species)) {
             System.out.println(animal);
         }
     }
 }
}

public class LusakaZooTracker {

	public static void main(String[] args) {
		Enclosure lionEnclosure = new Enclosure(1, "Lion Habitat");
        Enclosure birdEnclosure = new Enclosure(2, "Bird Sanctuary");
        Enclosure zebraEnclosure = new Enclosure(3,"Zebra Paddock");

        Zookeeper Musonda = new Zookeeper(1, "Musonda Kaoma");
        Musonda.assignEnclosure(lionEnclosure);
        Musonda.assignEnclosure(birdEnclosure); 
        Zookeeper Joshua = new Zookeeper(2, "Joshua Banda");
        Joshua.assignEnclosure(zebraEnclosure);

        Animal lion1 = new Animal(101, "Simba", "Lion", 5, "Healthy","10 AM, 6 PM", lionEnclosure);
        Animal parrot1 = new Animal(102, "Polly", "Parrot", 2, "Healthy", "8 AM, 4 PM", birdEnclosure);
        Animal zebra1 = new Animal(103, "Zeno", "Zebra", 7, "Healthy", "7 AM, 5 PM", zebraEnclosure);

        ZooManagement zoo = new ZooManagement();
        zoo.addAnimal(lion1);
        zoo.addAnimal(parrot1);
        zoo.addAnimal(zebra1);

        lionEnclosure.displayAnimals();
        birdEnclosure.displayAnimals();
        zebraEnclosure.displayAnimals();
        Musonda.displayEnclosures();
        Joshua.displayEnclosures();
        zoo.displayAnimalsBySpecies("Zebra");
		

	}

}
