import java.io.*;
public class Test
{
 private String name;
 private int s_dldla, s_ds, s_math, s_oopm, s_eccf, s_dst, total_marks;
 public Name(String name, int s_dlda, int s_ds, int s_math, int s_oopm, int s_eccf, int s_dst, int total_marks)
 {
 this.name = name;
 this.s_ds = s_ds;
 this.s_dlda = s_dlda;
 this.s_math = s_math;
 this.s_oopm = s_dst;
 this.s_eccf = s_eccf;
 }
 
 public String getName()
 {
 return name;
 }
 
 public void setName(String name)
 {
  this.name = name;
 }

 private static ArrayList<Name> loadDataFromFile() throws IOException 
 {
 ArrayList<Name> list = new ArrayList<Name>();
 BufferedReader br = null;
 string sCurrentLine;
 br = new BufferedReader(new FileReader("C:\\txt.txt");
 while ((sCurrentLine = br.readLine()) != null
 {
 String[] splittedLine = s.CurrentLine.split(",");
 Name name = new Name(splittedLine[0], Integer.parseInt(splittedLine[1], Integer.parseInt(splittedLine[2], Integer.parseInt(splittedLine[3], Integer.parseInt(splittedLine[4], Integer.parseInt(splittedLine[5], Integer.parseInt(splittedLine[6], Integer.parseInt(splittedLine[7];
 }
 br.close();
 return list;
}

public static void main(String[] args) throws IOException
{
 ArrayList<Name> list = loadDataFromFile();
 // int input = Integer.parseInt(args[0]);
 Iterator<Name> it = list.iterator();
 while(it.hasNext())
 {
 Name currentName = it.next();
 if(currentName.get}