import java.util.Scanner;

public class LinearSearch_Q2 {
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the list of sentences
        for (int i = 0; i < sentences.length; i++) {
            // Check if current sentence contains the specific word
            if (sentences[i].toLowerCase().contains(word.toLowerCase())) {
                return sentences[i]; // Return the sentence if word is found
            }
        }
        // If no sentence contains the word, return "Not Found"
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of sentences from user
        System.out.print("Enter the number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Initialize array with the specified size
        String[] userSentences = new String[n];

        // Get sentences from user
        System.out.println("Enter " + n + " sentences:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sentence " + (i + 1) + ": ");
            userSentences[i] = scanner.nextLine();
        }


        System.out.print("Enter the word to search for: ");
        String searchWord = scanner.nextLine();

        // Call the method to find sentence with the word
        String result = findSentenceWithWord(userSentences, searchWord);

        System.out.println(result);

    }
}
