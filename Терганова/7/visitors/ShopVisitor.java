package visitors;

import goods.Item;

import java.util.Collection;
import java.util.Iterator;

public interface ShopVisitor{
    void visitShop(final Collection<? extends Item> inventory);
    String getName();
}
abstract class Visitor{
    public String getName(){
        return getClass().getSimpleName().substring(0,6);
    }
    private String getShoperName(){
        return "Покупатель " + getName();
    }
    void lookAt(final Item item){
        System.out.println(getShoperName()
                + " осмотрел: " + item.getName()
                + " - цена: " + item.getPrice());
    }
    void pay(final Item item){
        System.out.println(getShoperName()
                + " оплатил с доставкой: " + item.getName()
                + " по цене: " + item.getPrice());
    }
    void take(final Iterator<? extends Item> iterator, final Item item){
        System.out.println(getShoperName()
                + " получил при доставке: " + item.getName());
        iterator.remove();
    }
    void buy(final Collection<? extends Item> inventory, final Item item){
        System.out.println(getShoperName()
                + " купил: " + item.getName()
                + " по цене: " + item.getPrice()
                + " и забрал");
        inventory.remove(item); // и унес с собой
    }
    void offense(){
        System.out.println(getShoperName()
                + " не доволен отсутствием нужного товара");
    }
    void skip(){
        System.out.println(getShoperName()
                + " .. не понравилось качество");
    }
}