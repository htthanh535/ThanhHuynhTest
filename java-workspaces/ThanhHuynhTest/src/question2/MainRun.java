package question2;

public class MainRun {
	
	public static void main(String args[]){
		System.out.println("Starting Main Thread...");
		
		BMW bmw = new BMW();
        Toyota toyota = new Toyota();
        
		Thread tBMW = new Thread(bmw);
		Thread tToyota = new Thread(toyota);
        
		tBMW.start();
        tToyota.start();
    }
}
