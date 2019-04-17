/* stream의 종류. 
 * java.util.stream에 많은 stream API가 있따.
 * base stream에 stream, intstream, longstream, doublestream이 있다!
 * stream은 객체 요소를 처리
 * intstream, longstream, doublestream은 각자의 기본 타입을 처리함.
 * */

// 컬렉션으로부터 스트림 얻기
// List<Student> Collection에서 Stream<Student>를 얻어내고 요소를 콘솔에 출력한다.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollectionEx {
	public static void main(String[] args) {
		List<Student> studentList=Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);
		
		Stream<Student> stream=studentList.parallelStream();
		stream.forEach(s->System.out.println(s.getName()));
	}
}
