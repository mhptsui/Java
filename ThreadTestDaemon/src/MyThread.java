import java.io.IOException;

public class MyThread extends Thread {

	public MyThread(String threadName, boolean isDaemon) {
		this.name = threadName;
		setDaemon(isDaemon);
	}
	
	public static void main(String[] args) {
		Thread first = new MyThread("first", true);
		
		System.out.println("Press Enter to quit...");
		first.run();

		try {
			System.in.read();
			System.out.println("Pressed Enter");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ending main()...");
		return;
	}
	public void run() {
		try {
			for (int i=0; i<20; i++) {
				System.out.println(name+" "+i);
				sleep(500L);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String name;
}
