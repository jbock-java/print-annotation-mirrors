package test;

import dagger.Component;
import java.util.Map;
import mapkeys.MapKeys;
import mapkeys.MapModule;

import javax.inject.Provider;

@Component(modules = MapModule.class)
interface TestComponent {
    Map<Class<?>, Integer> classKey();
    Provider<Map<Class<?>, Integer>> classKeyProvider();

    Object inaccessibleEnum();
    Provider<Object> inaccessibleEnumProvider();

    Map<MapKeys.ComplexKey, Integer> complexKey();
    Provider<Map<MapKeys.ComplexKey, Integer>> complexKeyProvider();
}