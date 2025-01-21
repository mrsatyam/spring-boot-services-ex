package com.axisbank.limit.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public enum AxisMessageStatusCodes {

    // ################ SUCCESS CODES #####################
    S221("Limit Enhancement validate successfully"),
    S000("Response successful"),

    // ################ ERROR CODES #####################
    E001("Check Below response limit enhance validation failed"),
    E500("Server error"),
    E212("Account-MS service connection error"),
    E213("Customer accounts Not found"),
    E100("Invalid encryption key");

    private String message;

    public String getMessage() {
        return this.message;
    }

}
