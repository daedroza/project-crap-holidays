import java.io.*;
import java.util.*;
public class Test
{
        
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = 0,i;
		//Get the number of the student
		System.out.println("How many students you want to add?");
		n = sc.nextInt();
		String[] name = new String[n];
        int[] dlda = new int[n];
        int[] ds = new int[n];
        int[] math = new int[n];
        int[] oopm = new int[n];
        int[] eccf = new int[n];
        int[] dst = new int[n];
		//Get name and marks
		for(i = 0; i <= n - 1; i++)
		{
			System.out.println("Enter the name of student : ");
			name[i] = sc.nextLine();
			System.out.println("You are entering the scores of "+name[i]);
			System.out.println("Marks for DLDA : ");
			dlda[i] = sc.nextInt();
			System.out.println("Marks for DS : ");
			ds[i] = sc.nextInt();
			System.out.println("Marks for Math : ");
			math[i] = sc.nextInt();
			System.out.println("Marks for OOPM : ");
			oopm[i] = sc.nextInt();
			System.out.println("Marks for ECCF : ");
			eccf[i] = sc.nextInt();
			System.out.println("Marks for DST : ");
			dst[i] = sc.nextInt();
			System.out.println("You have successfully entered the scores of the student "+name[i]);
		}
	}
}
