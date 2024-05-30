package committee.nova.mods.examplemod.util.event.events;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

public class Event<T> {
    private final Class<? super T> type;
    private final Function<T[], T> invokerFactory;
    private final T dummyInvoker;
    private T[] handlers;
    private T invoker;

    public Event(Class<? super T> type, T dummyInvoker, Function<T[], T> invokerFactory) {
        this.type = type;
        this.dummyInvoker = dummyInvoker;
        this.invokerFactory = invokerFactory;

        Update();
    }

    public void Register(T listener) {
        if (listener == null) {
            throw new NullPointerException("Tried to register a null listener!");
        }

        if (handlers == null) {
            handlers = (T[]) Array.newInstance(type, 1);
            handlers[0] = listener;
        } else {
            handlers = Arrays.copyOf(handlers, handlers.length + 1);
            handlers[handlers.length - 1] = listener;
        }

        Update();
    }

    public void Update() {
        if (handlers == null) {
            if (dummyInvoker != null) {
                invoker = dummyInvoker;
            } else {
                invoker = invokerFactory.apply((T[]) Array.newInstance(type, 0));
            }
        } else if (handlers.length == 1) {
            invoker = handlers[0];
        } else {
            invoker = invokerFactory.apply(handlers);
        }
    }

    public final T Invoker() {
        return invoker;
    }
}