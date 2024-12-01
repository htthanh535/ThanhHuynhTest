package question3;

public class ThreadBMW extends Thread {
	private Thread t;
	//private String threadName;
	BMW  bmw;
	
	ThreadBMW(BMW  bmw) {
	    
	   this.bmw = bmw;
	   }
	   
	   public void run() {
	      synchronized(bmw) {
	    	  bmw.run();
	      }
	   }

	   public void start () {
	      System.out.println("Starting thread BMW" );
	      if (t == null) {
	         t = new Thread (this);
	         t.start ();
	      }
	   }
}
