package question1;

public class Toyota extends Car {
	
	public Toyota() {
		maxSpeed=100;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("A Toyota car is a car with: maxSpeed = " + maxSpeed);
		}
	}
	
	public void info() {
		System.out.println("The info of the Toyota car:");
		System.out.println("Wheels = " + wheels);
		System.out.println("Doors = " + doors);
		System.out.println("Seats = " + seats);
		System.out.println("MaxSpeed = " + maxSpeed);
	}
	
}
