import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle {
    private String word;
    private String guesses;   
    
    public Puzzle() {
        ArrayList word = new ArrayList<String>();
        try {
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNext()) {
            String tempWord = scanner.next().toUpperCase();
            word.add(tempWord);
        }
        scanner.close();
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    guesses = "";
}
public boolean makeGuess(String guess) {
    guess = guess.toUpperCase();
    guesses = guesses + guess;
    return word.contains(guess);
}
public void show() {
    System.out.print("Problem: ");
    for (int i = 0; i <= word.length()-1; i++) {
        if (guesses.contains(""+word.charAt(i))) {
            System.out.print(word.charAt(i) + " ");
        } else {
            System.out.print("_ ");
        }
}
System.out.print("Guesses: ");
for (int x = 0; x <= guesses.length()-1; x++) {
    System.out.print(guesses.charAt(x));
    if (x>= guesses.length()) {
        System.out.print(", ");
    }
}
}
public boolean isUnsolved() {
    for (int i = 0; i <= word.length()-1; i++) {
        if (!guesses.contains(""+word.charAt(i))) {
            return true;
        }
    } 
    return false;
}
public String getWord() {
    return word;
}
public void setWord(String w) {
    word = w;
}
public void setGuesses(String w) {
    guesses = w;
}
public void addGuess(String g) {
    guesses = guesses + g;
}
}

