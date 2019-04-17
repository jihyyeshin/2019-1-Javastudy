import java.util.*;
//스트림은 중간 처리와 최종 처리를 한다.
public class MapAndReduce {
	public static void main(String[] args) {
		List<Student> sl=Arrays.asList(
				new Student("홍", 10),
				new Student("신",20),
				new Student("유",30)
				);
		/* arrays.asList
		 * ArrayList, List는 내부적으로 배열이다. asList로 반환하는 List도 배열을 갖게 된다.
		 * 이 떄 원본 배열의 주소 값을 가져오게 되므로, 원본 배열의 내용도 변경된다.
		 * 이러한 이유로 Arrays.asList로 만든 List에 새로운 원소를 추가하거나 삭제할 수는 없다.
		 * 그러면 Arrays.asList를 왜 이용할까?
		 * Arrays.asList는 배열의 내용을 수정하려고 할 때 List로 바꿔서 편리하게 사용하기 위함!
		 * */
		
		double avg=sl.stream()
				//중간처리
				.mapToInt(Student::getScore)//점수를 가져옴
				//최종처리
				.average()//intstream의 평균을 구하는 메서드
				.getAsDouble();//이를 double값으로 가져온다.
		
		System.out.println("평균 점수: "+avg);
	}
}
//즉, 처리 단계를 여러 번 거칠 수 있다. 그런 식으로 stream의 메서드들이 정의되어 있음.
