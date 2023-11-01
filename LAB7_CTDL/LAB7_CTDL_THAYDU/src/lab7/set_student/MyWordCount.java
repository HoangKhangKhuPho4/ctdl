package lab7.set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MyWordCount {
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		Set<String> uniqueWords = new HashSet<>(words);
		List<WordCount> result = new ArrayList<>();
		for (String word : uniqueWords) {
			int count = 0;
			for (String w : words) {
				if (w.equals(word)) {
					count++;
				}
			}
			result.add(new WordCount(word, count));
		}
		return result;
	}

	// Returns the words that their appearance are 1, do not consider duplicated
	// words
	public Set<String> getUniqueWords() {
		Set<String> uniqueWords = new HashSet<>();
		Set<String> repeatedWords = new HashSet<>();
		for (String word : words) {
			if (!repeatedWords.contains(word)) {
				if (!uniqueWords.add(word)) {
					repeatedWords.add(word);
					uniqueWords.remove(word);
				}
			}
		}
		return uniqueWords;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
        return new HashSet<>(words);
    }

    private static class WordCount implements Comparable<WordCount> {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount other) {
            return this.word.compareTo(other.word);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof WordCount)) {
                return false;
            }
            WordCount other = (WordCount) obj;
            return this.word.equals(other.word);
        }

        @Override
        public int hashCode() {
            return this.word.hashCode();
        }
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public Set<WordCount> printWordCounts() {
        Set<String> uniqueWords = new HashSet<>(words);
        Set<WordCount> result = new HashSet<>();
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (w.equals(word)) {
                    count++;
                }
            }
            result.add(new WordCount(word, count));
        }
        List<WordCount> sortedResult = new ArrayList<>(result);
        sortedResult.sort((a, b) -> a.word.compareTo(b.word));
        return new LinkedHashSet<>(sortedResult);
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according descending order of occurrences
    // Example: Bug - 10, An - 3, Nam - 2.
    public Set<WordCount> exportWordCountsByOccurence() {
        Set<String> uniqueWords = new HashSet<>(words);
        Set<WordCount> result = new HashSet<>();
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (w.equals(word)) {
                    count++;
                }
            }
            result.add(new WordCount(word, count));
        }
        List<WordCount> sortedResult = new ArrayList<>(result);
        sortedResult.sort((a, b) -> b.count - a.count);
        return new LinkedHashSet<>(sortedResult);
    }

    // delete words beginning with the given pattern (i.e., delete words begin with
    // 'A' letter)
    public Set<String> filterWords(String pattern) {
    	Set<String> filteredWords = new HashSet<>();
    	for (String word : words) {
    		if (!word.startsWith(pattern)) {
    			filteredWords.add(word);
    		}
    	}
    	return filteredWords;
    }
}
