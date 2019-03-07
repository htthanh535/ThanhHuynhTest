package question3;

public class ThreadToyota extends Thread {
	private Thread t;
	//private String threadName;
	Toyota  toyota;
	
	ThreadToyota(Toyota  toyota) {
	   this.toyota = toyota;
	   }
	   
	   public void run() {
	      synchronized(toyota) {
	    	  toyota.run();
	      }
	   }

	   public void start () {
	      System.out.println("Starting thread Toyota" );
	      if (t == null) {
	         t = new Thread (this);
	         t.start ();
	      }
	   }
}
