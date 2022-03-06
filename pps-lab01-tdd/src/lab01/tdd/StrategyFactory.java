package lab01.tdd;

public interface StrategyFactory {

    SelectStrategy createEvenStrategy();

    SelectStrategy createMultipleOfStrategy(int elem);

    SelectStrategy createEqualsStrategy(int elem);

}
