import java.util.*;
import java.util.stream.IntStream;

/* 매핑
 * 중간 처리 기능으로, 스트림의 요소를 다른 요소로 대처한다.
 * flatXXX(), mapXXX(), asDoubleStream(), asLongStream(), boxed가 있다.
 * 
 * flatMapXXX 메소드는 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.
 * mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다. 
 * asDoubleStream() 메소드는 int요소 또는 LongStream의 long요소를 double요소로 타입 변환하여 DoubleStream을 생성한다.
 * boxed() 메소드는 int, long, double 요소를 Integer, Long, Double요소로 박싱해서 Stream을 생성한다.
 * */

/* 정렬 sorted
 * 중간 단계에서 요소를 정렬해서 최종 처리 순서를 변경할 수 있다.
 * 
 * */
public class Student1 implements Comparable<Student1>{
	private String name;
	private int score;
	
	public Student1(String name, int score) {
		this.name=name;
		this.score=score;
	}
	
	public String getName() {return name;}
	public int getScore() {return score;}
	
	@Override
	public int compareTo(Student1 o) {
		return Integer.compare(score, o.getScore());
		//앞 값이 더 크면 양수, 같으면 0, 뒷 값이 더 크면 음수
	}
}

class SortingExample{
	public static void main(String[] args) {
		//숫자 요소인 경우
		IntStream is=Arrays.stream(new int[] {5, 3, 2, 1, 4});
		is
		 .sorted()
		 .forEach(n->System.out.println(n+","));
		System.out.println();
		//객체요소인 경우
		List<Student1> sl=Arrays.asList(
				new Student1("홍", 30),
				new Student1("신", 10),
				new Student1("유", 20)
				);
		
		sl.stream()
			.sorted()//정수를 기준으로 오름차순 정렬
			// sorted ((a, b)->a.compareTo(b)); & sorted(Comparator.naturalOrder()); 사용 가능
			.forEach(s->System.out.print(s.getScore()+","));
		System.out.println();
		
		sl.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(s->System.out.print(s.getScore()+","));
	}
}