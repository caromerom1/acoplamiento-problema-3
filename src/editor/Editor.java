package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Editor {

	public void checkSpelling(String text) {
		List<String> errors = this.check(text);
		if (errors.size() > 0) {
			this.displayErrors(errors);
			return;
		}
		this.displaySuccessMessage();
	}

	public void displayErrors(List<String> errors) {
		for (int i = 0; i < errors.size(); i++) {
			System.out.println("ERROR: " + errors.get(i));
		}
	}

	public void displaySuccessMessage() {
		System.out.println("No errors found!");
	}

	public List<String> check(String text) {
		String[] words = text.split(" ");
		String[] realWords = { "foo", "bar" };

		List<String> errors = new ArrayList<String>();

		boolean found = false;

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < realWords.length; j++) {
				if (words[i].equalsIgnoreCase(realWords[j])) {
					found = true;
					break;
				}
			}
			if (!found) {
				errors.add(words[i]);
			}
			found = false;
		}
		return errors;

	}

	public void runEditor() {
		System.out.println("Running editor...");
		System.out.println("Enter text:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text;
		try {
			text = br.readLine();
			this.checkSpelling(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.runEditor();
	}
}
