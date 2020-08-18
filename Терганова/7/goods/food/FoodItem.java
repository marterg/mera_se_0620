package goods.food;

import goods.Item;

public abstract class FoodItem extends Item{
    private final int calories;
    private final int expiration;
    public FoodItem(final String name
            , final int calories, final int expiration){
        super(name);
        this.calories = calories;
        this.expiration = expiration;
    }
    @Override
    public String toString(){
        return "FoodItem{" +
                "calories=" + calories +
                ", expiration=" + expiration +
                "} " + super.toString();
    }
}