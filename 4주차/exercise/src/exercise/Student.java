package exercise;

/*
class 명세서 
- 이름, 학년, 주소, 전화번호 멤버변수 정의 
- 전화번호는 int형식으로 저장한다. 다른 멤버변수는 String 객체를 참조 한다.
- 변수들을 모두 클래스 내에서만 쓸 수 있도록 범위 설정을 한다.
- 멤버 변수 모두 getter와 setter 멤버함수 정의 
*/
public class Student {
	private String name;
	private String grade;
	private String address;
	private int pnumber;
	Student(String name, String grade, String address, int pnumber){
		this.name=name;
		this.grade=grade;
		this.address=address;
		this.pnumber=pnumber;
	}
	/*getter, setter*/
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
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
}
