package com.multi.module.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
public class MemberInfoDto {
    private Long idx;
    private String userName;
    private String userNick;
    private String userPhone;
}
