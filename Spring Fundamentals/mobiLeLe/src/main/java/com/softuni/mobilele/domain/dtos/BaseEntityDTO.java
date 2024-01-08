package com.softuni.mobilele.domain.dtos;

public class BaseEntityDTO {
    private long id;

    public BaseEntityDTO(long id) {
        this.id = id;
    }

    public BaseEntityDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
