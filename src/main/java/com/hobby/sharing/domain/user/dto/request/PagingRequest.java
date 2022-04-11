package com.hobby.sharing.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PagingRequest {
    private int pageNo;
    private int size;
}
