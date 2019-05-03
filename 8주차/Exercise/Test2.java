import java.io.*;

public class Test2 {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("C:\\Users\\tlsjh\\OneDrive\\문서\\2019-1-Javastudy\\8주차\\Exercise\\Text1.java");
		BufferedReader br = new BufferedReader(fr); 
		int newNum=1;
		while(true) {
			byte[] b=new byte[100];
			String num=br.readLine();
			if(num==null) break;			
		}
	}
}