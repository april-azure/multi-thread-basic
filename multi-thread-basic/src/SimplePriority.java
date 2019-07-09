
public class SimplePriority implements Runnable {
	private int count = 5; 
	private double d;
	private final int priority;
	
	public SimplePriority(int priority) {
		this.priority = priority; 
	}
	
	public String toString() {
		return Thread.currentThread() + ": count at " + count ; 
	}
	
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true) {
			// expensive operation 
			for(int i = 1; i < 100000; i++) {
				d += ((Math.PI + Math.E) / (double)i);
				if(i%1000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(toString()); 
			if(--count == 0) return; 
		}
	}

}
