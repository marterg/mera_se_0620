package manufacters;

import goods.food.FoodItem;
import goods.food.inventory.Apple;
import goods.food.inventory.Bread;
import supervisors.Inventory;

import static util.giveRandom;

public class FoodFactory extends Manufacture{
    public final Apple[] apples = new Apple[]{
            new Apple(Apple.Colors.BLACK.name(),      100, 110, Apple.Colors.BLACK),
            new Apple(Apple.Colors.WHITE.name(),      101, 111, Apple.Colors.WHITE),
            new Apple(Apple.Colors.TRANSPARENT.name(),102, 112, Apple.Colors.TRANSPARENT),
    };
    public final Bread[] loaves = new Bread[]{
            new Bread("Батон"    ,201, 211, 221),
            new Bread("Белый"    ,202, 212, 222),
            new Bread("Бублик"   ,203, 213, 223),
            new Bread("Булка"    ,204, 214, 224),
            new Bread("Плюшка"   ,205, 215, 225),
            new Bread("Пшеничный",206, 216, 226),
            new Bread("Ржаной"   ,207, 217, 227),
            new Bread("Серый"    ,208, 218, 228),
    };
    public void fillShopWithFood(Inventory<? super FoodItem> inventory
            , final int min, final int max){
        for(int i = max; min <= --i; ){
            final FoodItem item = giveRandom()
                    ? apples[giveRandom(apples.length)]
                    : loaves[giveRandom(loaves.length)];
            inventory.add(item);
            printToShopAdded(inventory.getTitle(), item);
        }
    }
}