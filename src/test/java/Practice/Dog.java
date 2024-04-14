package Practice;

public class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void sound(int numBarks) {
        for (int i = 0; i < numBarks; i++) {
            System.out.println("Dog barks");
        }
    }
}
