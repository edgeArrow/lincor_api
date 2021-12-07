package com.nazartsyhaniuk.lincor_api.common.event;

import com.nazartsyhaniuk.lincor_api.common.entity.Item;
import com.nazartsyhaniuk.lincor_api.common.repository.ItemRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class ItemEventsHandler {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemEventsHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @EventHandler
    public void on(AddItemEvent event) throws Exception {
        itemRepository.save(new Item(event.getId(), event.getName()));

        throw new Exception("Exception occurred");
    }

    @ExceptionHandler
    public void handle(Exception e) throws Exception {
        throw e;
    }
}
