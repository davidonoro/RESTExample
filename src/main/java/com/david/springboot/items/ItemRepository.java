package com.david.springboot.items;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ddor on 14/11/2016.
 * Inherits from crudrepository so it has all the crud typical methods
 * Methods apart from this are listed here. Spring will do magic and implement them
 */
public interface ItemRepository extends CrudRepository<Item,Long>{

    List<Item> findByName(String name);
}
