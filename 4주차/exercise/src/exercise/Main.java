package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("?");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		int num, pnumber, i;
		boolean find = false;
		Thread th = new Thread(new Main());
		String buf;
		Scanner sc = new Scanner(System.in);
		List<Student> sList = new ArrayList();
		while (true) {
			System.out.print("번호를 입력하세요 >> ");
			num = sc.nextInt();// 번호 입력
			switch (num) {
			case 1:// 조회하기
				System.out.println("전화번호를 입력하세요.");
				pnumber = sc.nextInt();// 전화번호 입력
				for (i = 0; i < sList.size(); i++) {
					if (sList.get(i).getPnumber() == pnumber) {
						System.out.println("해당 데이터를 찾았습니다.");
						System.out.println("이름: " + sList.get(i).getName() + " 학년: " + sList.get(i).getGrade() + " 주소: "
								+ sList.get(i).getAddress() + " 전화번호: " + sList.get(i).getPnumber());
						find = true;
					}
				}
				if (find == false) {
					System.out.println("해당 데이터를 찾을 수 없습니다.");
					//th.start();
				}
				break;
			case 2:// 추가하기
				System.out.println("학생 정보를 추가하세요");
				sc.nextLine();
				buf = sc.nextLine();
				sList.add(new Student(buf.split(" ")[0], buf.split(" ")[1], buf.split(" ")[2],
						Integer.parseInt(buf.split(" ")[3])));
				break;
			}

		}

	}
}
