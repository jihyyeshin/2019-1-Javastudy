import java.util.Arrays;
import java.util.List;

/* filtering
 * distinct(), filter()
 * 필터링은 중간 처리 기능으로, 요소를 걸러내는 역할을 한다.
 * distinct()는 중복을 제거하고, filter은 조건에 따라 필터링을 해준다.
 * */
public class Filtering {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("홍", "신용", "김", "신용", "신민");
		
		//distinct는 중복 값을 제거한다.
		names.stream()
			.distinct()
			.forEach(n->System.out.println(n));
		System.out.println();
		//조건에 따라 filtering
		names.stream()
			.filter(n->n.startsWith("신"))
			.forEach(n->System.out.println(n));
		System.out.println();
		//중복제거 한 후 filtering
		names.stream()
			.distinct()
			.filter(n->n.startsWith("신"))
			.forEach(n->System.out.println(n));
	}
}
