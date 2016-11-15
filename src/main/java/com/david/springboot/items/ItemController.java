package com.david.springboot.items;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ddor on 14/11/2016.
 * Rest controller
 */

@RestController
@RequestMapping("/items")
public class ItemController {

    /**
     * Repository to store items
     */
    @Autowired
    private ItemRepository repository;

    /**
     * Get all items
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Gets all the items", nickname = "getAllItems")
    public Collection<Item> getAllItems(){
        return (Collection<Item>) repository.findAll();
    }

    /**
     * Find one item by id
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "Gets the specified item", nickname = "getItemById")
    public Item getItemById(@PathVariable Long id){
        return repository.findOne(id);
    }

    /**
     * List all items with the same name
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/search", params = {"name"})
    @ApiOperation(value = "Gets all the items with the name passed as param", nickname = "getItemByName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Item's name", required = true, dataType = "string", paramType = "query", defaultValue="")
    })
    public Collection<Item> getItemByName(@RequestParam(value="name") String name){
        return repository.findByName(name);
    }

    /**
     * Stores a new item
     * @param item
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Adds an item", nickname = "addItem")
    public void addItem(@RequestBody Item item){
        repository.save(item);
    }

    /**
     *
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ApiOperation(value = "Delete the specified item", nickname = "deleteItem")
    public void deleteItem(@PathVariable Long id){
        repository.delete(id);
    }
}
