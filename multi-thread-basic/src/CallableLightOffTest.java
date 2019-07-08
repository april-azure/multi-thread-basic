import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableLightOffTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(); 
		List<Future<String>> results = new ArrayList<Future<String>>(); 
		for(int i = 0; i < 10; i++) {
			results.add(exec.submit(new CallableLightOff(i))); 
		}
		for(Future<String> future : results) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				
			} catch (ExecutionException e) {
				
			} finally {
				exec.shutdown();
			}
		}
	}
}
