package question1;

public class MainRun {
	
	public static void main(String args[]){
        BMW bmw = new BMW();
        Toyota toyota = new Toyota();
        
        toyota.run();
        bmw.run();
        
        toyota.info();
        bmw.info();
    }
}
