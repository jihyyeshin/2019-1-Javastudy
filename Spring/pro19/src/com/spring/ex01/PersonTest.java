package com.spring.ex01;

//xml을 읽어와 빈을 생성하여 사용한다.
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));//person.xml을 일ㄺ음
		PersonService person = (PersonService) factory.getBean("personService");//id가 personService인 빈을 생성
		// PersonService person = new PersonServiceImpl();//객체를 직접 생성하지 않음을 의미
		person.sayHello();//name값을 출력한다.
	}

}