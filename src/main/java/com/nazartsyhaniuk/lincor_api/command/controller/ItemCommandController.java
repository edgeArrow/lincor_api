package com.nazartsyhaniuk.lincor_api.command.controller;

import com.nazartsyhaniuk.lincor_api.command.commands.AddItemCommand;
import com.nazartsyhaniuk.lincor_api.common.entity.Item;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/items")
@RestController
public class ItemCommandController {

    private final CommandGateway commandGateway;

    public ItemCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<Item> addItem(@RequestBody Item item) {
        return commandGateway.send(new AddItemCommand(item.getId(), item.getName()));
    }


}

