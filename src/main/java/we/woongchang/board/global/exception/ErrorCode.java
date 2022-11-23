package we.woongchang.board.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "사용자가 없어용"),
    ALREADY_EXISTS_USER(422, "이미 존재하는 회원입니다."),
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),

    USER_NOT_LOGIN(403, "로그인 후 이용해주세요");


    private int errorCode;
    private String message;

}
