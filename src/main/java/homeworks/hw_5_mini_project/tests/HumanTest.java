package homeworks.hw_5_mini_project.tests;

import homeworks.hw_5_mini_project.Human;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HumanTest {

    @Test
    public void getScheduleTest() {
        String schedule[][] = {{"monday", "work"}, {"sunday", "gym"}};
        Human human = new Human("Elvin", "Sadixov", 1965, 200, schedule);

        String schedule2[][] = human.getSchedule();

        schedule2[1][1] = "shopping";

        assertFalse(Arrays.equals(schedule, schedule2));
    }

    @Test
    public void equalsTest() {
        Human human1 = new Human("Elvin", "Sadixov", 1965, 200, new String[][]{{"monday", "sunday"}, {"work", "gym"}});
        Human human2 = new Human("Elvin", "Sadixov", 1965, 201, new String[][]{{"tuesday", "sunday"}, {"shopping", "work"}});

        assertTrue(human1.equals(human2));
    }

}
