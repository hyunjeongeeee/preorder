package com.preorder.web.product.error;

public enum ErrorCode {
    LOCK_NOT_AVAILABLE("락을 획득할 수 없습니다."),
    LOCK_INTERRUPTED_ERROR("락 획득 시도 중 인터럽트 발생"),
    UNLOCKING_A_LOCK_WHICH_IS_NOT_LOCKED("잠금 해제 시도 중이지만, 잠금이 설정되지 않음");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
