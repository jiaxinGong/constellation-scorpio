package com.jiaxin.constellation.scorpio.constant;

import lombok.Getter;

/**
 * @author jiaxin.gong
 * @date 2020/6/13 11:13
 */

public enum FlagEnum {
    /**
     * 0 no 1 yes
     */
    NO(0), YES(1);

    @Getter
    private final int val;

    FlagEnum(int val) {
        this.val = val;
    }
}
