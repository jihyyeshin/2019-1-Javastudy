/*
 * 내부 반복자를 사용하기 때문에 병렬 처리가 쉽다.
 * 외부 반복자는 개발자가 직접 반복
 * 내부 반복자는 반복이 내부에서 됨.개발자는 요소 처리 코드에만 집중할 수 있다. & 병렬 처리가 내부에서 된다. - 속도 향상
 * */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelEx {
	public static void main(String[] args) {
		List<String> list=Arrays.asList("홍", "신", "김","람","박");
		//순차 처리
		Stream<String> stream=list.stream();
		stream.forEach(ParallelEx :: print);
		/*
		 * double colon?
		 * 
		 * Comparator c = (Computer c1, Computer c2) -> c1.getAge().compareTo(c2.getAge());를
		 * Comparator c = Comparator.comparing(Computer::getAge);이와 같이 표현할 수 있따.
		 * 객체 :: 메소드 형태 라는 것만 알고 있으면 된다.
		 * 
		 * static일 필요는 없음. 상황에 따라 쓸 수도 있다.
		 * */
		
		System.out.println();
		
		//병렬 처리
		Stream<String> paStream=list.parallelStream();
		paStream.forEach(ParallelEx :: print);
		
		//병렬 처리, parallel Stream 처리를 하면 병렬적으로 처리되는 것을 볼 수 있다. 순서대로 결과가 나오지도 않음!
	}
	public static void print(String str) {
		System.out.println(str+" : "+Thread.currentThread().getName());
	}
}
