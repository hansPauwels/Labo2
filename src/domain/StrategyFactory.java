package domain;

public class StrategyFactory {
    public static CodeerStrategy createStrategy(String strategyCode) {
        StrategyType type = StrategyType.valueOf(strategyCode);
        String className = type.getKlasseNaam();

        CodeerStrategy strategy = null;
        try {
            Class dbClass = Class.forName(className);
            Object dbObject = dbClass.newInstance();
            strategy = (CodeerStrategy) dbObject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return strategy;
    }
}
