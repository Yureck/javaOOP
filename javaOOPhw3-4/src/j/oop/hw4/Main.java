package j.oop.hw4;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Student st1 = new Student("Wade", "Cox", Gender.MALE);
		Student st2 = new Student("Philip", "Clark", Gender.MALE);
		Student st3 = new Student("Ronald", "Nelson", Gender.MALE);
		Student st4 = new Student("Jack", "Evans", Gender.MALE);
		Student st5 = new Student("Zarina", "Powell", Gender.FEMALE);
		Student st6 = new Student("John", "Kennedy", Gender.MALE);
		Student st7 = new Student("Regina", "Wood", Gender.FEMALE);
		Student st8 = new Student("Katie", "Cook", Gender.FEMALE);
		Student st9 = new Student("Zane", "Barnes", Gender.MALE);
		Student st10 = new Student("Emelia", "Watson", Gender.FEMALE);
		Student st11 = new Student("Susan", "Gray", Gender.FEMALE);

		Group group = new Group("1455");

		try {
			System.out.println(group);
			group.addStudent(st1);
			group.addStudent(st2);
			group.addStudent(st3);
			group.addStudent(st4);
			group.addStudent(st5);
			group.addStudent(st6);
			group.addStudent(st7);
			group.addStudent(st8);
			group.addStudent(st9);
			group.addStudent(st10);

			System.out.println();
			group.addStudent(st11);

		} catch (GroupOverflowException e) {
			System.out.println(e);
		}

		System.out.println();
		try {
			group.searchStudentByLastName("Watson");
			group.searchStudentByLastName("Shepard"); // don't exist

		} catch (StudentNotFoundException e) {
			System.out.println(e);
		}

		System.out.println();
		group.removeStudentByID(5);
		group.removeStudentByID(7);
		group.removeStudentByID(12); // don't exist

		System.out.println();
		System.out.println(group);

		System.out.println();
		try {
			group.addStudent(st9);
			group.addStudent(st11);
		} catch (GroupOverflowException e) {
			System.out.println(e);
		}

		System.out.println();
		System.out.println(group);
		System.out.println(st5.getGroupName());
		
		
		System.out.println("------------------------");
		
		System.out.println(group.studentsEquals(st5));

		

	}

}