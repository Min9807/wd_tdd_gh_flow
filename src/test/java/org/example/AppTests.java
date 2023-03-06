package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTests {

    @Test
    @DisplayName("스캐너에 키보드가 아닌 문자열을 입력으로 설정")
    public void t1(){
        Scanner sc = TestUtil.genScanner("안녕");
        String cmd = sc.nextLine().trim();
//        assertThat(cmd).isEqualTo("안녕");
        assertEquals("안녕", cmd);
    }

    @Test
    @DisplayName("출력을 모니터에 하지 않고 문자열로 얻기")
    public void t2(){
        // System.out에 대한 화면출력 금지 시작
        ByteArrayOutputStream output = TestUtil.setOutToByteArray(); // 화면에 안나오게 함.
        System.out.print("안녕");

        // 그동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString(); // 안녕을 여기서 얻음.
        // System.out. 에 대한 화면출력 금지 끝
        TestUtil.clearSetOutToByteArray(output); // 원상 복귀

        assertThat(rs).isEqualTo("안녕");
    }

//    @Test
//    @DisplayName("등록화면에서 명언과 작가를 입력 받는다.")
//    public void t5(){
//        String rs = AppTestRunner.run
//    }


}
