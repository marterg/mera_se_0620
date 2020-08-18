package goods.electronics;

import goods.electronics.ElectronicItem;

public class TV extends ElectronicItem{
    private static final String TYPE = "Телевизор";
    private int volume;
    public TV(final String name, final int power, final int volume){
        super(name, power);
        this.volume = volume;
    }
    @Override
    public String getType(){
        return TYPE;
    }
    @Override
    public String toString(){
        return "TV{" +
                "TYPE='" + TYPE + '\'' +
                ", volume=" + volume +
                "} " + super.toString();
    }
}