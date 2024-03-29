package opr.main.temp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import opr.main.intf.StudentDAO;

public class StudentJDBCTemplate implements StudentDAO {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }
	   public void create(ArrayList<Student> stu) {
		   String SQL = "insert into Student (name, age) values (?, ?)";
		   for (Iterator iterator = stu.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			Object[] args = {student.getName(),student.getAge().toString()};
		      jdbcTemplateObject.update( SQL, args);
		      System.out.println("Created Record Name = " + student.getName() + " Age = " + student.getName());
		}
	      
	      
	     
	      return;
	   }
	   public List<Student> getStudent(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      List<Student> student = jdbcTemplateObject.query(SQL,new StudentMapper(), 
	         new Object[]{id} );
	      
	      return student;
	   }
	   public List<Student> listStudents() {
	      String SQL = "select * from Student";
	      List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
	      return students;
	   }
	   public void delete(Integer id) {
	      String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
	   public void update(Integer id, Integer age){
	      String SQL = "update Student set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, age, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	   }
	   public void insert(Integer id, Integer age){
		      String SQL = "update Student set age = ? where id = ?";
		      jdbcTemplateObject.update(SQL, age, id);
		      System.out.println("Updated Record with ID = " + id );
		      return;
		   }
	
	
	
}
