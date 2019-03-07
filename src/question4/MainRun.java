package question4;

public class MainRun {
	
	public static void main(String args[]){
		System.out.println("Starting Main Thread...");
		
		Toyota toyota = new Toyota();
		BMW bmw = new BMW();
        
        Thread tToyota = new Thread(toyota);
		Thread tBMW = new Thread(bmw);
		
			tToyota.start();
	        tBMW.start();

  
		
		try {
			tToyota.join();
			tBMW.join();
	      } catch ( Exception e) {
	         System.out.println("Interrupted");
	      }

    }
}
