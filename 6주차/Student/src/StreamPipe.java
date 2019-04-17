import java.util.*;

/* 스트림 파이프라인
 * 
 * 대량의 데이터를 가공해서 축소하는 것 : 리덕션 (ex. 데이터의 합계, 평균값 등)
 * 컬렉션의 요소를 리덕션의 결과물로 바로 집계할 수 없다면, 집계하기 좋도록 "중간처리"가 필요하다
 * */

/* 스트림의 중간 처리 - 데이터의 필터링, 매핑, 정렬, 그룹핑 등
 * 스트림의 최종 처리 - 데이터의 합게, 평균, 카운팅, 최대값, 최소값 등
 * 이러한 중간 처리와 최종 처리를 파이프라인으로 해결한다.
 * 파이프라인은 여러 개의 스트림이 연결되어 있는 구조를 말한다.
 * */
public class StreamPipe {
	public static void main(String[] args) {
		List<Member> list =Arrays.asList(
				new Member("홍", Member.MALE, 30),
				new Member("김", Member.FEMALE, 20),
				new Member("신", Member.MALE, 45),
				new Member("박", Member.FEMALE, 27)
				);
		//파이프라인 코드
		double avgAvg=list.stream()//오리지널 스트림
				.filter(m->m.getSex()==Member.MALE)//남자 member객체를 요소로 하는 새로운 스트림을 생성한다.
				.mapToInt(Member :: getAge)//중간처리 스트림, member객체를 age값으로 매핑해서 새로운 스트림을 생성한다.
				.average()//최종처리, 평균값을저장, optional double에 저장되기 떄문에
				.getAsDouble();//여기서 getasdouble메소드를 호출해서 저장된 평균값을 읽는다.
		System.out.println("남자 평균 나이: "+avgAvg);
	}
}

class Member {
	public static int MALE = 0;
	public static int FEMALE = 1;

	private String name;
	private int sex;
	private int age;

	Member(String name, int sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	int getSex() {
		return sex;
	}

	int getAge() {
		return age;
	}
}
