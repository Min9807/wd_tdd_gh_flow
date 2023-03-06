package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


//    @Test
//    @DisplayName("등록화면에서 명언과 작가를 입력 받는다.")
//    public void t5(){
//        String rs = AppTestRunner.run
//    }


}
