import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

enum TypeOfAnimal{Dog, Cat}

abstract class Animal{
	protected TypeOfAnimal typeOfAnimal;
	
	protected int timeStamp;
	
	public Animal(TypeOfAnimal x, int timeStamp) {
		// TODO Auto-generated constructor stub
		typeOfAnimal = x;
		this.timeStamp = timeStamp;
	}
}

class Dog extends Animal{
	public Dog(TypeOfAnimal type, int time) {
		// TODO Auto-generated constructor stub
		super(type, time);
	}
}

class Cat extends Animal{
	public Cat(TypeOfAnimal type, int time) {
		// TODO Auto-generated constructor stub
		super(type, time);
	}
}

class AnimalShelterHelper{
	
	private int spawnTime;
	
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	
	public AnimalShelterHelper() {
		// TODO Auto-generated constructor stub
		spawnTime = 0;
		cats = new LinkedList<>();
		dogs = new LinkedList<>();
	}
	
	public void enqueue(TypeOfAnimal animalType){
		if(animalType == TypeOfAnimal.Dog){
			dogs.add(new Dog(TypeOfAnimal.Dog, spawnTime++));
		}else if(animalType == TypeOfAnimal.Cat){
			cats.add(new Cat(TypeOfAnimal.Cat, spawnTime++));
		}else{
			throw new InvalidParameterException();
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty() && cats.isEmpty()){
			throw new NoSuchElementException();
		}
		
		if(dogs.isEmpty() && !cats.isEmpty()){
			return cats.removeFirst();
		}
		
		if(!dogs.isEmpty() && cats.isEmpty()){
			return dogs.removeFirst();
		}
		
		if(dogs.getFirst().timeStamp > cats.getFirst().timeStamp){
			return dogs.removeFirst();
		}else{
			return cats.removeFirst();
		}
	}
	
	public Animal dequeueCat(){
		return cats.removeFirst();
	}
	
	public Animal dequeueDog(){
		return dogs.removeFirst();
	}
	
	public void showMyShelter(){
		for(Dog dog : dogs){
			System.out.print("Dog" + dog.timeStamp + " ");
		}
		System.out.println();
		for(Cat cat : cats){
			System.out.print("Cat" + cat.timeStamp + " ");
		}
		System.out.println();
	}
}

public class AnimalShelter_3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelterHelper testSubject = new AnimalShelterHelper();
		
		for(int i = 0 ; i < 20 ; i++){
			if(Math.random() < 0.5){
				testSubject.enqueue(TypeOfAnimal.Cat);
			}else{
				testSubject.enqueue(TypeOfAnimal.Dog);
			}
		}
		
		//testSubject.showMyShelter();
		
		System.out.println("Dog?, You got a " + testSubject.dequeueDog().typeOfAnimal);
		System.out.println("Cat?, You got a " + testSubject.dequeueCat().typeOfAnimal);
		
		System.out.println("You get a " + testSubject.dequeueAny().typeOfAnimal + " as it was the first animal in the farm.");
		
		//testSubject.showMyShelter();
	}

}
