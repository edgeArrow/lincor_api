package com.nazartsyhaniuk.lincor_api.query.projection;


import com.nazartsyhaniuk.lincor_api.common.entity.Item;
import com.nazartsyhaniuk.lincor_api.common.event.AddItemEvent;
import com.nazartsyhaniuk.lincor_api.common.repository.ItemRepository;
import com.nazartsyhaniuk.lincor_api.query.queries.GetItemQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ItemProjection {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemProjection(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @QueryHandler
    public Optional<Item> handle(GetItemQuery query) {
        return itemRepository.findById(query.getId());
    }

    @EventHandler
    public void on(AddItemEvent event) {
        Item item = new Item(
                event.getId(),
                event.getName()
        );

        if(itemRepository.existsById(item.getId())) {
            throw new RuntimeException("Id is already in use");
        }
        itemRepository.save(item);
    }

}
