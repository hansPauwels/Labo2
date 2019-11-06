package domain;

public interface CodeerStrategy {
    String encodeTxt(String text);
    String decodeTxt(String text);
}
