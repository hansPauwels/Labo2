package service;

import domain.CodeerContext;
import domain.CodeerStrategy;
import domain.StrategyFactory;

import java.util.List;

public class Labo2Service {
    private CodeerContext codeerContext;

    public Labo2Service() {
        codeerContext = new CodeerContext();
    }

    public CodeerContext getCodeerContext() {
        return this.codeerContext;
    }

    public CodeerStrategy createStrategy(String type) {
        if(type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Het gegeven type mag niet leeg zijn");
        }

        return StrategyFactory.createStrategy(type);
    }

    public void setStrategy(CodeerStrategy strategy) {
        this.codeerContext.setStrategy(strategy);
    }

    public CodeerStrategy getStrategy() {
        return this.codeerContext.getStrategy();
    }

    public List<String> getStrategyList() {
        return this.codeerContext.getStrategyLijst();
    }

    public void setText(String text) {
        if(text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Tekst mag niet leeg zijn");
        }

        this.codeerContext.setText(text);
    }

    public String encode()  {
        return this.codeerContext.encode();
    }

    public String decode() {
        return this.codeerContext.decode();
    }
}
