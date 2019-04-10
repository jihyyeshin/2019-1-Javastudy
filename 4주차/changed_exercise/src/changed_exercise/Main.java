package changed_exercise;

import java.util.*;

public class Main {
	/* collection에
	 * list, map, set계열 3가지가 존재함. 이들은 모두 구현되지 않은 interface이다.
	 * 각각은 자신들만의 고유한 특징을 가지고 있다.
	 * 
	 * List
	 * 순서를 가지며, 동일한 데이터의 중복이 가능하다.
	 * Vector은 동기화, ArrayList는 비동기화
	 * ex. ArrayList, LinkedLst, Vector
	 * 
	 * Map
	 * Key&Value의 형태를 가지며, 키값을 입력하면 value를 획득한다. 수집의 순서를 기억하지 않고 동일한 데이터를 key로 쓸 수 없다.
	 * HashMap - 데이터 입출력 동기화 X(synchronized키워드없음), 처리 속도가 빠름
	 * HashTable - 입출력 동기화 O(synchronized키워드있음), 처리 속도 떨어진다.
	 * ### synchronized : multi-thread로 동시 접근되는 것을 막는다.
	 * 메소드에 synchronized를 걸면 그 함수가 포함된 해당 객체에 lock을 거는 것.
	 * ex. HashMap, HashTable
	 * 
	 * Set
	 * 중복데이터를 허용하지 않는다. 순차적인 접근을 위해 iterator로 접근.
	 * ex. HashSet
	 * 
	 * HashMap을 사용하는 이유?(ArrayList vs HashMap)
	 * #ArrayList는 정보를 검색하기 위해 사용자가 모든 index를 알아야 한다.
	 * index를 알고 있다면 ArrayList가 HashMap보다 빠르다!
	 * #HashMap은 key값을 Object객체로 가지고 있다. 이 key로 바로 원하는 정보를 얻어낸다.
	 * 검색 능력이 탁월하다고 할 수 있다. 
	 */
	
	/* static 키워드에 대해
	 * 
	 * 클래스를 설계할 때, 모든 인스턴스에 공통적으로 사용해야하는 것에 static을 붙인다.
	 * 각 인스턴스가 독립적이기 때문에, 서로 다른 값을 유지하는데, 모든 인스턴스가 같은 값을 유지해야 하는 경우에 static을 붙인다.
	 * 
	 * static이 붙은 멤버변수는 인스턴스를 생성하지 않아도 사용할 수 있다.
	 * 왜냐하면, static이 붙은 멤버변수는 클래스가 메모리에 올라갈 때 자동적으로 생성된다.
	 * 
	 * static이 붙은 메서드는 인스턴스 변수를 사용할 수 없다. 왜냐하면, 인스턴스 변수는 인스턴스가 생성되었을 떄만 존재하는데,
	 * static이 붙은 메서드는 인스턴스 생성 없이 호출할 수 있기 떄문에, static이 인스턴스 변수를 사용할 떄 인스턴스가 이미 생성되었는지
	 * 아닌지를 알 수 없다.
	 * 
	 * 자신(각 인스턴스)만의 값을 유지해야한다면 인스턴스 변수를 쓰고,
	 * 모두가 같은 값을 유지해야 한다면 클래스 변수(static 변수)를 사용하자!
	 * static 변수는 또한 호출시간이 짧기 때문에 인스턴스 메소드안에서 사용되지 않는다면 static으로 선언하는 것을 추천한다!
	 * */
	static HashMap<Integer, Student>list =new HashMap<Integer, Student>();
	//HashMap의 사용 용도 : 학생 정보 저장
	static HashSet<Integer> list_search=new HashSet<Integer>();
	//HashSet의 사용 용도 : 찾아야 하는 학생 정보 저장(찾지 못한다면 추가될 때 까지 계속 search)
	
	/* 여기서 HashSet을 사용하는 이유?
	 * 앞서 본 것 처럼 ArrayList를 사용했다면 중복된 정보를 계속해서 저장할 것. 중복된 정보가 계속 저장되면 Thread가 계속해서 중복된 값을 찾을 것이다.
	 * 하지만, HashSet은 Set계열의 특성상 중복 데이터를 허용하지 않음. 따라서 HashSet을 사용하게 된다.
	 * */
	
	public static void main(String[] args) {
		System.out.println("DB TERM PROJECT");
		System.out.println("1: 조회하기");
		System.out.println("2: 추가하기");
		while(true) {//계속해서 조회, 추가. 종료되지 않는다
			Scanner sc=new Scanner(System.in);
			System.out.println("입력: ");
			
			int number=sc.nextInt();//조회, 또는 추가를 선택한다	
			
			//////////////////
			Runnable runnable=()->{
				try {
					Thread.sleep(10000);
					if(list!=null & list_search!=null) {
						Iterator<Integer> it=list_search.iterator();//iterator 생성
					
						while(it.hasNext()) {
							int check=it.next();
							if(list.containsKey(check)) {
								System.out.println("해당 데이터를 찾았습니다");
								System.out.println("학생 이름: "+list.get(check).getName()+" ");
								System.out.println("학년: "+list.get(check).getGrade()+" ");
								System.out.println("주소: "+list.get(check).getAddress()+" ");
								System.out.println("전화번호"+list.get(check).getNumber());
								list_search.remove(check);
							}
							
						}
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			};
			Thread thread=new Thread(runnable);
			thread.start();
			sc.nextLine();
			//////////////////
			
			if(number==1) {//조회를 선택했을 때
				//조회하기
				//전화번호 입력 받기, 전화번호가 키값이기 때문에 
				int input=sc.nextInt();
				
				//키 값 찾기
				if(list.containsKey(input)) {//해당 키를 가지고 있는지 찾는다. HashMap의 메소드, 가지고 있다면 true를 반환한다.
					System.out.println("해당 데이터를 찾았습니다.");
					System.out.println("학생 이름: "+list.get(input).getName());
					System.out.println("학년: "+list.get(input).getGrade());
					System.out.println("주소: "+list.get(input).getAddress());
					System.out.println("전화번호: "+list.get(input).getNumber());//해당 번호를 출력한다
				}else {
					System.out.println("해당 데이터를 찾을 수 없습니다");
					list_search.add(input);//데이터를 찾을 수 없는 경우에는 list_search에 추가시킨다. 이를 찾아내야 한다는 뜻! 나중에 추가되었을 때 다른 thread에서 찾아서 출력해준다.
				}
				
			}
			else if(number==2) {
				//추가하기
				//학생 정보 입력
				System.out.print("추가하기: ");
				String input=sc.nextLine();
				StringTokenizer st=new StringTokenizer(input);//string tokenizer을 이용하여 input을 나눈다. 한 줄에 입력하기 때문에
				String student[]=new String[4];//각각의 정보를 저장해둘 것
				int i=0;
				while(st.hasMoreTokens()) {
					student[i]=(String)st.nextToken();//저장
					i++;
				}
				if(list.containsKey(Integer.parseInt(student[3]))) {
					System.out.println("데이터가 이미 존재합니다.");
					continue;//데이터가 이미 존재한다면, 객체를 생성하지 않고(저장하지 않고) continue
				}
				
				//student 객체 생성
				Student student_info=new Student(student);
				//list 추가
				list.put(Integer.parseInt(student[3]), student_info);//list에 정보를 추가시킨다.
				
				System.out.println("추가 완료");
			}
			else {
				System.out.println("bye");
				break;
			}
		}
	}
	
}
