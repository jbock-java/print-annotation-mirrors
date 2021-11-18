package foo.processing;

import static javax.tools.Diagnostic.Kind.WARNING;

import jakarta.inject.Inject;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class PrintAnnotationMirrorsProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Inject.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Inject.class);
        for (Element element : elements) {
            for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
                String message = String.format("%s %s %s",
                        element, mirror, mirror.getAnnotationType().getKind());
                messager.printMessage(WARNING, message);
            }
        }
        return false;
    }
}
