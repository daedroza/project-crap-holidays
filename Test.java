import java.io.*;
import java.util.*;

class MarksOutOfRangeException extends Exception {
	public MarksOutOfRangeException(String name) {
		super(name);
	}
}
/* Base Class */
class Name {
	static public String name, first_name, last_name, space = " ";
}
/* Marks Class */
class Marks extends Name {
	static public int dlda, ds, math, oopm, eccf, dst;
}
/* Student Class which inherits our base class */
class Student extends Marks {
	static public int total_marks;
}
public class Test {

	static int countp = 0, countf =0;
	
	public static int super_nextInt(Scanner sc) {
		int temp = 0;
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
				 * to integer variable. This character/string lies at the
				 * end of memory buffer. nextInt() will keep on trying to
				 * assign to integer variable causing an infinite loop.
				 * We use a String garbage which will clear memory buffer
				 * for us.
				 */
				 String garbage = sc.next();
			}
		}
		return temp;
	}
	
	public static void take_input(Student s[], Scanner sc,int i) {

			System.out.println("Enter the First Name of student : ");
			s[i].first_name = sc.next();
			System.out.println("Enter the Last Name of Student : ");
			s[i].last_name = sc.next();
			s[i].name = s[i].first_name + s[i].space + s[i].last_name;
			System.out.println("You are entering the scores of "+s[i].name);
			System.out.println("Marks for DLDA : ");
			s[i].dlda = super_nextInt(sc);
			System.out.println("Marks for DS : ");
			s[i].ds = super_nextInt(sc);
			System.out.println("Marks for Math : ");
			s[i].math = super_nextInt(sc);
			System.out.println("Marks for OOPM : ");
			s[i].oopm = super_nextInt(sc);
			System.out.println("Marks for ECCF : ");
			s[i].eccf = super_nextInt(sc);
			System.out.println("Marks for DST : ");
			s[i].dst = super_nextInt(sc);
			System.out.println("You have successfully entered the scores of the student "+s[i].name);
			System.out.println("\n");
			/* Calculate total marks */
			for(int l = 0; i < n - 1; i++) {
			s[i].total_marks = s[i].dlda + s[i].ds + s[i].math + s[i].oopm + s[i].eccf + s[i].dst;
			System.out.println("Total marks for "+s[i].name+" is "+s[i].total_marks);
		}
		i++;
	}
	
	public static void sort_totalmarks(Student s[], Student t) {
		for(int x = 0;x < n - 1; x++) {
			for(int y = 0;y < n - 1 ; y++) {
				if(s[y].total_marks < s[y+1].total_marks) {
					t=s[y];
					s[y]=s[y+1];
					s[y+1]=t;
				}
			}
		}
	}
	
	/* Was kept inside sub_topper initially.
	 * Removed it here, so that Printer functions can access too
	 * instead of passing them which is a tedious work.
	 */
	
	static int pos_dlda = 0;
	static int pos_ds = 0;	
	static int pos_math = 0;
	static int pos_oopm = 0;
	static int pos_eccf = 0;
	static int pos_dst = 0;
	static int pos_total = 0;
	
	public static int topper_dlda(Student s[]) {
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
	
	public static int topper_math(Student s[]) {
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
	
	public static int topper_oopm(Student s[]) {
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
	
	public static int topper_ds(Student s[]) {
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
	
	public static int topper_dst(Student s[]) {
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
	
	public static int topper_eccf(Student s[]) {
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
	
	public static int topper_total(Student s[]) {
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
	
	public static void topper(Student s[]) {
		pos_dlda = topper_dlda(s);
		pos_ds = topper_ds(s);
		pos_dst = topper_dst(s);
		pos_math = topper_math(s);
		pos_oopm = topper_oopm(s);
		pos_eccf = topper_eccf(s);
	}
	
	
	public static void pass_fail(Student s[]) {
		
		for(int i = 0; i < n - 1; i++) {
			if(s[i].total_marks >= 210) {
				countp++;
			}else {
				countf++;
			}

		}
		System.out.println("No. of passed students = "+countp);
		System.out.println("No. of failed students = "+countf);
	}
	
	public static void printtofile(Student s[]) {
		try(PrintWriter out = new PrintWriter("txt.txt");) {
			for(int i = 0; i < n - 1; i++) {
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
	
	public static void main(String args[]) {
		Scanner sc = new Scanner (System.in);
		int n = 0;
		int choice;
		int status = -999; /* Status flag */
		Student s[] = new Student[200];
		Student t = new Student(); /* Temporary variable */
		while(true) {
			System.out.println("1 - Add Student");
			System.out.println("2 - Sort according to total marks");
			System.out.println("3 - Subject toppers & Overall topper");
			System.out.println("4 - Total number of pass & fail students");
			System.out.println("5 - Print to file");
			System.out.println("6 - Exit");
			System.out.println("Enter a choice : ");
			choice = sc.nextInt();
			switch(choice) {
				case 1 :
				take_input(s, sc, n);
				n++;
				break;
				
				case 2 :
				if (n < 2) {
					System.out.println("Add student first.");
					System.out.println();
				}else sort_totalmarks(s,t);

				break;
				
				case 3 :
				topper(s);
				break;
				
				case 4 :
				pass_fail(s);
				break;
				
				case 5 :
				printtofile(s);
				break;
				
				case 6 :
				System.exit(0);
			}
		}
	}
}
