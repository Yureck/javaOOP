package j.oop.hw3;

import java.util.Scanner;

public class AddStdFrKeyB {

	private Student st = new Student();

	public AddStdFrKeyB(Student st) {
		super();
		this.st = st;
	}

	public AddStdFrKeyB() {
		super();
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}

	public Student createStd() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the name of the student: ");
		st.setName(scan.nextLine());
		System.out.print("Input the lastname of the student: ");
		st.setLastName(scan.nextLine());
		System.out.print("Input the gender of the student (male/female): ");
		try {
			st.setGender(Gender.valueOf(scan.nextLine().toUpperCase()));
			scan.close();
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("The gender was entered incorrectly!");
		}
		return st;
	}

	public void addStdToGroup(Group group) throws GroupOverflowException {
		group.addStudent(st);
	}

	@Override
	public String toString() {
		return "AddStdFrKeyB [st=" + st + "]";
	}

}
