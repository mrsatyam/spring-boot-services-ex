package com.axisbank.limit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Statuses {
    A("Active"), I("Inactive");

    private final String label;
}