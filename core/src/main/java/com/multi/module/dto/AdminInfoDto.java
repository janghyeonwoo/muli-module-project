package com.multi.module.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
public class AdminInfoDto {
    private String userName;
    private Long idx;

    public AdminInfoDto(String userName, Long idx) {
        this.userName = userName;
        this.idx = idx;
    }
}
