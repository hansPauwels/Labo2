package domain;

public class CaesarStrategy implements CodeerStrategy {
    private int offset = 3;

    @Override
    public String encodeTxt(String text) {
        String encodedText = "";

        if(text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty");
        }

        for(int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);
            if(letter >= 'a' && letter <= 'z') {
                letter = (char) (letter + offset);
                if(letter > 'z') {
                    letter = (char) (letter+'a'-'z'-1);
                }
                encodedText = encodedText + letter;
            }
        }
        return encodedText;
    }

    @Override
    public String decodeTxt(String text) {
        String decodedText = "";

        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty");
        }

        for (int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                letter = (char) (letter - offset);
                if(letter < 'a') {
                    letter = (char) (letter-'a'+'z'+1);
                }
                decodedText = decodedText + letter;
            }



        }
        return decodedText;
    }
}
