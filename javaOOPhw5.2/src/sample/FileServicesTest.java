package sample;

import java.io.File;
import java.io.IOException;

public class FileServicesTest {

	public static void main(String[] args) {
		
		File folderIn = new File("F:\\temp");

		File folderOut = new File("F:\\temp\\copy");
		folderOut.mkdirs();
		System.out.println("-------------------------");

		File f1;
		File f2;
		if (args.length == 2) {
			f1 = new File(args[0]);
			f2 = new File(args[1]);
		} else {
			f1 = new File("F:\\temp\\smart.png");
			f2 = new File("F:\\temp\\copy\\smacccrt.png");
		}
		
		try {
			FileService.copyFolderByExt(folderIn, folderOut, "docx");
			System.out.println("-------------------------");
			FileService.compareFilesByBytes(f1, f2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
