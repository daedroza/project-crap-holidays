import java.io.*;
import java.util.*;
class MarksOutOfRangeException extends Exception {
	public MarksOutOfRangeException(String name) {
		super(name);
	}
}
class Name {
	public String name;
}
class Marks extends Name {
	public int dlda, ds, math, oopm, eccf, dst;
}

class Student extends Marks {
	public int total_marks;
}
public class Test {
	public static int super_nextInt(Scanner sc) {
		int temp = 0;
		while(true) {
			try { 
				temp = sc.nextInt();
				if(temp >= 0 && temp <= 100) {
					break;
				}else throw new MarksOutOfRangeException("MarksOutOfRangeException");
			}catch(MarksOutOfRangeException e) {
				System.out.println("***MarksOutOfRangeException occurred***");
				System.out.println("Enter the marks again : ");
			}catch(InputMismatchException e) {
				System.out.println("***NotMarksExpection occurred***");
				System.out.println("Enter the marks again : ");
				/* If the user inputs 'Character/String' in place of integer, the character placed
				inside the command prompt tries to fit into next 'sc.nextInt();' thus creating an infinite loop
				since we are only inputting nextInt() and not next(). To stop the character being assigned to next
				sc.nextInt(); we use a String garbage */
				String garbage = sc.next();
			}
		}
		return temp;
	}
	public static int input_stuff(int n, Student s[], Scanner sc) {
		for(int i = 0; i <= n - 1; i++) {
			System.out.println("Enter the name of student : ");
			s[i].name = sc.next();
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
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,y; //Used somewhere in for-loops
		int countp = 0, countf = 0;
		int status = -150; //Status Flag;
		System.out.println("Number of students : ");
		int n;
		n = sc.nextInt();
		Student[] s = new Student[n];
		Student t = new Student();
		for(int i = 0; i <= n - 1; i++) {
			s[i] = new Student();
		}
		while(true) {
			status = -1;
			status = input_stuff(n, s, sc);
			if(status == 0) {
				break;
			}
		}
		//Calculate Total Marks
		for(int i = 0; i <= n - 1; i++) {
			s[i].total_marks = s[i].dlda + s[i].ds + s[i].math + s[i].oopm + s[i].eccf + s[i].dst;
			System.out.println("Total marks for "+s[i].name+" is "+s[i].total_marks);
		}
		System.out.println("\n");
		//Sort the objects according to total_marks
		for(x = 0;x <= n - 1; x++) {
			for(y = 0;y < n - 1 ; y++) {
				if(s[y].total_marks < s[y+1].total_marks) {
					t=s[y];
					s[y]=s[y+1];
					s[y+1]=t;
				}
			}
		}
		System.out.println("The list sorted according to Total Marks : ");
		for(int i = 0; i < n; i++) {
			System.out.println("Name : "+s[i].name+", Total Marks : "+s[i].total_marks);
		}
		System.out.println("\n");
		//Subject Topper (Sorted List according to total_marks)
		int topper_dlda = s[0].dlda;
		int pos_dlda = 0;
		int topper_ds = s[0].ds;
		int pos_ds = 0;
		int topper_math = s[0].math;
		int pos_math = 0;
		int topper_oopm = s[0].oopm;
		int pos_oopm = 0;
		int topper_eccf = s[0].eccf;
		int pos_eccf = 0;
		int topper_dst = s[0].dst;
		int pos_dst = 0;
		int topper_total = s[0].total_marks;
		int pos_total = 0;
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
		//Print Subject Toppers(NERDS) && SCHOLAR PPL
		System.out.println("DLDA Topper : "+s[pos_dlda].name+" and his/her score : "+s[pos_dlda].dlda);
		System.out.println("DS Topper : "+s[pos_ds].name+" and his/her score : "+s[pos_ds].ds);
		System.out.println("Math Topper : "+s[pos_math].name+" and his/her score : "+s[pos_math].math);
		System.out.println("OOPM Topper : "+s[pos_oopm].name+" and his/her score : "+s[pos_oopm].oopm);
		System.out.println("ECCF Topper : "+s[pos_eccf].name+" and his/her score : "+s[pos_eccf].eccf);
		System.out.println("DST Topper : "+s[pos_dst].name+" and his/her score : "+s[pos_dst].dst);
		System.out.println("Overall Topper : "+s[pos_total].name+" and his/her score : "+s[pos_total].total_marks);
		System.out.println("\n");
		//Passed or failed <- DESTROYS MANY PPLS LIFE
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
}