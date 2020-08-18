package goods.electronics;

import goods.electronics.ElectronicItem;

public class Refrigerator extends ElectronicItem{
    private static final String TYPE = "Холодильник";
    private final int volume;
    public Refrigerator(final String name
            , final int power, final int volume){
        super(name, power);
        this.volume = volume;
    }
    @Override
    public String getType(){
        return TYPE;
    }
    @Override
    public String toString(){
        return "Refrigerator{" +
                "TYPE='" + TYPE + '\'' +
                ", volume=" + volume +
                "} " + super.toString();
    }
}