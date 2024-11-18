package editor;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class SpellChecker {

	private Set<String> validWords;

	public SpellChecker(Set<String> validWords) {
		this.validWords = validWords;
	}

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

		List<String> errors = new ArrayList<String>();

		for (String word : words) {
			if (!this.validWords.contains(word)) {
				errors.add(word);
			}
		}
		return errors;
	}
}
