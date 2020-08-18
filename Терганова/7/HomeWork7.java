import goods.Item;
import goods.electronics.ElectronicItem;
import goods.food.FoodItem;

import manufacters.AppleGarden;
import manufacters.ElectronicFabric;
import manufacters.FoodFactory;

import supervisors.Inventory;
import supervisors.Supervisor;

import visitors.ElectronicAddictedVisitor;
import visitors.ImJustLookingVisitor;
import visitors.RichVisitor;
import visitors.ShopVisitor;

import java.util.ArrayList;

class HomeWork7 {

    public static void main(String[] args){
        task();
    }
    @SuppressWarnings("SpellCheckingInspection")

    private static void task(){
        final Supervisor supervisor = new Supervisor();

        final Inventory<Item>           hippInv = supervisor.HIPPER_MARKET_INVENTORY;
        final Inventory<ElectronicItem> elecInv = supervisor.ELECTRA_SHOP_INVENTORY;
        final Inventory<FoodItem>       foodInv = supervisor.FOOD_SHOP_INVENTORY;
        final Inventory<FoodItem>       nearInv = supervisor.NEAR_STALL_INVENTORY;
        ArrayList<Inventory<? extends Item>> shops = new ArrayList<>();
        shops.add(hippInv);
        shops.add(elecInv);
        shops.add(foodInv);
        shops.add(nearInv);
        //Manufactures:
        final var electronicFabric = new ElectronicFabric();
        final var      appleGarden = new AppleGarden();
        final var      foodFactory = new FoodFactory();

        electronicFabric.printName();
        electronicFabric.fillShopWithElectronicGoods(hippInv, 3, 5);
        electronicFabric.fillShopWithElectronicGoods(elecInv, 2, 3);

        appleGarden.printName();
        appleGarden.fillShopWithApples(foodInv,2,3);
        appleGarden.fillShopWithApples(nearInv,2, 5);
        appleGarden.fillShopWithApples(hippInv,2,3);

        foodFactory.printName();
        foodFactory.fillShopWithFood(foodInv, 1,2);
        foodFactory.fillShopWithFood(hippInv, 1,2);


        shops.forEach(inventory ->
                inventory.forEach(item ->
                        item.setPrice(supervisor.givePriceFor(item))));

        revise("\n==== РЕВИЗИЯ ПЕРЕД ОТКРЫТИЕМ ====", shops);
        System.out.println("\n==== ПОКУПАТЕЛИ ====");

        ArrayList<ShopVisitor> visitors = new ArrayList<>();
        visitors.add(new ImJustLookingVisitor());
        visitors.add(new ElectronicAddictedVisitor());
        visitors.add(new RichVisitor());
        visitors.forEach(visitor ->	shops.forEach(shop -> {
            System.out.println("Покупатель " + visitor.getName()
                    + " зашел в " + shop.getTitle());
            visitor.visitShop(shop);
        }));
        revise("\n==== РЕВИЗИЯ ПОСЛЕ ЗАКРЫТИЯ ====", shops);
    }
    private static void revise(final String reviseName, final ArrayList<Inventory<? extends Item>> shops){
        System.out.println(reviseName);
        shops.forEach(shop -> {
            System.out.println(shop.getTitle());
            shop.forEach(item ->
                    System.out.println(item.toString()));
        });
    }
}