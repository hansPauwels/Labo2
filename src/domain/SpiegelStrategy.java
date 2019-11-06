package domain;

public class SpiegelStrategy implements CodeerStrategy {
    @Override
    public String encodeTxt(String text) {
        String result = "";

        for(int i = text.length()-1; i >= 0; i--) {
            result = result + text.charAt(i);
        }

        return result;
    }

    @Override
    public String decodeTxt(String text) {
        String result = "";

        for(int i = text.length()-1; i >= 0; i--) {
            result = result + text.charAt(i);
        }

        return result;
    }
}
