package domain;


public class RandomCypherStrategy implements CodeerStrategy {
    private RandomCypher randomCypher = new RandomCypher();

    @Override
    public String encodeTxt(String text) {
        if(text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Geen geldige text gegeven");
        }

        char[] textArray = text.toCharArray();
        String result = String.valueOf(randomCypher.encypher(textArray));
        return result;
    }

    @Override
    public String decodeTxt(String text) {
        if(text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Geen geldige text gegeven");
        }

        char[] textArray = text.toCharArray();
        String result = String.valueOf(randomCypher.decypher(textArray));

        return result;
    }
}
