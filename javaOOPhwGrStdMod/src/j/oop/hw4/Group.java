package j.oop.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Group {

	private String groupName;
	private List<Student> students = new ArrayList<>(10);


	public Group(String groupName, List<Student> students) {
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	public boolean studentsEquals(Student student) {
		return students.contains(student);
    }
	
	public void addStudent(Student student) throws GroupOverflowException {

		if (student != null && student.getName() != null) {
			
			if (students.size() < 10 && !studentsEquals(student)) {
				
				student.setGroupName(groupName);
				student.setId(students.size() + 1);
				students.add(student);
				System.out.println("The student " + student.getId() + ") " + student.getLastName() + " "
						+ student.getName() + " was added to group \"" + groupName + "\"");
				
			} else {
				throw new GroupOverflowException("The group is full, you can't add a student or "
						+ "such student has been added already!!");
			}
		} else {
			System.out.println("The information about student isn't complete!");
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {

		for (Student student : students) {
			if (student.getLastName().equalsIgnoreCase(lastName)) {
				System.out.println("There is a student with that surname!");
				return student;
			}
		}
		throw new StudentNotFoundException("There is no student in this group with such surname!");
	}

	public boolean removeStudentByID(int id) {

		if (students.removeIf(student -> student.getId() == id)) {
			System.out.println("The student with id: " + id + " was deleted!");
			return true;
		} else {
			System.out.println("The student with id: " + id + " wasn't found!");
			return false;
		}
	}

	public List<Student> sortStdLastName() {
		students.sort((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
		return students;
	}

	@Override
	public String toString() {
		List<Student> tempS = sortStdLastName();
		StringBuilder arr = new StringBuilder(
				"Group \"" + groupName + "\"; " + tempS.size() + " students: " + System.lineSeparator());
		for (Student i : tempS) {
			arr.append("Student " + i.getLastName() + " " + i.getName() + "; id= [" + i.getId() + "], [" + i.getGender()
					+ "]" + System.lineSeparator());
		}
		return arr.toString();
	}

}