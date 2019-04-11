/*
1. 아래의 내용을 콘솔창에 입력받습니다!
------------------------------
윤성빈:89
이상화:69
이승훈:77
김은정:90
최민정:84
------------------------------

2. 선수 한명의 정보를 표현하는 Player 클래스를 작성합니다.(이름, 스코어)

3. 아래와 같이 출력하는 프로그램을 작성합니다.

출력형식 > 

선수 성적순
선수명   점수
-------------
김은정 선수  90점
윤성빈 선수  89점
최민정 선수  84점
이승훈 선수  77점
이상화 선수  69점
-------------

 */
package project;

import java.util.*;
public class Exam01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Player> pl=new ArrayList<Player>();
		String bufStr;
		System.out.println("선수 정보를 입력하세요");
		for(int i=0;i<5;i++) {
			bufStr=sc.nextLine();
			pl.add(new Player(bufStr.split(":")[0], Integer.parseInt(bufStr.split(":")[1])));
		}
		Collections.sort(pl, new Comparator<Player>(){
			@Override
			public int compare(Player a, Player b) {
				if(a.getScore()>b.getScore())
					return -1;
				else if (a.getScore()<b.getScore())
					return 1;
				else
					return 0;
			}
		});
		
		System.out.println("-------------");
		for(int i=0;i<pl.size();i++) {
			//System.out.println(pl.get(i).getName()+" 선수 "+pl.get(i).getScore()+"점");
			System.out.println(pl.get(i));
		}
		System.out.println("-------------");
	}
}


class Player{
	private String name;
	private int score;
	
	Player(String name, int score){
		this.name=name;
		this.score=score;
	}
	public void setName(String name) {
		this.name = name;
	}
	//toString을 Override, 출력을 잘 하기 위해서
	//println에 toString이 자동으로 호출되기 때문에 Override
	@Override
	public String toString() {
		return name+" 선수 "+score+"점";
	}
	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
}