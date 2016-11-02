import java.io.*;
import java.util.*;

/* User-defined Exceptions */
class NotNameException extends Exception {
	public NotNameException(String name) {
		super(name);
	}
}

class MarksOutOfRangeException extends Exception {
	public MarksOutOfRangeException(String name) {
		super(name);
	}
}
/* Base Class */
class Name {
	public String name = null, first_name = null, last_name = null, space = " ";
}
/* Marks Class */
class Marks extends Name {
	public int dlda, ds, math, oopm, eccf, dst;
}
/* Student Class which inherits our base class */
class Student extends Marks {
	public int total_marks;
}
/* We create a new class to avoid creating static methods and variables
 * Since our main method is always static, methods direclty called in that
 * class should also be static which is not good when objects are created
 * since each new instance of variable is applied to every object(Atleast in
 * my experiments it did so we planned to skip this altogether).
 * It's also creates errors like unable to deference non-static methods
 * from static references which are pain to solve.
 */
class Stuff {
	Student s[] = new Student[200];
	Student t = new Student(); /* Temporary variable */
	static int n = 0;
	static int i = 0;
	int pos_dlda = 0;
	int pos_ds = 0;	
	int pos_math = 0;
	int pos_oopm = 0;
	int pos_eccf = 0;
	int pos_dst = 0;
	int pos_total = 0;
	int countp, countf;
	Scanner sc = new Scanner (System.in);
	
	public int super_nextInt() {
		int temp;
		while(true) {
			try { 
				temp = sc.nextInt();
				if(temp >= 0 && temp <= 100) {
					break;
				}else throw new MarksOutOfRangeException("MarksOutOfRangeException");
			}catch(MarksOutOfRangeException e) {
				System.out.println("***Exception Occurred : MarksOutOfRangeException***"); 
				System.out.println("Enter the marks again : ");
			}catch(InputMismatchException e) {
				System.out.println("***Exception Occurred : NotMarksException***"); 
				System.out.println("Enter the marks again : ");
				/* nextInt() class doesn't assign ASCII value of alphabet
				 * to integer variable. This character/string lies in 
				 * memory buffer. nextInt() will keep on trying to
				 * assign to integer variable causing an infinite loop.
				 * We use a String garbage which will clear memory buffer
				 * for us.
				 */
				 String garbage = sc.next();
			}
		}
		return temp;
	}
	
	public String super_nextLine() {
		String garbage = null;
		while(true) {
			try {
				/* Consume newline layer to make nextLine() work */
				sc.nextLine();
				String temp = sc.nextLine();
				if(temp.matches("[a-zA-Z\\s]*$"))
					return temp;
				else throw new NotNameException("NotNameException");
			}catch(NotNameException e) {
				System.out.println("***Exception Occurred : NotNameException***");
				do{
					if(garbage != "clear") {
						System.out.println("Type 'clear' to continue");
					}
					garbage = sc.next();
				}while(garbage == "clear");	
				System.out.println("Enter the name again : ");
				
			}
		}
	}
	
	public int menu_nextInt() {
		int temp;
		while(true) {
			try { 
				temp = sc.nextInt();
				return temp;
			}catch(InputMismatchException e) {
				System.out.println("***Exception Occurred : InputMismatchException***"); 
				System.out.println("Enter the choice again : ");
				String garbage = sc.next();
			}
		}
	}

	public void take_input() {
			i = n;
			s[i] = new Student();
			System.out.println("Enter the First Name of student : ");
			s[i].name = super_nextLine();
			System.out.println("You are entering the scores of "+s[i].name);
			System.out.println("Marks for DLDA : ");
			s[i].dlda = super_nextInt();
			System.out.println("Marks for DS : ");
			s[i].ds = super_nextInt();
			System.out.println("Marks for Math : ");
			s[i].math = super_nextInt();
			System.out.println("Marks for OOPM : ");
			s[i].oopm = super_nextInt();
			System.out.println("Marks for ECCF : ");
			s[i].eccf = super_nextInt();
			System.out.println("Marks for DST : ");
			s[i].dst = super_nextInt();
			System.out.println("You have successfully entered the scores of the student "+s[i].name);
			s[i].total_marks = s[i].dlda + s[i].ds + s[i].math + s[i].oopm + s[i].eccf + s[i].dst;
			System.out.println("Total marks for "+s[i].name+" is "+s[i].total_marks);
		i++;
	}
	
	public void sort_totalmarks() {
		if(n > 2) {
		for(int x = 0;x <= n - 1; x++) {
			for(int y = 0;y <= n - 2 ; y++) {
				if(s[y].total_marks < s[y+1].total_marks) {
					t=s[y];
					s[y]=s[y+1];
					s[y+1]=t;
				}
				}
			}
			System.out.println("Sort complete, to view use Print to file");
		}
	}
		
