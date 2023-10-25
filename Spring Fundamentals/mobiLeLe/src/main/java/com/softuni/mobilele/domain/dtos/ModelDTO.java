package com.softuni.mobilele.domain.dtos;

import java.util.Date;

public class ModelDTO extends BaseEntityDTO{
    private String name;
    private String category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private Date created;
    private Date modified;

    public ModelDTO(long id, String name, String category, String imageUrl, int startYear, int endYear, Date created, Date modified) {
        super(id);
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
