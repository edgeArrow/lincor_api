package com.nazartsyhaniuk.lincor_api.common.event;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AddItemEvent {

    private UUID id;

    private String name;
}
