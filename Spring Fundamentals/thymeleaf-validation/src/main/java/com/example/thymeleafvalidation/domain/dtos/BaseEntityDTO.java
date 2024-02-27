package com.example.thymeleafvalidation.domain.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntityDTO {
    private long id;

    public BaseEntityDTO(long id) {
        this.id = id;
    }

    public BaseEntityDTO() {
    }

}
