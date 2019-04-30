import java.io.*;

public class Stream1 {
	public static void main(String[] args) throws IOException {
	OutputStream os =new FileOutputStream("C:\\Users\\tlsjh\\OneDrive\\바탕 화면\\text.txt");
	byte[] data="ABC".getBytes();
	for(int i=0;i<data.length;i++) {
		/*
		 * OutputStream에 write(int b), write(byte[] b), write(byte[] b, int off, int len)
		 * 이렇게 3가지 overloading된 메소드를 가지고 있는데, write(int b)에서 b 중 마지막 1byte만들 출력 스트림으로 보낸다.
		 * 그리고, 이를 활용할 때는 int값을 보내면 당연히 출력하지 못하고, byte값 한개를 보냈을 때만 출력이 가능하다.
		 * 그렇다면 왜 int b로 만들었을까?
		 * 그리고 os.write(data[i])하면 write(byte[] b)로 써지는 것인지, write(int b)로 써지는 것인지 모르겠음.
		 * */
		os.write(data[i]);
		//os.write(data);
	}
	/*왜 이런 식으로 쓰는지 모르겠음*/
	FileOutputStream os1=new FileOutputStream("C:\\Users\\tlsjh\\OneDrive\\바탕 화면\\text2.txt");
	Object s=new String("hello");
	System.out.println(s);
	System.out.println("complete");
	}
	
	
}
