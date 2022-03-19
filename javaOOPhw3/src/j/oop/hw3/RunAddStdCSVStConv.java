package j.oop.hw3;

public class RunAddStdCSVStConv {

	public static void main(String[] args) {
		Group group = new Group("Java");
		AddStdFrKeyB stud = new AddStdFrKeyB();
		Student st = stud.createStd();
		try {
			stud.addStdToGroup(group);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group);

		
		Student st1 = new Student("John", "Kennedy", Gender.MALE);
		try {
			group.addStudent(st1);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		StringConverter csvSt = new CSVStringConverter();
		String csv = csvSt.toStringRepresentation(st1);
		System.out.println(csv);
		st1 = csvSt.fromStringRepresentation(csv);
		System.out.println(st1);

	}

}
