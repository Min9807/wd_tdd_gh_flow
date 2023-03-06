package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTests {
    // 테스트 유틸 테스트 시작
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
    // 테스트유틸 테스트 끝

    // 앱 테스트 시작
    @Test
    @DisplayName("프로그램 시작시 타이틀 출력 그리고 종료")
    public void t3(){
        String rs = AppTestRunner.run("");

        assertThat(rs).contains("== 명언 앱 ==")
                .contains("명령) ")
                .contains("프로그램이 종료되었습니다.")
                .doesNotContain("올바르지 않은 명령입니다.");
    }

    @Test
    @DisplayName("잘못된 명령어 입력에 대한 처리")
    public void t4(){
        String rs = AppTestRunner.run("종료2\n종료");

        assertThat(rs).contains("올바르지 않은 명령입니다.");
    }
    // 앱 테스트 끝

    @Test
    @DisplayName("등록화면에서 명언과 작가를 입력 받고, 명언을 생성한다.")
    public void t5(){
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                """);
        assertThat(rs)
                .contains("명언 : ")
                .contains("작가 : ")
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("명언이 등록될 때 마다 생성되는 명언의 번호가 1씩 증가한다.")
    public void t6(){
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                나의 죽음을 적들에게 알리지 마라.
                이순신
                등록
                왼손은 거들뿐
                강백호
                """);
        assertThat(rs)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .doesNotContain("4번 명언이 등록되었습니다.");
    }
}
