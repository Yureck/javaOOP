package j.oop.hw3;

import java.util.Arrays;

public class Group {

	private String groupName;
	private Student[] students = new Student[10];

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		if (student != null && student.getName() != null) {

			for (int i = 0; i < students.length; i++) {
				if (students[i] == null) {
					student.setGroupName(groupName);
					student.setId(i + 1);
					students[i] = student;
					System.out.println("The student " + (i + 1) + ") " + student.getLastName() + " " + student.getName()
							+ " was added to group \"" + groupName + "\"");
					return;
				}
			}

			throw new GroupOverflowException("The group is full, you can't add a student!");

		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {

		for (Student student : students) {
			if ((student != null) && (student.getLastName().equalsIgnoreCase(lastName))) {
				System.out.println("There is a student with that surname!");
				return student;
			}
		}
		throw new StudentNotFoundException("There is no student in this group with such surname!");
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.length; i++) {
			if ((students[i] != null) && (students[i].getId() == id)) {
				students[i] = null;
				System.out.println("The student with id: " + id + " was deleted!");
				return true;
			}
		}
		System.out.println("The student with id: " + id + " wasn't found!");
		return false;
	}

	public Student[] sortStdLastName() {
		Student[] realStuds = new Student[0];
		for (int i = 0, k = 0; i < students.length; i++) {
			if (students[i] != null) {
				realStuds = Arrays.copyOf(realStuds, k + 1);
				realStuds[k] = students[i];
				k++;
			}
		}
		Arrays.sort(realStuds, (s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
		return realStuds;
	}

	@Override
	public String toString() {
		Student[] tempS = sortStdLastName();
		StringBuilder arr = new StringBuilder(
				"Group \"" + groupName + "\"; " + tempS.length + " students: " + System.lineSeparator());
		for (Student i : tempS) {
			arr.append("Student " + i.getLastName() + " " + i.getName() + "; id= [" + i.getId() + "], [" + i.getGender()
					+ "]" + System.lineSeparator());
		}
		return arr.toString();
	}

}