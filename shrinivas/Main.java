package study.shrinivas;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Student std = null ;
		Scanner scn =new Scanner(System.in);
		
		List<Student> stuList =new ArrayList<>();
		try {
			stuList =StudentIOOperation.readFile();
			System.out.println(stuList);
		} catch (MyFileNotFountException e) {
			//if file is not present making empty file
			
			StudentIOOperation.writeToFile(stuList);
		}
		System.out.println("!!Welcome ");
		int key=0;
		menu(std,key,scn,stuList);
		
	
		
		
	}

	private static void menu(Student std, int key, Scanner scn, List<Student> stuList) {
		while(true) {
			System.out.println("1. Add Student with marks");
			System.out.println("2. Add Student without marks");
			System.out.println("3. Search Student by name");
			System.out.println("4. Remove  Student");
			System.out.println("5. Remove all Student");
			System.out.println("6. Exit without save");
			System.out.println("7. Exit with save");
			key =scn.nextInt();
			
			if(key == 6) {
				System.out.println("Exit without Save");
				break;
			}
			if(key == 7) {
				StudentIOOperation.writeToFile(stuList);
				System.out.println("Exited with save");
				break;
			}
			switch (key) {
			case 1:{
				scn.next();
				System.out.println("Enter student name");
				
				String str =scn.nextLine();
				System.out.println("Enter student age");
				int age=scn.nextInt();
				System.out.println("Enter 4 Subject marks");
				int []marks =new int[4];
				for (int i = 0; i < marks.length; i++) {
					marks[i] =scn.nextInt();
				}
				//populate student;
				std =new Student(str, age, marks);
				stuList.add(std);
				break;
			}
			case 2:{
				System.out.println("Enter student name");
				String str =scn.nextLine();
				System.out.println("Enter student age");
				int age=scn.nextInt();
				std =new Student(str, age, null);
				stuList.add(std);
				break;
			}
			case 3:{
				System.out.println("Enter student name to be searched");
				String str =scn.nextLine();
				//taking iterator
				Iterator<Student> it =stuList.iterator();
				
				while(it.hasNext()) {
					Student s =it.next();
					if(s.getName().equals(str)) 
						System.out.println(s);
						break;		
				}
			}
			
			case 4:{
				System.out.println("Enter index to remove");
				int index =scn.nextInt();
				stuList.remove(index);
				break;
			}
			case 5:{
				stuList.removeAll(stuList);
				System.out.println("Removed all");
			}
			
			default:
				break;
			}
		}
		
	}

}
