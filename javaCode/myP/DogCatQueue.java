package myP;
/*写的一半，不是完整的，没有用*/

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    /*用户给的类，虽然没太大用，但是自己最好不要改，自己再创建一个类*/
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }
        public Pet getGet(){
            return this.pet;
        }
        public long count(){
            return this.count;
        }
        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }
}
