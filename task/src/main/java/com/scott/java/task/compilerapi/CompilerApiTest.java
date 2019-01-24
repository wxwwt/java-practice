package com.scott.java.task.compilerapi;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.FileOutputStream;

/**
 * @author scott
 * @date 2018/12/17 19:45
 */


public class CompilerApiTest {

    public static void main(String[] args) throws Exception {
        String fullQuanlifiedFileName = "compile" + java.io.File.separator +
                "Demo.java";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        FileOutputStream err = new FileOutputStream("err.txt");

        int compilationResult = compiler.run(null, null, err,"-verbose", fullQuanlifiedFileName);

        if (compilationResult == 0) {
            System.out.println("Done");
        } else {
            System.out.println("Fail");
        }
    }
}

