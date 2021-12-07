package com.nazartsyhaniuk.lincor_api.query.controller;

import com.nazartsyhaniuk.lincor_api.common.entity.Item;
import com.nazartsyhaniuk.lincor_api.query.queries.GetItemQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/items")
@RestController
public class ItemQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public ItemQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{id}")
    public CompletableFuture<Item> getItem(@PathVariable("id") UUID id) {
        return this.queryGateway.query(
                new GetItemQuery(id), ResponseTypes.instanceOf(Item.class));
    }
}
