package com.github.silencesu.behavior3java.constant;

/**
 * 行为树状态
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public enum B3Status {
    SUCCESS(1), FAILURE(2), RUNNING(3), ERROR(4),
    ;

    private int value;

    B3Status(int i) {

        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
