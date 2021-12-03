[dagger]() generates invalid code

See [MapBindingComponentProcessorTest.mapBindingsWithInaccessibleKeys](https://github.com/google/dagger/blob/master/javatests/dagger/internal/codegen/MapBindingComponentProcessorTest.java)


Reproduce:

1. run `./gradlew clean classes` to get a compile error

Output:

```
/workspace/print-annotation-mirrors/build/generated/sources/annotationProcessor/java/main/mapkeys/MapKeys_ComplexKeyCreator.java:24: error: cannot find symbol
    return new AutoAnnotation_MapKeys_ComplexKeyCreator_createComplexKey(manyClasses, oneClass, annotation);
               ^
  symbol:   class AutoAnnotation_MapKeys_ComplexKeyCreator_createComplexKey
  location: class MapKeys_ComplexKeyCreator
```
