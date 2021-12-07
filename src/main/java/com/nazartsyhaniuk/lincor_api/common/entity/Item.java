package com.nazartsyhaniuk.lincor_api.common.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Item {

    @Id
    private UUID id;

    private String name;
}
