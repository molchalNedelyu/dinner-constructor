package ru.practicum.dinner;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;


public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    Random random = new Random();


    public void addDish(String dishType, String dishName) {

        if (!dishes.containsKey(dishType)) {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishes.put(dishType, dishNames);
        } else {
            dishes.get(dishType).add(dishName);

        }
    }

    public ArrayList<ArrayList<String>> generateCombos(int numberOfCombos, ArrayList<String> typesInCombo) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            combos.add(generateOneCombo(typesInCombo));
        }
        return combos;
    }

    public ArrayList<String> generateOneCombo(ArrayList<String> typesInCombo) { //список ключей хэш таблицы
        ArrayList<String> combo = new ArrayList<>();
        for (String type : typesInCombo) {
            ArrayList<String> value = dishes.get(type);
            String dish = value.get(random.nextInt(value.size()));
            combo.add(dish);
        }
        return combo;
    }

    public boolean checkDishType(String type) {
        return dishes.containsKey(type);
    }
}

