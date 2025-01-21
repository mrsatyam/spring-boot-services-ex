package com.axisbank.limit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigTypes {
    CHANNEL, MESSAGE, LIMIT, REDIS_UPDATE,REDIS_FETCH,ALLOWED_SCHEME_TYPES,CONSTITUTION_CODE,ACCOUNT_CONSTITUTION_CODE;
}
