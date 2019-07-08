
public class LightOff implements Runnable{
	private final int id;
	private int taskCount = 10;
	
	public LightOff() {
		this.id = 1;
	}
	
	public LightOff(int id) {
		this.id = id; 
	}
	
	public void status() {
		System.out.println("# " + id + " (" + taskCount + ")" );
	}

	@Override
	public void run() {
		while(taskCount > 0) {
			status(); 
			taskCount--; 
			Thread.yield();
		}
	}
}
