package study.javaIO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student std=new Student();
		List<Student> stdList= new ArrayList<Student>();
		try {
			stdList = StudentIOOperation.readFile();
		} catch (MyErrorException e) {
			StudentIOOperation.writeFile(stdList);
			System.out.println("New File Created");
		}
		System.out.println(stdList);
		Scanner scn =new Scanner(System.in);
		menu(std,stdList,scn);

	}

	private static void menu(Student std, List<Student> stdList, Scanner scn) {
		while(true) {
			System.out.println("1. Add Student with marks");
			System.out.println("2. Add Student without marks");
			System.out.println("3. Search Student by name");
			System.out.println("4. Remove  Student");
			System.out.println("5. Remove all Student");
			System.out.println("6. Exit without save");
			System.out.println("7. Exit with save");
			
			System.out.println("Enter your choice");
			int key=scn.nextInt();
			if(key == 6) {
				System.out.println("Exited without save");
				break;
			}
			else if(key == 7) {
				StudentIOOperation.writeFile(stdList);
				System.out.println("Exit with save");
				break;
			}
			
			switch (key) {
			case 1:{
				addStudent(std,stdList,scn);
				break;
			}
				
			case 2:{
				addStudent(std,stdList,scn);
				break;
			}
			case 3:{
				System.out.println("Enter name of student");
				searchStudent(scn.next(),stdList);
				break;
			}
			case 4:{
				System.out.println("Enter index of student");
				stdList.remove(scn.nextInt());
				break;
			}
			case 5:{
				stdList.removeAll(stdList);
				System.out.println("Removed All");
			}
			
			
		}
		
	}

}

	private static void searchStudent(String next, List<Student> stdList) {
		Iterator<Student> it=stdList.iterator();
		while(it.hasNext()) {
			Student s =it.next();
			if(s.getName().equals(next)) {System.out.println(s); return;}
		}
		
	}

	private static void addStudent(Student std, List<Student> stdList, Scanner scn) {
		System.out.println("Enter name :");
		String name=scn.next();
		System.out.println("Enter age :");
		int age =scn.nextInt();
		System.out.println("Enter marks,Enter 0 for no marks");
		int []marks=new int[3];
		for (int i = 0; i < marks.length; i++) {
			
			marks[i] =scn.nextInt();
			if(marks[0] == 0) {
				std =new Student(name, age, null);	
				stdList.add(std);
				return;
			}
		}
		std =new Student(name, age, marks);
		stdList.add(std);
		
	}
	
}
