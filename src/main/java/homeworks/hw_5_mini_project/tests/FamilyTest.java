package homeworks.hw_5_mini_project.tests;


import homeworks.hw_5_mini_project.Family;
import homeworks.hw_5_mini_project.Human;
import homeworks.hw_5_mini_project.Pet;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FamilyTest {

    @Test
    public void equalsTest() {
        Family fam1 = new Family(new Human("Gulu", "Wekerova", 1993), new Human("Elvin", "Sadixov", 1993));
        Family fam2 = new Family(new Human("Gulu", "Wekerova", 1993), new Human("Elvin", "Sadixov", 1993));

        fam1.setChildren(new Human[]{new Human("Davud", "Johnson", 2012), new Human("Nazim", "Muradov", 2013)});
        fam2.setPet(new Pet("dog", "layka"));

        assertTrue(fam1.equals(fam2));
    }

    @Test
    public void addChildTest() {
        Family fam1 = new Family(new Human("Gulu", "Wekerova", 1993), new Human("Elvin", "Sadixov", 1993));
        Human initChildren[] = new Human[]{new Human("Davud", "Johnson", 2012), new Human("Nazim", "Muradov", 2013)};
        Human newChild = new Human("Arzu", "Wamil", 2015);

        fam1.setChildren(initChildren);
        fam1.addChild(newChild);

        Human updatedChildren[] = Arrays.copyOf(initChildren, initChildren.length + 1);

        updatedChildren[2] = newChild;

        assertTrue(Arrays.equals(updatedChildren, fam1.getChildren())
                && initChildren[0].getFamily().equals(fam1)
                && initChildren[1].getFamily().equals(fam1)
                && newChild.getFamily().equals(fam1)
        );
    }

    @Test
    public void deleteChildTest() {
        Family fam1 = new Family(new Human("Gulu", "Wekerova", 1993), new Human("Elvin", "Sadixov", 1993));
        Human initChildren[] = new Human[]{new Human("Davud", "Johnson", 2012), new Human("Nazim", "Muradov", 2013), new Human("Revan", "Musayev", 2013)};

        fam1.setChildren(initChildren);

        fam1.deleteChild(initChildren[0]);


        assertTrue(Arrays.equals(fam1.getChildren(), new Human[]{initChildren[1], initChildren[2]})
            && initChildren[0].getFamily() == null
        );

        assertFalse(fam1.deleteChild(-1));

        assertFalse(fam1.deleteChild(fam1.getChildren().length));

        assertTrue(
                fam1.deleteChild(1) // this is the index for Revan Musayev!
                && Arrays.equals(fam1.getChildren(), new Human[]{initChildren[1]})
                && initChildren[2].getFamily() == null
        );

        fam1.setChildren(new Human[]{initChildren[0]});
        assertTrue(fam1.deleteChild(0)
            && fam1.getChildren().length == 0
            && initChildren[0].getFamily() == null
        );
    }

    @Test
    public void countFamilyTest() {
        Family fam1 = new Family(new Human("Gulu", "Wekerova", 1993), new Human("Elvin", "Sadixov", 1993));
        Human initChildren[] = new Human[3];
        initChildren[0] = new Human("Davud", "Johnson", 2012);
        initChildren[1] = new Human("Revan", "Musayev", 2013);
        //initChildren[3] == null

        fam1.setChildren(initChildren);

        assertTrue(fam1.countFamily() == 4);
    }

}

