package question4;

public class BMW extends Car {
	
	public BMW() {
		maxSpeed=200;
	}
	
	synchronized public void run() {
		//synchronized(this) {
			for(int i=0; i<10; i++) {
				System.out.println("BMW thread " + (i+1) + " car is a car with: maxSpeed = " + maxSpeed);
				try
	            { 
	                Thread.sleep(400); 
	            } 
	            catch (Exception e) 
	            { 
	                System.out.println(e); 
	            }
			}
		//}
			try 
	        { 
	            Thread.sleep(1000); 
	        }  
	        catch (Exception e)  
	        { 
	            System.out.println("Thread interrupted."); 
	        } 

		System.out.println("BMW >> End of Main Thread...");
	}
	
}
