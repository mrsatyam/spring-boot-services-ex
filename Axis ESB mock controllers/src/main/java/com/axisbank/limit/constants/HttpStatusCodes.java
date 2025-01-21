package com.axisbank.limit.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public enum HttpStatusCodes {
    OK(200, "OK"), NO_CONTENT(204, "No Content"), BAD_REQUEST(400, "Bad Request"), UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"), NOT_FOUND(404, "Request object not found"), INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    int value;
    String statusPhrase;

    public static HttpStatusCodes value(int code) {
        return HttpStatusCodes.value(code);
    }

}
