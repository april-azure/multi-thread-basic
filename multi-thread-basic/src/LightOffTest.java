import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LightOffTest {
//	public static void main(String[] args) {
//		LightOff lightoff = new LightOff(); 
//		lightoff.run();
//		
//	}
	
	
	// execute 5 lightoffs at same time
	// a single thread is creating 5 other threads 
//	public static void main(String[] args) {
//		for(int i = 0; i < 5; i++) {
//			Thread thread = new Thread(new LightOff(i)); 
//			thread.start();
//		}
//	}
	
	// use threadpool, CachedThreadPool
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(); 
		for(int i = 0; i < 5; i++) {
			exec.execute(new LightOff(i));
		}
		exec.shutdown(); // prevent new task from register to the executor
	}
}
