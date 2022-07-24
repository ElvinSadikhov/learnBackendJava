package homeworks.hw_5_mini_project;

public class Main {

    public static void main(String[] args) {
        String schedule[][] = {{"monday", "sunday"}, {"work", "gym"}};

        Pet dog = new Pet("dog", "muxtar", 2, 35, new String[]{"eating", "playing"});
        dog.est();
        dog.foul();
        dog.respond();
        System.out.println(dog);

        Pet cat = new Pet("cat", "murlik");
        cat.est();
        cat.foul();
        cat.respond();
        System.out.println(cat);

        Pet dog2 = new Pet();
        dog2.est();
        dog2.foul();
        dog2.respond();
        System.out.println(dog2);


        Human arzu = new Human();
        Human faiq = new Human("Faiq", "Zamanov", 1965);
        Human elvin = new Human("ELvin", "Sadikhov", 2003, 200, dog, arzu, faiq, schedule);
        Human zehra = new Human("Zehra", "Abdullayeva", 1965, arzu, faiq);

        elvin.greetPet();
        elvin.describePet();

        System.out.println(arzu);
        System.out.println(faiq);
        System.out.println(elvin);
        System.out.println(zehra);
    }

}
