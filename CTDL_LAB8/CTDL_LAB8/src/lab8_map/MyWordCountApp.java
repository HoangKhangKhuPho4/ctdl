package lab8_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyWordCountApp {
	public static final String fileName = "data/fit.txt";
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// Chia mỗi dòng thành các từ, loại bỏ dấu câu và chuyển thành chữ thường
				String[] words = line.toLowerCase().split("\\W+");
				for (String word : words) {
					if (!word.isEmpty()) {
						map.put(word, map.getOrDefault(word, 0) + 1);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		if (map != null) {
			return map.size();
		} else {
			// Có thể ném ra ngoại lệ hoặc trả về giá trị mặc định
			System.out.println("No data loaded or map is null.");
			return 0;
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() {
		if (map == null || map.isEmpty()) {
			System.out.println("No data to display.");
			return;
		}

		StringBuilder output = new StringBuilder();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			output.append("Word: ").append(entry.getKey()).append(", Count: ").append(entry.getValue()).append("\n");
		}

		System.out.println(output.toString());
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	// In kết quả sử dụng map
	public void printWordCountsAlphabet() {
		if (map == null || map.isEmpty()) {
			System.out.println("No data to display.");
			return;
		}

		// Tạo TreeMap từ HashMap để tự động sắp xếp theo khóa
		Map<String, Integer> sortedMap = new TreeMap<>(map);

		StringBuilder output = new StringBuilder();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			output.append("Word: ").append(entry.getKey()).append(", Count: ").append(entry.getValue()).append("\n");
		}

		System.out.println(output.toString());
	}

	public static void main(String[] args) {

		MyWordCountApp app = new MyWordCountApp();

		// Load data
		long start = System.currentTimeMillis();
		app.loadData();
		long end = System.currentTimeMillis();
		System.out.println("Loaded data in " + (end - start) + " ms");

		// Count unique words
		start = System.currentTimeMillis();
		int uniqueCount = app.countUnique();
		end = System.currentTimeMillis();
		System.out.println("Number of unique words: " + uniqueCount);
		System.out.println("Counted unique words in " + (end - start) + " ms");

		// Print word counts
		start = System.currentTimeMillis();
		app.printWordCounts();
		end = System.currentTimeMillis();
		System.out.println("Printed word counts in " + (end - start) + " ms");

		// Print word counts in alphabetical order
		start = System.currentTimeMillis();
		app.printWordCountsAlphabet();
		end = System.currentTimeMillis();
		System.out.println("Printed alphabetic word counts in " + (end - start) + " ms");

	}

}
