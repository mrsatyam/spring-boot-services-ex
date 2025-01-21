package com.axisbank.limit.dto;

import java.util.Collection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class CustomPaginator {
	
    Collection<?> content;

    boolean last;

    Integer totalPages;

    Integer totalElements;

    Integer numberOfElements;

    Boolean first;

    Integer page;

    Integer pageSize;
}
