import java.io.FileOutputStream;
import java.io.OutputStream;

//import java.io.*;
//import java.util.Scanner;
//
//public class Test1 {
//	public void main(String[] args) throws IOException {
////		OutputStream os=new FileOutputStream("C:\\Users\\tlsjh\\OneDrive\\πŸ≈¡ »≠∏È\\text.txt");
////		Scanner sc=new Scanner(System.in);
////		String s=sc.nextLine();
////		byte[] b=s.getBytes();
////		for(int i=0;i<b.length;i++)
////			os.write(b[i]);
////		os.close();
////		System.out.println("he");
//	}
//}


public class Test1 {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		byte[] data = "ABC".getBytes();
		for(int i=0; i<data.length; i++) {
			os.write(data[i]);
		}
		os.flush();
		os.close();
	}

}