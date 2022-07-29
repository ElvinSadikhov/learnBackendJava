package homeworks.hw_5_mini_project;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String schedule[][] = {{"monday", "work"}, {"sunday", "gym"}};

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
        Human zehra = new Human("Zehra", "Abdullayeva", 1965);


        System.out.println(arzu);
        System.out.println(faiq);
        System.out.println(zehra);

        Family fam = new Family(new Human("Gulu", "Wekerova", 1993), new Human("Elvin", "Sadixov", 1993));
        fam.addChild(zehra);
        fam.addChild(faiq);
        System.out.println(fam);
    }

}
