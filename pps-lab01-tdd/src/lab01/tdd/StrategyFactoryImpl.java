package lab01.tdd;

public class StrategyFactoryImpl implements StrategyFactory{

    @Override
    public SelectStrategy createEvenStrategy() {
        return (x) -> x % 2 == 0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int elem) {
        return (x) -> x % elem == 0;
    }

    @Override
    public SelectStrategy createEqualsStrategy(int elem) {
        return (x) -> x == elem;
    }
}
