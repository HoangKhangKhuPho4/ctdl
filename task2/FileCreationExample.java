package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreationExample {
	  public static void main(String[] args) {
		  String desFilePath = ""; // Đường dẫn đích cho tệp desFile

	        try {
	            // Tạo một đối tượng FileWriter để ghi vào tệp
	            FileWriter fileWriter = new FileWriter(desFilePath);

	            // Sử dụng BufferedWriter để tối ưu hóa việc ghi dữ liệu
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            // Ghi dữ liệu vào tệp
	            String dataToWrite = "This is the data to be written to desFile1.txt";
	            bufferedWriter.write(dataToWrite);

	            // Đóng BufferedWriter (điều này cũng sẽ đóng FileWriter)
	            bufferedWriter.close();

	            System.out.println("desFile1.txt has been created and data has been written.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
