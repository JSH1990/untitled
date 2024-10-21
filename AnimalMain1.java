package generic.animal;

public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animals = new Animal("동물", 0);
        Dog dog = new Dog("멍멍", 100);
        Cat cat = new Cat("냐옹이", 50);
        
        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        Dog findDog = dogBox.get();
        System.out.println(findDog);

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        Cat findCat = catBox.get();
        System.out.println(findCat);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animals);
        Animal findAnimal = animalBox.get();
        System.out.println(findAnimal);
    }
}
