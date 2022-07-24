package homeworks.hw_5_mini_project;

import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String habits[];

    Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname, int age, int trickLevel, String habits[]) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    Pet() {

    }

    void est() {
        System.out.println("I am eating");
    }

    void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.nickname);
    }

    void foul() {
        System.out.println("I need to cover it up");
    }
    @Override
    public String toString() {
        return this.species + "{nickname='" + this.nickname + "', age=" + this.age + ", trickLevel=" + this.trickLevel + ", habits=" + Arrays.toString(this.habits) + "}";
    }

}
