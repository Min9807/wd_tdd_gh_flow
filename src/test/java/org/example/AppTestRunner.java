package org.example;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String cmd) {
        cmd.stripIndent().trim();
        cmd += "\n종료";
        // 스캐너를 만든다.
        Scanner sc = TestUtil.genScanner(cmd);
        // 출력을 끈다.
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
