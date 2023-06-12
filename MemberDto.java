package com.kh.finalPjAm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@Setter
@ToString
@ConstructorBinding

public class MemberDto {
    private String usetId;
    private String pwd;
    private String name;
    private String email;
}
