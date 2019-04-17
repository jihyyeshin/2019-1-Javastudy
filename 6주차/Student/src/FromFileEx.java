import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.stream.Stream;

//파일로부터 스트림얻기
public class FromFileEx {
	public static void main(String[] args) throws IOException{
		Path path=Paths.get("C:\\Users\\tlsjh\\OneDrive\\문서\\2019-1-Javastudy\\6주차\\Student\\src\\linedata.txt");
		Stream<String> stream;
		//Files.lines()메소드 사용
		stream=Files.lines(path, Charset.defaultCharset());
		//stream.forEach(System.out::println);
		stream.forEach(s->System.out.println(s));//같은 의미로 쓰일 수 있다!
		System.out.println();
		
		//BufferedReader의 lines() 메소드 이용
		File file=path.toFile();
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		stream=br.lines();
		stream.forEach(System.out :: println);
		
		//각각의 lines메소드를 통해 txt의 내용을 스트림을 통해 행 단위로 읽고 콘솔에 출력
	}
}
