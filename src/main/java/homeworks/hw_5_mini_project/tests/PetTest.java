package homeworks.hw_5_mini_project.tests;
import homeworks.hw_5_mini_project.Pet;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PetTest {


    @Test
    public void getHabitsTest() {
        String initHabits[] = new String[]{"playing"};
        Pet pet = new Pet("dog", "layka", 2, 50, initHabits);

        String habits2[] = pet.getHabits();

        habits2[0] = "sleeping";

        assertFalse(Arrays.equals(initHabits, habits2));
    }

    @Test
    public void equalsTest() {
        Pet pet1 = new Pet("dog", "layka", 2, 51, new String[]{"playing"});
        Pet pet2 = new Pet("dog", "layka", 2, 49, new String[]{"sleeping"});

        assertTrue(pet1.equals(pet2));
    }
}
