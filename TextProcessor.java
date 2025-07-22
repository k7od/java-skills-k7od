        public class TextProcessor {

            public static int countWords(String sentence) {
                if (sentence == null || sentence.trim().isEmpty()) {
                    return 0;
                }

                String[] words = sentence.trim().split("\\s+");
                return words.length;
            }

            public static String replaceWord(String text, String oldWord, String newWord) {
                if (text == null) {
                    return "";
                }

                return text.replace(oldWord, newWord);
            }

            public static void main(String[] args) {
                String input = "Java is powerful";

                int wordCount = countWords(input);
                System.out.println("Main sentence: " + input);
                System.out.println("Word Count: " + wordCount);

                String replacedText = replaceWord(input, "Java", "Programming");
                System.out.println("After Replace: " + replacedText);
            }
        }
