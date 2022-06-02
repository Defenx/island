package com.company.service.coordinator;

import com.company.model.Fauna;
import com.company.model.enums.Direction;
import com.company.model.Cell;
import com.company.model.Field;
import com.company.service.MovementService;
import com.company.service.randomservice.RandomDirectionService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MovementCoordinator {

    MovementService movementService = new MovementService();
    RandomDirectionService randomDirectionService = new RandomDirectionService();

    public void move(Field field, Cell cell, Fauna fauna) {
        Direction direction = randomDirectionService.chooseRandomDirection(cell, fauna.getSpeed());
        Cell destinationCell = movementService.calcCellToMove(field, cell, fauna.getSpeed(), direction);

        cell.getListOfEntity().remove(fauna);
        destinationCell.getListOfEntity().add(fauna);
    }

}
