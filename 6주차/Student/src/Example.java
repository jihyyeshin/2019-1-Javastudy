
//stream example code
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example {
	public static void main(String[] args) {
		List<Student> list =Arrays.asList(
			new Student("È«", 90),
			new Student("½Å", 92));
		
		Stream<Student> stream=list.stream();
		stream.forEach(s->{
			String name=s.getName();
			int score=s.getScore();
			System.out.println(name+"-"+score);
		});
	}
}

class Student{
	private String name;
	private int score;
	Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	String getName() {return name;}
	int getScore() {return score;}
}
