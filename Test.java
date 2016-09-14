import java.io.*;
import java.util.*;
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,y; //Used somewhere in for-loops
		System.out.println("Number of students : ");
		int n;
		n = sc.nextInt();
		Student[] s = new Student[n];
		Student t = new Student();
		for(int i = 0; i <= n - 1; i++) {
			s[i] = new Student();
		}
		//Enter stuff
		for(int i = 0; i <= n - 1; i++) {
			System.out.println("Enter the name of student : ");
			s[i].name = sc.next();
			System.out.println("You are entering the scores of "+s[i].name);
			System.out.println("Marks for DLDA : ");
			s[i].dlda = sc.nextInt();
			System.out.println("Marks for DS : ");
			s[i].ds = sc.nextInt();
			System.out.println("Marks for Math : ");
			s[i].math = sc.nextInt();
			System.out.println("Marks for OOPM : ");
			s[i].oopm = sc.nextInt();
			System.out.println("Marks for ECCF : ");
			s[i].eccf = sc.nextInt();
			System.out.println("Marks for DST : ");
			s[i].dst = sc.nextInt();
			System.out.println("You have successfully entered the scores of the student "+s[i].name);
			System.out.println("\n");
		}
		System.out.println("\n");
		for(int i = 0; i <= n - 1; i++) {
			s[i].total_marks = s[i].dlda + s[i].ds + s[i].math + s[i].oopm + s[i].eccf + s[i].dst;
			System.out.println("Total marks for student"+s[i].name+" is "+s[i].total_marks);
		}
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
			System.out.println("Name : "+s[i].name+" Total Marks : "+s[i].total_marks);
		}
		//Subject Topper after Sorting
		int topper_dlda = s[0].dlda;
		int pos_dlda;
		int topper_ds = s[0].ds;
		int pos_ds;
		int topper_math = s[0].math;
		int pos_math;
		int topper_oopm = s[0].oopm;
		int pos_oopm;
		int topper_eccf = s[0].eccf;
		int pos_eccf;
		int topper_dst = s[0].dst;
		int pos_dst;
		int topper_total = s[0].total_marks;
		int pos_total;
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
	}
}