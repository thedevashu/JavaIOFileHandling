package study.javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentIOOperation {
	public static void writeFile(List<Student> students) {
		
		
		try {
			//Makin file Output stream to write on HDD
			FileOutputStream fwrite =new FileOutputStream("P:\\student\\student.db");
			
			//save input list in serialize form
			ObjectOutputStream oWrite =new ObjectOutputStream(fwrite);
			
			oWrite.writeObject(students);
			
			oWrite.flush();
			oWrite.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}//writeFile end
	
	public static List<Student> readFile() throws MyErrorException{
		FileInputStream fread=null;
		ObjectInputStream oin=null;
		try {
			//making input stream to read file
			fread =new FileInputStream("P:\\student\\student.db");
			//deserialize to make objct of file
			oin =new ObjectInputStream(fread);
			
			List<Student> stdArr =(List<Student>)oin.readObject();
			return stdArr;
		}
		catch (FileNotFoundException e) {
			throw new MyErrorException();
		}
		catch ( IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
