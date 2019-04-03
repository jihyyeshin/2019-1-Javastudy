package example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class MainClass {
	/*
	 * @FunctionalInterface functional interface, 즉 함수형 인터페이스는 Object클래스의 메소드를 제외하고
	 * 단 하나의 추상 메소드만 가지는 interface이다. 이를 체크해주기 위해 존재하는 것이 @FunctionalInterface, 함수형
	 * 인터페이스 체크 어노테이션이다.
	 * 
	 * Object 클래스 메소드를 제외하는 이유? 모든 객체는 Object 객체를 상속하고 있기 때문에, Object 객체의 메소드들을 이미
	 * 소유하고 있어서.
	 * 
	 * 그래서, 람다식의 결과가 functional interface의 인스턴스다.
	 * 
	 * 람다식 자바에서는 메소드를 객체를 통해서만 접근 가능하고, 메소드 그 자체는 사용하지 못했다. 자바의 람다식은 새로운 방식을 도입한 것은
	 * 아니고, 기존의 interface를 람다식으로 표현한 것.
	 * 
	 * 원래 자바 언어에서는 새로운 클래스를 만들어야만 인스턴스 생성이 가능했지만, 람다식을 통해 이것이 해소됨.
	 * 
	 * 굳이 새로운 인터페이스를 생성하지 않고도 원래 존재하던 인터페이스를 사용하여 람다식을 처리할 수도 있다. java.util.function
	 * 패키지에 많은 functional interface들이 등록되어 있다. 이 패키지에 등록되어 있는 모든 인터페이스들은 @Fun-
	 * 어노테이션으로 지정되어있다. 대표적인 인터페이스는 Consumer, Function, Predicate
	 * 
	 * 이 인터페이스들이 java.util.stream.Stream 인터페이스와 결합되어 강력한 기능을 제공함 람다식과 stream 인터페이스가
	 * 결합하여 List를 일괄적으로 처리할 수 있도록 도와준다. 대표적인 메소드는 filter, map, forEach
	 */
	private static Runnable lambdaTest(Runnable runnable) {
		runnable.run();
		return () -> System.out.println("return lambda");
	}

	public static void main(String[] args) {
		lambdaTest(() -> System.out.println("input lambda")).run();

		/*
		 * java.util.Predicate 임의의 타입 T 형태의 객체입력을 받아 그 값이 true인지 false인지를 리턴한다.
		 */
		Predicate<String> stringCompare = (String str) -> str.compareTo("abc") == 0 ? true : false;
		System.out.println("Predicate test for abc=" + stringCompare.test("abc"));

		/*
		 * java.util.Function 첫번째 형태의 입력값을 받아 두번쨰 형태로 출력한다.
		 */
		Function<String, Integer> intFunctionLambda = (String str) -> str.compareTo("abc") == 0 ? 1 : 0;

		System.out.println("intFunctionLambda test for abc=" + intFunctionLambda.apply("abc"));

		Function<String, Float> floatFunctionLambda = (String str) -> str.compareTo("abc") == 0 ? (float) 1.0
				: (float) 0.0;

		System.out.println("floatFunctionLambda test for abc=" + floatFunctionLambda.apply("abc"));

		/*
		 * java.util.Consumer
		 * 임의형태의 입력값<T>을 받아 처리하고 출력은 하지 않는 형태의 인터페이스이다.
		 */
		Consumer<String> c1 = t -> System.out.println(t + "8");
		c1.accept("java");
		
		/*
		 * java.util.Supplier
		 * getXXX()메서드를 가지고 있음. 입력이 없고 return만 있다.
		 */
		IntSupplier is = () -> {
			int a = (int) (Math.random() * 6) + 1;
			return a;
		};

		int aa = is.getAsInt();
		System.out.println(aa);
	
		/*
		 * 람다식으로 인해 큰 영향을 받은 API는 콜렉션.
		 * forEach(), stream()
		 */
		
		/*
		 * forEach() -> List예제
		 * 향상된 for문과 동일하게 쓰이지만, 향상된 for문은 안에 작성되는 코드가 자유롭고, 값의 변경이
		 * 가능한 반면, forEach()는 불가능하기 때문에 병렬 프로그래밍에서도 중요한 요소로 사용된다.
		 * */
		List<String> list1=new ArrayList();
		list1.add("A");
		list1.add("B");
		list1.forEach((x)->System.out.println("List item = "+x));
		
		/*
		 * Stream객체
		 * 
		 * */
		
		
		
		
		
	}
}