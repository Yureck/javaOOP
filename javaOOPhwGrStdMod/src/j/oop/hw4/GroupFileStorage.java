package j.oop.hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GroupFileStorage {

	public GroupFileStorage() {
		super();
		// TODO Auto-generated constructor stub
	}

	void saveGroupToCSV(Group gr) throws IOException {

		File file = new File(gr.getGroupName() + ".csv");
		try (BufferedWriter bWr = new BufferedWriter(new FileWriter(file))) {
			for (Student i : gr.getStudents()) {
				if (i != null) {
					bWr.write(new CSVStringConverter().toStringRepresentation(i));
					bWr.newLine();
				}
			}
			System.out.println("The group \"" + gr.getGroupName() + "\" was saved to a file!");
		} catch (IOException e) {
			throw e;
		}

	}

	Group loadGroupFromCSV(File file) throws IOException {

		Group gr = new Group(file.getName().replace(".csv", ""));
		try (BufferedReader bRr = new BufferedReader(new FileReader(file))) {
			String tempS = "";
			
			for (int i = 0;; i++) {
				tempS = bRr.readLine();

				if (tempS == null) {
					break;
				}
				try {
					Student st = new CSVStringConverter().fromStringRepresentation(tempS);
					gr.addStudent(st);
				} catch (GroupOverflowException e) {
					System.out.println(e);
				}

			}

			System.out.println("The group \"" + gr.getGroupName() + "\" was loaded from file!");
			return gr;

		} catch (IOException e) {
			throw e;
		}

	}

	File findFileByGroupName(String groupName, File workFolder) throws IOException {

		if (workFolder.isDirectory()) {
			File[] files = workFolder.listFiles();
			for (File file : files) {
				if (file.isFile() && file.getName().replace(".csv", "").equalsIgnoreCase(groupName)) {
					System.out.println("The file with such a group was found!");
					return file;
				}
			}
		}
		System.out.println("There is no such file in this directory!");
		return null;
	}

}
