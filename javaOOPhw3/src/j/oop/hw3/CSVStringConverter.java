package j.oop.hw3;

public class CSVStringConverter implements StringConverter {

	public CSVStringConverter() {
		super();
	}

	@Override
	public String toStringRepresentation(Student student) {
		StringBuilder tempS = new StringBuilder();
		if (student != null) {
			if (student.getName() != null && student.getId() != 0) {
				tempS.append(student.getName() + ";" + student.getLastName() + ";"
						+ student.getGender().toString().toLowerCase() + ";" + student.getId() + ";"
						+ student.getGroupName());
			} else if (student.getName() != null) {
				tempS.append(student.getName() + ";" + student.getLastName() + ";"
						+ student.getGender().toString().toLowerCase());
			} else {
				System.out.println("The information about the student isn't complete!");
			}
		}
		return tempS.toString();
	}

	@Override
	public Student fromStringRepresentation(String str) {
		if (str != null && !str.equals("")) {

			String[] s = str.split("[,;]");
			if (!(s.length < 3)) {
				Student st = (s.length == 3) ? new Student(s[0], s[1], Gender.valueOf(s[2].toUpperCase()))
						: new Student(s[0], s[1], Gender.valueOf(s[2].toUpperCase()), Integer.valueOf(s[3]), s[4]);
				return st;
			} else {
				System.out.println("The information about the student isn't complete!");
			}

		}
		return null;
	}

}
