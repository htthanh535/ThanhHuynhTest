package question3;

public class BMW {
	int maxSpeed;
	
	public BMW() {
		maxSpeed=200;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("BMW thread " + (i+1) + " car is a car with: maxSpeed = " + maxSpeed);
		}
		System.out.println("BMW >> End of Main Thread...");
	}
	
}
