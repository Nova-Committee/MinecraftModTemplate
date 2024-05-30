package committee.nova.mods.examplemod.mixin.callbacks;

import committee.nova.mods.examplemod.util.event.events.Event;
import committee.nova.mods.examplemod.util.event.events.EventHelper;

/**
 * ExampleCallback
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/30 下午6:33
 */
public interface ExampleCallback {
    Event<ExampleCallback> EVENT = EventHelper.CreateEvent(ExampleCallback.class,
            (listeners) -> (x) -> {
                for (ExampleCallback listener : listeners) {
                    listener.listen(x);
                }
            }
    );

    void listen(float x);
}