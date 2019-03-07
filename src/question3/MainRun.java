package question3;

public class MainRun {
	
	public static void main(String args[]){
		System.out.println("Starting Main Thread...");
		
		BMW bmw = new BMW();
        Toyota toyota = new Toyota();

        ThreadToyota tToyota = new ThreadToyota(toyota);
        ThreadBMW tBMW = new ThreadBMW(bmw);
		
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
