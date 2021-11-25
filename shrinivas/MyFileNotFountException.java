package study.shrinivas;

public class MyFileNotFountException extends Exception {
	public MyFileNotFountException() {
		super("StudentDbFileNotFound");
	}
}
