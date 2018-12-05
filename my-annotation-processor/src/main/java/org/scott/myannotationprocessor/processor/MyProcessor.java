package org.scott.myannotationprocessor.processor;

import org.scott.myannotationprocessor.annotation.Test;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes(value = "org.scott.myannotationprocessor.annotation.Test")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyProcessor extends AbstractProcessor {

    private Filer filer;

    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.filer = processingEnv.getFiler();
        this.messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        messager.printMessage(Diagnostic.Kind.NOTE, "enter into compiling");
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Test.class);
        for (Element item : elements) {
            messager.printMessage(Diagnostic.Kind.NOTE, "foreach get class name : " + item.getSimpleName());
            try {
                JavaFileObject jfo = filer.createSourceFile("com.scott.java.task.javaStudy.AnnotationTest.testClass", item);
                Writer writer = jfo.openWriter();
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
}
