package lab7.set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
    public static void main(String[] args) {
        readFromFile("fit.txt");
        readFromFile("hamlet.txt");
    }

    private static void readFromFile(String filePath) {
        // Sử dụng try-with-resources để tự động đóng Scanner
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                // Đọc từng dòng từ file
                String line = scanner.nextLine();
                // Xử lý dữ liệu đọc được
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // In ra thông báo lỗi nếu file không được tìm thấy
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }
}
