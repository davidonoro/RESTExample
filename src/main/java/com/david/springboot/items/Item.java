package com.david.springboot.items;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ddor on 14/11/2016.
 * Entity that is going to be stored in db
 */
@Entity
public class Item {

    /**
     * anotation for the id of the object
     */
    @Id
    private long id;
    private String name;

    /**
     * Constructor only for jpa
     */
    protected Item(){}

    /**
     * Constructor
     * @param id
     * @param name
     */
    public Item(long id, String name) {
        this.id = id;
        this.name = name;
    }


    @ApiModelProperty(notes = "The name of the item", required = true)
    public long getId() {
        return id;
    }

    @ApiModelProperty(notes = "The name of the item", required = true)
    public String getName() {
        return name;
    }


}
