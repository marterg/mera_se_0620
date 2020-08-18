package manufacters;

import goods.electronics.ElectronicItem;
import goods.electronics.inventory.Refrigerator;
import goods.electronics.inventory.TV;
import supervisors.Inventory;

import static util.giveRandom;

public class ElectronicFabric extends Manufacture{
    private final TV[] tvs = new TV[]{
            new TV("Philips",  300,310),
            new TV("Sharp",    301,311),
            new TV("LG",       302,312),
            new TV("SONY",     303,313),
            new TV("Panasonic",304,314),
            new TV("JVC",      305,315),
            };
    private final Refrigerator[] refrigerators = new Refrigerator[]{
            new Refrigerator("Свияга",     400,410),
            new Refrigerator("Север",      401,411),
            new Refrigerator("Атлант",     402,412),
            new Refrigerator("Ока",        403,413),
            new Refrigerator("ЗИЛ",        404,414),
            new Refrigerator("Бирюса",     405,415),
    };
    public void fillShopWithElectronicGoods(Inventory<? super ElectronicItem> inventory
            , final int min, final int max){
        for(int i=max; min<=--i; ){
            final ElectronicItem item= produce();
            inventory.add(item);
            printToShopAdded(inventory.getTitle(), item);
        }
    }
    private ElectronicItem produce(){
        return switch(giveRandom(new Class[]{Refrigerator.class, TV.class}.length)){
            case 0 -> refrigerators[giveRandom(refrigerators.length)];
            case 1 -> tvs[giveRandom(tvs.length)];
            default -> throw new IllegalStateException("Unexpected case value");
        };
    }
}