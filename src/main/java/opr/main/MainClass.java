package opr.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import opr.main.temp.Student;
import opr.main.temp.StudentJDBCTemplate;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		System.out.println("------Records Creation--------");
		ArrayList<Student> student=new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter size of datails");
		int size=scan.nextInt();
		for (int i=0;i<size;i++) {
			Student stu = new Student();
			System.out.println("enter name of Student ");
			stu.setName(scan.next());
			System.out.println("enter age of Student ");
			stu.setAge(scan.nextInt());
			student.add(stu);
		}
		
		studentJDBCTemplate.create(student);
		//studentJDBCTemplate.create("SP", 31);
		//studentJDBCTemplate.create("S", 27);
		

		System.out.println("------Listing Multiple Records--------");
		
		  List<Student> students = studentJDBCTemplate.listStudents();
		  
		  for (Student record : students) { System.out.print("ID : " + record.getId());
		  System.out.print(", Name : " + record.getName());
		  System.out.println(", Age : " + record.getAge()); }
		 

		/*System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);*/
		  System.out.println("enter id to get record");
		List<Student> std = studentJDBCTemplate.getStudent(scan.nextInt());
		for (Student record : std) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
		System.out.println("enter id to delete record");
		studentJDBCTemplate.delete(scan.nextInt());
		scan.close();
	}
}