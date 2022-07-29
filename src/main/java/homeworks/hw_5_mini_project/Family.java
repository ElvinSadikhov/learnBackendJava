package homeworks.hw_5_mini_project;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human children[];
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[]{};
    }

    public void addChild(Human child) {
        Human newChildrenArray[] = new Human[this.children.length + 1];

        for (int i = 0; i < this.children.length; i++)
            newChildrenArray[i] = this.children[i];

        newChildrenArray[this.children.length] = child;

        this.children = newChildrenArray;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        if(index < 0 || index >= this.children.length)  return false;

        Human newChildrenArray[] = new Human[this.children.length - 1];
        Human child = null;

        for (int i = 0, j = 0; i < this.children.length; i++) {
            if (i == index) {
                child = this.children[i];
                continue;
            }
            newChildrenArray[j++] = this.children[i];
        }

        this.children = newChildrenArray;
        child.setFamily(null);


        return true;
    }

    public boolean deleteChild(Human child) {
        if(this.children.length == 0)   return false;

        Human newChildrenArray[] = new Human[this.children.length - 1];

        for(int i = 0, j = 0; i < this.children.length; i++) {
            if(this.children[i].equals(child))  continue;
            else if(i == this.children.length - 1 && i - j == 0)    return false;

            newChildrenArray[j++] = this.children[i];
        }

        this.children = newChildrenArray;
        child.setFamily(null);

        return true;
    }

    public int countFamily() {
        return 2 + this.children.length;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return Arrays.copyOf(this.children, this.children.length);
    }

    public void setChildren(Human[] children) {
        for(int i = 0; i < this.children.length; i++) {
            this.children[0].setFamily(null);
        }

        int numberOfChildren = 0;

        for(int i = 0; i < children.length; i++) {
            if(children[i] != null) numberOfChildren++;
        }

        this.children = new Human[numberOfChildren];

        for(int i = 0, j = 0; i < children.length; i++) {
            if(children[i] != null) this.children[j++] = children[i];
        }

        for(int i = 0; i < this.children.length; i++) {
            this.children[i].setFamily(this);
        }
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) && father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    public String toString(){
        return "Family{mother=" + this.mother + ", father=" + this.father + ", children=" + Arrays.deepToString(this.children) + ", pet=" + this.pet + "}";
    }
}
