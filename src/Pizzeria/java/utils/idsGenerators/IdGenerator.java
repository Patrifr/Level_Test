package utils.idsGenerators;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    //Busqué como hacerlo en chatgpt para que genere id autoincrementales (no sabía hacerlo)

    private final AtomicInteger counter;

    public IdGenerator(int initialValue) {
        this.counter = new AtomicInteger(initialValue); //Define el valor inicial
    }

    public IdGenerator(){
        this(1); //llama al constructor de arriba con initial value = 1
    }

    public int generateId(){
        return counter.getAndIncrement(); //incrementa el initial value
    }
}
