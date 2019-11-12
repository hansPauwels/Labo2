package domain;

import java.util.ArrayList;
import java.util.List;

public class CodeerContext {
    private String text;
    private CodeerStrategy strategy;

    public CodeerContext() {
        /*setText(text);
        setStrategy(type);*/
    }

    public void setStrategy(CodeerStrategy type) {
        if(type == null) {
            throw new IllegalArgumentException("Strategy type cannot be empty");
        }

        this.strategy = type;
    }

    public List<String> getStrategyLijst() {
        List<String> result = new ArrayList<>();
        for(StrategyType type : StrategyType.values()) {
            result.add(type.toString());
        }
        return result;
    }

    public void setText(String text) {
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
