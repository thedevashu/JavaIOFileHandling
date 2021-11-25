package study.javaIO;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable{

	private String name;
	private int age;
	private int[] marks;
	
	public Student() {
		name=null;
		age=0;
		marks=new int[3];
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public void setName(String name) {
		this.name =name;
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", marks=" + Arrays.toString(marks) + "]\n";
	}

	public Student(String name, int age, int[] marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
}
