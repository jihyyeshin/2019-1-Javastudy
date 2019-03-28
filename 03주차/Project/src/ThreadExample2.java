
public class ThreadExample2 {
	public static void main(String[] args) {
		Thread thread =new MovieThread2();
		thread.setDaemon(true);
		thread.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		System.out.println("메인 종료");
	}
}
