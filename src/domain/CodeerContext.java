package domain;

public class CodeerContext {
    private String text;
    private CodeerStrategy strategy;

    public CodeerContext(CodeerStrategy type, String text) {
        setText(text);
        setStrategy(type);
    }

    public void setStrategy(CodeerStrategy type) {
        if(type == null) {
            throw new IllegalArgumentException("Strategy type cannot be empty");
        }

        this.strategy = type;
    }

    private void setText(String text) {
        if(text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty");
        }

        this.text = text;
    }

    public String encode() {
        return strategy.encodeTxt(this.text);
    }

    public String getText() {
        return text;
    }

    public CodeerStrategy getStrategy() {
        return strategy;
    }

    public String decode() {
        return this.strategy.decodeTxt(this.text);
    }
}
