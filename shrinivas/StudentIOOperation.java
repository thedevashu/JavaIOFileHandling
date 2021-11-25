package study.shrinivas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentIOOperation {

	//filename studen.db
	public static void writeToFile(List<Student> students) {
		
		try {
			//creating outputstream to write on hdd
			FileOutputStream fwrite =new FileOutputStream("P:\\student\\student.db");
			//creating object output stream to write serialize date from student list 
			ObjectOutputStream owrite = new ObjectOutputStream(fwrite);
			owrite.writeObject(students);
			owrite.flush();
			owrite.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static List<Student> readFile() throws MyFileNotFountException {
		
		try {
			//creating input stream to read from HDD
			FileInputStream fread =new FileInputStream("P:\\student\\student.db");
			//deserilizing file
			ObjectInputStream oin =new ObjectInputStream(fread);
			Object obj =oin.readObject();
			return (List<Student>) obj;
		}
		catch (FileNotFoundException e) {
			
			throw new MyFileNotFountException();
		}
		catch ( IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
