package j.oop.hw4;

import java.io.File;
import java.io.IOException;

public class RunGroupStorage {

	public static void main(String[] args) {
		System.out.println("------------------------------");
		Group group = new Group("Java1");

		Student st1 = new Student("Wade", "Cox", Gender.MALE);
		Student st2 = new Student("Philip", "Clark", Gender.MALE);
		Student st3 = new Student("Ronald", "Nelson", Gender.MALE);
		Student st4 = new Student("Jack", "Evans", Gender.MALE);
		Student st5 = new Student("Zarina", "Powell", Gender.FEMALE);
		Student st6 = new Student("John", "Kennedy", Gender.MALE);

		try {
			System.out.println(group);
			group.addStudent(st1);
			group.addStudent(st2);
			group.addStudent(st3);
			group.addStudent(st4);
			group.addStudent(st5);
			group.addStudent(st6);
			System.out.println();

		} catch (GroupOverflowException e) {
			System.out.println(e);
		}
		System.out.println("------------------------------");
		GroupFileStorage grStorage = new GroupFileStorage();
		try {

			//grStorage.saveGroupToCSV(group);
			System.out.println("------------------------------");

			File file = grStorage.findFileByGroupName("Java1", new File("."));
			System.out.println("------------------------------");

			grStorage.loadGroupFromCSV(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
