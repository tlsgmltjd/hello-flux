package com.example.helloflux.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Table("tb_member")
public class Member {
    @Id
    private Long id;
    private String name;

    public Member(String name) {
        this.name = name;
    }
}
