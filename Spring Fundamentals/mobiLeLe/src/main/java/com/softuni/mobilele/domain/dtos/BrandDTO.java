package com.softuni.mobilele.domain.dtos;

import java.util.Date;

public class BrandDTO extends BaseEntityDTO{
    private Date created;
    private Date modified;
    private String name;

    public BrandDTO(long id) {
        super(id);
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
