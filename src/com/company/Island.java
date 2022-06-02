package com.company;

import com.company.dto.MapConfig;
import com.company.manager.ConfigManager;
import com.company.model.Fauna;
import com.company.model.NatureObject;
import com.company.model.Cell;
import com.company.model.Field;
import com.company.model.enums.LiveableType;
import com.company.service.WorldGenerator;
import com.company.service.coordinator.FoodCoordinator;
import com.company.service.coordinator.MovementCoordinator;
import com.company.service.coordinator.PlantCoordinator;
import com.company.service.coordinator.ReproduceCoordinator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Island {

    MapConfig mapConfig = ConfigManager.getConfigManager().getMapConfig();
    WorldGenerator worldGenerator = new WorldGenerator();
    FoodCoordinator foodCoordinator = new FoodCoordinator();
    ReproduceCoordinator reproduceCoordinator = new ReproduceCoordinator();
    MovementCoordinator movementCoordinator = new MovementCoordinator();
    PlantCoordinator plantCoordinator = new PlantCoordinator();

    public void start() {
        Field field = initField(mapConfig);
        worldGenerator.generateWorld(field);

        Runnable scheduleTask = () -> {

            plantCoordinator.grow(field);

            Map<LiveableType, Long> collect = field.getCells()
                    .stream()
                    .flatMap(Collection::stream)
                    .flatMap(cell -> cell.getListOfEntity().stream())
                    .collect(Collectors.groupingBy(NatureObject::getLiveableType, Collectors.counting()));

            for (Map.Entry<LiveableType, Long> entry : collect.entrySet()) {
                System.out.println(entry.getKey().name() + " " + entry.getValue());
            }
            System.out.println();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        for (List<Cell> cellList : field.getCells()) {
            Runnable cellTask = () -> {
                for (Cell cell : cellList) {
                    List<NatureObject> listOfEntity = cell.getListOfEntity();
                    for (NatureObject entity : listOfEntity) {
                        if (entity instanceof Fauna fauna) {
                            foodCoordinator.eatOnCell(cell, fauna);
                            reproduceCoordinator.reproduceOnCell(cell, fauna);
                            movementCoordinator.move(field, cell, fauna);
                        }
                    }
                }
            };
            executorService.submit(cellTask);
        }

        scheduledExecutorService.scheduleWithFixedDelay(scheduleTask, 5, 15, TimeUnit.SECONDS);

//        field.getCells()
//                .stream()
//                .flatMap(Collection::stream)
//                .parallel()
//                .forEach(cell -> {
//                    cell.getListOfEntity().stream()
//                            .filter(entity -> entity instanceof Fauna)
//                            .map(entity -> (Fauna) entity)
//                            .forEach(fauna -> {
//                                foodCoordinator.eatOnCell(cell, fauna);
//                                reproduceCoordinator.reproduceOnCell(cell, fauna);
//                                movementCoordinator.move(field, cell, fauna);
//                            });
//                });

        executorService.shutdown();
    }

    private Field initField(MapConfig mapConfig) {
        Field field = new Field();
        for (int i = 0; i < mapConfig.getX(); i++) {
            field.getCells().add(new ArrayList<>());
            for (int j = 0; j < mapConfig.getY(); j++) {
                field.getCells().get(i).add(new Cell(i, j));
            }
        }
        return field;
    }

}
