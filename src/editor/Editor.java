package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Editor {

	public void runEditor() {
		System.out.println("Running editor...");
		System.out.println("Enter text:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text;
		SpellChecker spellChecker = new SpellChecker(Set.of("foo", "bar"));

		try {
			text = br.readLine();
			spellChecker.checkSpelling(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.runEditor();
	}
}
