package com.company.service.coordinator;

import com.company.model.Fauna;
import com.company.model.NatureObject;
import com.company.model.Cell;
import com.company.service.ReproduceService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReproduceCoordinator {

    ReproduceService reproduceService = new ReproduceService();

    public void reproduceOnCell(Cell cell, Fauna fauna) {

        Optional<NatureObject> bornEntity = reproduceService.reproduce(fauna.getLiveableType());

        bornEntity.ifPresent(natureObject -> cell.getListOfEntity().add(natureObject));
    }

}
