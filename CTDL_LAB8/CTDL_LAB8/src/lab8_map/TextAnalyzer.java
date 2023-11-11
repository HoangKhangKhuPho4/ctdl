package lab8_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String line = null;
		int position = 1;

		while ((line = reader.readLine()) != null) {

			String[] words = line.split(" ");

			for (String word : words) {

				if (!map.containsKey(word)) {
					map.put(word, new ArrayList<>());
				}

				if (line.endsWith(word)) {
					map.get(word).add(-position);
				} else {
					map.get(word).add(position);
				}

				position++;

			}

		}

		reader.close();

	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {

		if (!map.containsKey(word)) {
			map.put(word, new ArrayList<>());
		}

		map.get(word).add(position);

	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {

		List<String> words = new ArrayList<>(map.keySet());

		Collections.sort(words);

		for (String word : words) {
			System.out.print(word);

			List<Integer> positions = map.get(word);
			for (Integer pos : positions) {
				System.out.print(" " + pos);
			}

			System.out.println();
		}

	}

	// This method will display the content of the text file stored in the map
	public void displayText() {

		// Sắp xếp lại các từ theo thứ tự xuất hiện
		Map<Integer, String> orderedMap = new TreeMap<>();

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			for (Integer pos : entry.getValue()) {
				orderedMap.put(pos, entry.getKey());
			}
		}

		// In ra text dựa trên thứ tự xuất hiện
		for (Integer pos : orderedMap.keySet()) {
			System.out.print(orderedMap.get(pos) + " ");
		}

	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {

		Map<String, Integer> freqMap = new HashMap<>();

		for (String word : map.keySet()) {
			freqMap.put(word, map.get(word).size());
		}

		String mostFreqWord = null;
		int maxCount = 0;

		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > maxCount) {
				mostFreqWord = entry.getKey();
				maxCount = entry.getValue();
			}
		}

		return mostFreqWord;

	}

	public static void main(String[] args) throws IOException {

		TextAnalyzer analyzer = new TextAnalyzer();

		// Test phương thức load
		analyzer.load("data/short.txt");

		// Test phương thức add
		analyzer.add("Hello", 1);
		analyzer.add("World", 2);

		// Test phương thức displayWords
		analyzer.displayWords();

		// Test phương thức displayText
		analyzer.displayText();

		// Test phương thức mostFrequentWord
		String frequentWord = analyzer.mostFrequentWord();
		System.out.println("Most frequent word: " + frequentWord);  

	}

}
