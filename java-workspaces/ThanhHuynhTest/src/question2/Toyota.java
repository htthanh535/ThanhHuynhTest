package question2;

public class Toyota extends Car {
	
	public Toyota() {
		maxSpeed=100;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Toyota thread " + (i+1) + " car is a car with: maxSpeed = " + maxSpeed);
		}
		System.out.println("Toyota >> End of Main Thread...");
	}
	
	
	
}