	public int topper_dlda() {
		int topper_dlda = s[0].dlda;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_dlda < s[i].dlda)
			{
				topper_dlda = s[i].dlda;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_dlda == s[i].dlda)
			{
				pos_dlda = i; 
			}
		}
		return pos_dlda;
	}
	
	public int topper_math() {
		int topper_math = s[0].math;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_math < s[i].math)
			{
				topper_math = s[i].math;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_math == s[i].math)
			{
				pos_math = i; 
			}
		}
		return pos_math;
	}
	
	public int topper_oopm() {
		int topper_oopm = s[0].oopm;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_oopm < s[i].oopm)
			{
				topper_oopm = s[i].oopm;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_oopm == s[i].oopm)
			{
				pos_oopm = i; 
			}
		}
		return pos_oopm;
	}
	
	public int topper_ds() {
		int topper_ds = s[0].ds;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_ds < s[i].ds)
			{
				topper_ds = s[i].ds;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_ds == s[i].ds)
			{
				pos_ds = i; 
			}
		}
		return pos_ds;
	}
	
	public int topper_dst() {
		int topper_dst = s[0].dst;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_dst < s[i].dst)
			{
				topper_dst = s[i].dst;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_dst == s[i].dst)
			{
				pos_dst = i; 
			}
		}
		return pos_dst;
	}
	
	public int topper_eccf() {
		int topper_eccf = s[0].eccf;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_eccf < s[i].eccf)
			{
				topper_eccf = s[i].eccf;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_eccf == s[i].eccf)
			{
				pos_eccf = i; 
			}
		}
		return pos_eccf;
	}
	
	public int topper_total() {
		int topper_total = s[0].total_marks;
		for(int i = 0; i <= n - 1; i++) {
			if(topper_total < s[i].total_marks)
			{
				topper_total = s[i].total_marks;
			}
		}
		for(int i = 0; i <= n - 1; i++) {
			if(topper_total == s[i].total_marks)
			{
				pos_total = i; 
			}
		}
		return pos_total;
	}
	
	public void topper() {
		pos_dlda = topper_dlda();
		pos_ds = topper_ds();
		pos_dst = topper_dst();
		pos_math = topper_math();
		pos_oopm = topper_oopm();
		pos_eccf = topper_eccf();
	}
	
	
	public void pass_fail() {
		countp = 0;
		countf = 0;
		for(int i = 0; i <= n - 1; i++) {
			if(s[i].total_marks >= 210) {
				countp++;
			}else {
				countf++;
			}

		}
		System.out.println("No. of passed students = "+countp);
		System.out.println("No. of failed students = "+countf);
	}
	
	public void printtofile() {
		/* We need this */
		if(n > 2) {
					pass_fail();
					topper();
				}
		try(PrintWriter out = new PrintWriter("txt.txt");) {
			for(int i = 0; i <= n - 1; i++) {
				
				out.println();
				out.print(i+1);
				out.print(". Name : ");
				out.print(s[i].name);
				out.print(", DLDA : ");
				out.print(s[i].dlda);
				out.print(", DS : ");
				out.print(s[i].ds);
				out.print(", MATH : ");
				out.print(s[i].math);
				out.print(", OOPM : ");
				out.print(s[i].oopm);
				out.print(", ECCF : ");
				out.print(s[i].eccf);
				out.print(", DST : ");
				out.print(s[i].dst);
				out.print(", TOTAL MARKS : ");
				out.print(s[i].total_marks);
			}
			out.println();
			out.println();
			out.println("DLDA Topper : "+s[pos_dlda].name+" and his/her score : "+s[pos_dlda].dlda);
			out.println("DS Topper : "+s[pos_ds].name+" and his/her score : "+s[pos_ds].ds);
			out.println("Math Topper : "+s[pos_math].name+" and his/her score : "+s[pos_math].math);
			out.println("OOPM Topper : "+s[pos_oopm].name+" and his/her score : "+s[pos_oopm].oopm);
			out.println("ECCF Topper : "+s[pos_eccf].name+" and his/her score : "+s[pos_eccf].eccf);
			out.println("DST Topper : "+s[pos_dst].name+" and his/her score : "+s[pos_dst].dst);
			out.println("Overall Topper : "+s[pos_total].name+" and his/her score : "+s[pos_total].total_marks);
			out.println();
			out.println();
			out.println("No. of passed students = "+countp);
			out.println("No. of failed students = "+countf);
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("***Exception Occurred : FileNotFoundException***");
		}
	}
	
	public void menu() {
		int choice;
		
		while(true) {
			System.out.println("1 - Add Student");
			System.out.println("2 - Sort according to total marks");
			System.out.println("3 - Subject toppers & Overall topper");
			System.out.println("4 - Total number of pass & fail students");
			System.out.println("5 - Print to file");
			System.out.println("6 - Exit");
			System.out.println("Enter choice [1-6] : ");
			choice = menu_nextInt();
			switch(choice) {
				case 1 :
				take_input();
				n++;
				break;
				
				case 2 :
				if (n < 2) {
					System.out.println("Add student first.");
					System.out.println();
				}else sort_totalmarks();

				break;
				
				case 3 :
				topper();
				break;
				
				case 4 :
				pass_fail();
				break;
				
				case 5 :
				printtofile();
				break;
				
				case 6 :
				System.exit(0);
				
				default:
				System.out.println();
				System.out.println("Wrong choice");
				
			}
		}
	}
}

public class Test {
	public static void main(String args[]) {
		Stuff t1 = new Stuff();
		t1.menu();
	}
}
