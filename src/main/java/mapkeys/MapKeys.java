package mapkeys;

import dagger.MapKey;
import dagger.multibindings.ClassKey;

public class MapKeys {
    @MapKey(unwrapValue = false)
    public @interface ComplexKey {
        Class<?>[] manyClasses();
        Class<?> oneClass();
        ClassKey annotation();
    }

    @MapKey
    @interface EnumKey {
        PackagePrivateEnum value();
    }

    enum PackagePrivateEnum { INACCESSIBLE }

    interface Inaccessible {}
}