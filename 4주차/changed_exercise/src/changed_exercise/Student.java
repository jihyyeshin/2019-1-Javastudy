package changed_exercise;

public class Student {
	private String name;
	private String grade;
	private String address;
	private int number;
	
	//셍성자 초기화
	Student(String name, String grade, String address, int number){
		this.name=name;
		this.grade=grade;
		this.address=address;
		this.number=number;
	}
	
	Student(String[] student){
		this.name=student[0];
		this.grade=student[1];
		this.address=student[2];
		this.number=Integer.parseInt(student[3]);
		
	}
	//getter, setter 지정
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
