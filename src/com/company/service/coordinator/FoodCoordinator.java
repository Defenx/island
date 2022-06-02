package com.company.service.coordinator;

import com.company.model.Fauna;
import com.company.model.NatureObject;
import com.company.model.Cell;
import com.company.service.FoodService;
import com.company.service.randomservice.RandomFoodService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FoodCoordinator {

    FoodService foodService = new FoodService();
    RandomFoodService randomFoodService = new RandomFoodService();

    public void eatOnCell(Cell cell, Fauna who) {

        NatureObject natureObject = randomFoodService.chooseRandomNatureObjectForEat(cell, who);
        foodService.eat(who, natureObject).ifPresent(liveable -> cell.getListOfEntity().remove(liveable));

    }

}
