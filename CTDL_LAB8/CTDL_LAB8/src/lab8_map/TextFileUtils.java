package lab8_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TextFileUtils {
	// read the content of a text file
	public static void readText(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				System.out.println(tokens.nextToken());
			}
		}
		reader.close();
	}

	public static void main(String[] args) {

		try {
			String fileName = "data/fit.txt"; // khai báo đường dẫn file cụ thể

			readText(fileName); // gọi phương thức readText với đường dẫn file

		} catch (IOException e) {
			e.printStackTrace(); // bắt và in ra exception nếu có lỗi đọc file
		}
	}
}
