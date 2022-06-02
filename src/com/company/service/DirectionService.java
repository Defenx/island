package com.company.service;

import com.company.manager.ConfigManager;
import com.company.dto.MapConfig;
import com.company.model.enums.Direction;
import com.company.model.Cell;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static com.company.model.enums.Direction.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DirectionService {

    MapConfig mapConfig = ConfigManager.getConfigManager().getMapConfig();

    public List<Direction> chooseCorrectDirection(Cell cell, int speed) {
        List<Direction> directions = new ArrayList<>(List.of(UP, DOWN, LEFT, RIGHT));

        if (speed > mapConfig.getX() - cell.getX()) {
            directions.remove(RIGHT);
        } else if (speed < mapConfig.getX() - cell.getX()) {
            directions.remove(LEFT);
        }

        if (speed > mapConfig.getY() - cell.getY()) {
            directions.remove(DOWN);
        } else if (speed < mapConfig.getY() - cell.getY()) {
            directions.remove(UP);
        }

        return directions;
    }

}
