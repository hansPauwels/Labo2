package domain;

public enum StrategyType {
    A("CaesarStrategy", "domain.CaesarStrategy"),
    B("RandomCypherStrategy", "domain.RandomCypherStrategy"),
    C("SpiegelStrategy", "domain.SpiegelStrategy");

    private final String omschrijving;
    private final String klasseNaam;

    StrategyType(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
