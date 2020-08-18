package goods.electronics;

import goods.Item;

public abstract class ElectronicItem extends Item{
    private final int power;
    public ElectronicItem(final String name, final int power){
        super(name);
        this.power = power;
    }
    public int getPower(){
        return power;
    }
    @Override
    public String toString(){
        return "ElectronicItem{" +
                "power=" + power +
                "} " + super.toString();
    }
}