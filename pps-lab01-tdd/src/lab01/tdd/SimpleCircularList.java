package lab01.tdd;

import java.util.ArrayList;
import java.util.Optional;

public class SimpleCircularList implements CircularList{

    private final ArrayList<Integer> list = new ArrayList<>();
    private int index = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> t;

        if(list.isEmpty()){ //Lista vuota.
            t = Optional.empty();
        } else if(this.index == list.size()){ //Indice ha raggiunto l'ultimo elemento.
            this.index = 0;
            t = Optional.of(list.get(this.index));
            this.index = this.index + 1;
        } else { //Indice non ha raggiunto l'ultimo elemento.
            t = Optional.of(list.get(this.index));
            this.index = this.index + 1;
        }

        return t;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> t;

        if(list.isEmpty()){ //Lista vuota.
            t = Optional.empty();
        } else if(this.index == 0){ //Indice ha raggiunto il primo elemento.
            this.index = list.size();
            this.index = this.index - 1;
            t = Optional.of(list.get(this.index));

        } else { //Indice non ha raggiunto l'ultimo elemento.
            this.index = this.index - 1;
            t = Optional.of(list.get(this.index));
        }

        return t;
    }

    @Override
    public void reset() {
        this.index = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> t = Optional.empty();
        int i = 0;

        while(i != this.list.size()){

            if(strategy.apply(next().get())){
                t = previous();
                i = this.list.size();
            } else {
                i = i + 1;
            }

        }

        return t;
    }
}
