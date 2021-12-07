package com.nazartsyhaniuk.lincor_api.command.commands;

import lombok.*;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AddItemCommand {

    @TargetAggregateIdentifier
    private UUID id;

    private String name;
}
