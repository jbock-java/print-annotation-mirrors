https://bugs.openjdk.java.net/browse/JDK-8268575


Reproduce:

1. run `./gradlew clean test` to verify it works with java 11
2. modify `build.gradle`: set toolchain `languageVersion` to `12` or higher
3. run `./gradlew clean test` again to verify the same test fails in higher versions
