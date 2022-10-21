package smartStore2.src.me.smartstore.project.exception;

import me.smartstore.project.util.ErrorMessage;

public class InputEmptyException extends RuntimeException { // 예외

    public InputEmptyException() {
        super(ErrorMessage.ERR_MSG_INVALID_INPUT_EMPTY);
    }

    public InputEmptyException(String message){
        super(message);
    }

}
