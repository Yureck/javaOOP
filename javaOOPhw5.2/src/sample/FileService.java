package sample;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileService {
	
	public static void copyFile(File fileIn, File fileOut) throws IOException {

		try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
			long copyByte = is.transferTo(os);
			System.out.println(copyByte + " bytes were copied");
		}

	}

	public static void copyFolder(File folderIn, File folderOut) throws IOException {

		File[] files = folderIn.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				File fileOut = new File(folderOut, file.getName());
				copyFile(file, fileOut);
			}
		}
	}

	public static void copyFolderByExt(File folderIn, File folderOut, String Extn) throws IOException {

		if (!folderIn.isDirectory()) {
			System.out.println("The path to the input directory isn't correct!");
			return;
		}

		int countF = 0;
		File[] files = folderIn.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(Extn)) {
				File fileOut = new File(folderOut, file.getName());
				copyFile(file, fileOut);
				countF++;
			}
		}
		System.out.println(countF + " files with \"" + Extn + "\" extension were copied.");
	}

	public static boolean compareFilesByBytes(File f1, File f2) throws IOException {

		try (BufferedInputStream in1 = new BufferedInputStream(new FileInputStream(f1));
				BufferedInputStream in2 = new BufferedInputStream(new FileInputStream(f2))) {

			int readByte1 = 0;
			int readByte2 = 0;
			for (int i = 0;; i++) {
				readByte1 = in1.read();
				readByte2 = in2.read();
				// System.out.println(i +" "+ readByte1 +" "+ readByte1);
				if (readByte1 != readByte2) {
					System.out.println(
							"The files \"" + f1.getName() + "\" and \"" + f2.getName() + "\" aren't identical!");
					return false;
				} else if (readByte1 < 0 || readByte2 < 0) {
					break;
				}

			}
			System.out.println("The files \"" + f1.getName() + "\" and \"" + f2.getName() + "\" are identical!");
			return true;
		}
	}
	
}
