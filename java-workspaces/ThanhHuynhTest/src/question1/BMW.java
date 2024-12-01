package question1;

public class BMW extends Car {
	
	public BMW() {
		maxSpeed=200;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("A BMW car is a car with: maxSpeed = " + maxSpeed);
		}
	}
	
	public void info() {
		System.out.println("The info of the BMW car:");
		System.out.println("Wheels = " + wheels);
		System.out.println("Doors = " + doors);
		System.out.println("Seats = " + seats);
		System.out.println("MaxSpeed = " + maxSpeed);
	}
}
