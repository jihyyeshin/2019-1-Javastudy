
public class MovieThread extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("동영상을 재생합니다.");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {

		}
	}
}
