package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFileUtils {
	//read the content of a text file
	public static String readText(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		String result = "";
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			result += line + "\n";
		}
		reader.close();
		return result;
	}

	// write the text to the fileName
	public static void writeText(String fileName, String text) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		for (int i = 0; i < text.length(); i++) {
			writer.print(text.charAt(i));
		}
//		writer.println("Dai hoc Nong Lam Tp.HCM");
//		writer.println("Khoa Cong nghe Thong tin");
//		writer.println("Thuc hanh CTDL DH22DT");
		writer.close();
	}
	

	public static void main(String[] args) throws IOException {
//		try {
//			TextFileUtils.readText("./data/Lab1.txt");
//			TextFileUtils.writeText("./data/Lab1.txt", "");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(TextFileUtils.readText("./data/Lab1.txt"));
	}

	

}
