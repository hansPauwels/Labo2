package domain;

public enum StrategyType {
    CAESAR("CaesarStrategy", "domain.CaesarStrategy"),
    RANDOM("RandomCypherStrategy", "domain.RandomCypherStrategy"),
    MIRROR("SpiegelStrategy", "domain.SpiegelStrategy");

    private final String omschrijving;
    private final String klasseNaam;

    StrategyType(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
