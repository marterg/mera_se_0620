package goods.food;

import goods.food.FoodItem;

public class Apple extends FoodItem{
    private static final String TYPE = "Яблоко";
    public enum Colors{GOLD, SILVER, COOPER, BLACK, WHITE, TRANSPARENT}
    private final Colors color;
    public Apple(final String name, final int calories, final int expiration
            , final Colors color){
        super(name, calories, expiration);
        this.color = color;
    }
    @Override
    public String getType(){
        return TYPE;
    }
    @Override
    public String toString(){
        return "Apple{" +
                "TYPE='" + TYPE + '\'' +
                ", color=" + color +
                "} " + super.toString();
    }
}