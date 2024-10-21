package generic.animal;

public class AnimalMain2 {
    public static void main(String[] args) {
        Animal animals = new Animal("동물", 0);
        Dog dog = new Dog("멍멍", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animals);
        animalBox.set(dog);
        animalBox.set(cat);

        Animal findAnimal = animalBox.get();
        System.out.println(findAnimal);
    }
}
