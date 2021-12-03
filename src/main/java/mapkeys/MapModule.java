package mapkeys;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.Map;

@Module
public interface MapModule {
    @Provides @IntoMap @ClassKey(MapKeys.Inaccessible.class)
    static int classKey() { return 1; }

    @Provides @IntoMap @MapKeys.EnumKey(MapKeys.PackagePrivateEnum.INACCESSIBLE)
    static int enumKey() { return 1; }

    @Binds Object bindInaccessibleEnumMapToAccessibleTypeForComponent(
            Map<MapKeys.PackagePrivateEnum, Integer> map);

    @Provides @IntoMap
    @MapKeys.ComplexKey(
            manyClasses = {java.lang.Object.class, java.lang.String.class},
            oneClass = MapKeys.Inaccessible.class,
            annotation = @ClassKey(java.lang.Object.class)
    )
    static int complexKeyWithInaccessibleValue() { return 1; }

    @Provides @IntoMap
    @MapKeys.ComplexKey(
            manyClasses = {MapKeys.Inaccessible.class, java.lang.String.class},
            oneClass = java.lang.String.class,
            annotation = @ClassKey(java.lang.Object.class)
    )
    static int complexKeyWithInaccessibleArrayValue() { return 1; }

    @Provides @IntoMap
    @MapKeys.ComplexKey(
            manyClasses = {java.lang.String.class},
            oneClass = java.lang.String.class,
            annotation = @ClassKey(MapKeys.Inaccessible.class)
    )
    static int complexKeyWithInaccessibleAnnotationValue() { return 1; }
}