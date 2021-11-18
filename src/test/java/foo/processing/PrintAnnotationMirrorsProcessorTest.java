package foo.processing;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import javax.tools.JavaFileObject;
import org.junit.jupiter.api.Test;

class PrintAnnotationMirrorsProcessorTest {

    @Test
    void name() {
        JavaFileObject foo = JavaFileObjects.forSourceLines(
                "test.Foo",
                "package test;",
                "",
                "import jakarta.inject.Inject;",
                "",
                "public class Foo {",
                "",
                "  @UndefinedAnnotation",
                "  @Inject",
                "  void bar() {",
                "  }",
                "}");
        Compilation compilation =
                javac().withProcessors(new PrintAnnotationMirrorsProcessor())
                        .compile(foo);
        assertThat(compilation).hadWarningContaining("bar() @UndefinedAnnotation ERROR");
        assertThat(compilation).hadWarningContaining("bar() @jakarta.inject.Inject DECLARED");
    }
}