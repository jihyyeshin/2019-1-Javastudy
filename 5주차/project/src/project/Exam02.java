/*
 *   1. 아래의 내용으로 콘솔창에 입력합니다.
 *   형식 - 이름:자바:SQL:Jdbc
 *   
 *   ------------------------------
 *   김기수:98:66:78
 *   이지수:88:56:88
 *   박수리:78:86:58
 *   ------------------------------
 * 
 *   아래와 같은 형식으로 출력하는 프로그램을 작성하시오
 *   
 *   수료 기준 
 *   - 자바 : 70점 이상
 *   - SQL  : 80점 이상
 *   - Jdbc : 80점 이상
 *   
 *   실행시의 결과 출력 형식
 *   
 *   ----------------------------------------
 *   학생정보
 *   ----------------------------------------
 *   김기수 : 총점(242점), 자바(98점-수료), SQL(66점-미수료), Jdbc(78점-미수료)
 *   박수리 : 총점(222점), 자바(78점-수료), SQL(86점-수료), Jdbc(58점-미수료)
 *   이기수 : 총점(232점), 자바(88점-수료), SQL(56점-미수료), Jdbc(88점-수료)
 *   ----------------------------------------
 */
package project;

import java.util.*;

public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> pl = new ArrayList<Student>();
		String bufStr;
		System.out.println("정보를 입력하세요");
		for (int i = 0; i < 3; i++) {
			bufStr = sc.nextLine();
			pl.add(new Student(bufStr.split(":")[0], Integer.parseInt(bufStr.split(":")[1]),
					Integer.parseInt(bufStr.split(":")[2]), Integer.parseInt(bufStr.split(":")[3])));
		}
		// Collections.sort(pl);
		for (int i = 0; i < 3; i++) {
			System.out.println(pl.get(i).getName()+" : 총점("+pl.get(i).getScore()+"점), 자바("+pl.get(i).getjScore()+"점");
		}
	}
}

class Student implements Comparable<String> {
	private String name;
	private int jScore;
	private int sScore;
	private int jdScore;
	private int score;

	public String getName() {
		return name;
	}

	public int getjScore() {
		return jScore;
	}

	public int getsScore() {
		return sScore;
	}

	public int getJdScore() {
		return jdScore;
	}

	public int getScore() {
		return score;
	}

	Student(String name, int jScore, int sScore, int jdScore) {
		this.name = name;
		this.jScore = jScore;
		this.jdScore = jdScore;
		this.sScore = sScore;
		this.score = jScore + jdScore + sScore;
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
}