package com.kodilla.ecommercee.domain;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class GroupDto {

    private Long id;
    private String name;

    public GroupDto(Long id, String name) {
        this.id= id;
        this.name = name;
    }

}
