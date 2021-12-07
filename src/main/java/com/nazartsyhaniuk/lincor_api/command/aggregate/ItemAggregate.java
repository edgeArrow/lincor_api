package com.nazartsyhaniuk.lincor_api.command.aggregate;

import com.nazartsyhaniuk.lincor_api.command.commands.AddItemCommand;
import com.nazartsyhaniuk.lincor_api.common.event.AddItemEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Aggregate
public class ItemAggregate {

    @AggregateIdentifier
    private UUID id;

    private String name;

    @CommandHandler
    public ItemAggregate(AddItemCommand command) {
        AggregateLifecycle.apply(new AddItemEvent(command.getId(), command.getName()));
    }

    @EventSourcingHandler
    public void on(AddItemEvent event) {
        this.id = event.getId();
        this.name = event.getName();
    }
}
