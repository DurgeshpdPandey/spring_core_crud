package opr.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import opr.main.temp.Student;
import opr.main.temp.StudentJDBCTemplate;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("DP", 29);
		studentJDBCTemplate.create("SP", 31);
		studentJDBCTemplate.create("S", 27);

		System.out.println("------Listing Multiple Records--------");
		
		  List<Student> students = studentJDBCTemplate.listStudents();
		  
		  for (Student record : students) { System.out.print("ID : " + record.getId());
		  System.out.print(", Name : " + record.getName());
		  System.out.println(", Age : " + record.getAge()); }
		 

		/*System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);*/

		System.out.println("----Listing Record with ID = 2 -----");
		List<Student> student = studentJDBCTemplate.getStudent(9);
		for (Student record : student) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
		
	}
}