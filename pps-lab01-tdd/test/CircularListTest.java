import lab01.tdd.SimpleCircularList;
import lab01.tdd.StrategyFactory;
import lab01.tdd.StrategyFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private SimpleCircularList list;
    private StrategyFactory strategyFactory;

    @BeforeEach
    void beforeEach(){
        list = new SimpleCircularList();
        strategyFactory = new StrategyFactoryImpl();
    }

    @Test
    void testIsEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize(){
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(3, list.size());
    }

    @Test
    void testAddNotThrowException(){
        assertDoesNotThrow(() -> list.add(5));
    }

    @Test
    void testAddNewElement(){
        int size = list.size();
        list.add(4);
        assertEquals(1, list.size());
    }

    @Test
    void testNextElement(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.next();
        list.next();
        assertEquals(Optional.of(3), list.next());
    }

    @Test
    void textPreviousElement(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.previous();
        list.previous();
        assertEquals(Optional.of(2), list.previous());
    }

    @Test
    void testReset(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.next();
        list.next();
        list.next();
        list.reset();
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    void testCreateEvenStrategy(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.next();
        list.next();

        assertEquals(Optional.of(2), list.next(strategyFactory.createEvenStrategy()));
    }

    @Test
    void testCreateMultipleOfStrategy(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.next();
        list.next();

        assertEquals(Optional.of(2), list.next(strategyFactory.createMultipleOfStrategy(2)));
    }

    @Test
    void testCreateEqualsStrategy(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.next();
        list.next();

        assertEquals(Optional.of(2), list.next(strategyFactory.createEqualsStrategy(2)));
    }

}
