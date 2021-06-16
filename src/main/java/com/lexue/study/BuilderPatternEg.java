package com.lexue.study;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternEg {

    interface Packing {

        String pack();
    }

    static class Wrapper implements Packing {

        @Override
        public String pack() {
            return "Wrapper";
        }
    }

    static class Bottle implements Packing {
        @Override
        public String pack() {
            return "Bottle";
        }
    }

    interface Item {

        String name();

        Packing packing();

        Float price();
    }


    abstract static class Burger implements Item{

        @Override
        public Packing packing() {
            return new Wrapper();
        }

    }

    static abstract class ColdDrink implements Item {
        @Override
        public Packing packing() {
            return new Bottle();
        }
    }

    static class VegBurger extends Burger {

        @Override
        public String name() {
            return "VegBurger";
        }

        @Override
        public Float price() {
            return 10F;
        }
    }

    static class ChickenBurger extends Burger {

        @Override
        public String name() {
            return "ChickenBurger";
        }

        @Override
        public Float price() {
            return 20F;
        }
    }

    static class Coke extends ColdDrink {

        @Override
        public String name() {
            return "Coke";
        }

        @Override
        public Float price() {
            return 5F;
        }
    }

    static class Pepsi extends ColdDrink {

        @Override
        public String name() {
            return "Pepsi";
        }

        @Override
        public Float price() {
            return 6F;
        }
    }

    static class Meal {

        private final List<Item> items = new ArrayList<>();

        public void addItem(Item item) {
            items.add(item);
        }

        public Float getCost() {
            return Double.valueOf(items.stream().mapToDouble(Item::price).sum()).floatValue();
        }

        public void showItems() {
            items.forEach(
                    item -> {
                        System.out.print("Item :" + item.name());
                        System.out.print(", Packing :" + item.packing().pack());
                        System.out.println(", Price :" + item.price());
                    }
            );
        }

    }

    static class MealBuild {

        public Meal prepareVegMeal() {
            Meal meal = new Meal();
            meal.addItem(new VegBurger());
            meal.addItem(new Coke());
            return meal;
        }

        public Meal prepareNonVegMeal() {
            Meal meal = new Meal();
            meal.addItem(new ChickenBurger());
            meal.addItem(new Pepsi());
            return meal;
        }

    }


    public static void main(String[] args) {
        MealBuild mealBuild = new MealBuild();
        Meal vagMeal = mealBuild.prepareVegMeal();
        System.out.println("Veg vagMeal");
        vagMeal.showItems();
        System.out.println("Total Cost: " + vagMeal.getCost());

        Meal nonVegMeal = mealBuild.prepareNonVegMeal();
        System.out.println("Non-Veg vagMeal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }


}
