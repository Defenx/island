package com.company.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cell {

    List<NatureObject> listOfEntity = new CopyOnWriteArrayList<>();
    Integer x;
    Integer y;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
