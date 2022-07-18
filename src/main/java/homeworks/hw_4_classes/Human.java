package homeworks.hw_4_classes;

public class Human {
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String schedule[][];

    Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String schedule[][]) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    Human() {

    }

    void greetPet() {
        System.out.printf("Hello, %s\n", this.pet.nickname);
    }

    void describePet() {
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                this.pet.species, this.pet.age, this.pet.trickLevel > 50 ? "very sly" : "almost not sly");
    }
    @Override
    public String toString(){
        return "Human{name='" + this.name + "', surname='" + this.surname + "', year=" + this.year + ", iq=" + this.iq + ", mother='" + (this.mother != null ? this.mother.name + " " + this.mother.surname : "null") + "', father='" + (this.father != null ? this.father.name + " " + this.father.surname : "null") +"', pet=" + this.pet + "}";
    }

}
