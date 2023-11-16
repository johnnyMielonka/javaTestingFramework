package com.automation.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum TestContext {
    TEMP("");

    @Getter
    @Setter
    private String value;
}
