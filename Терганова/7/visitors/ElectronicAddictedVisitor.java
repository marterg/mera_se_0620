package visitors;

import goods.Item;
import goods.electronics.ElectronicItem;

import java.util.Collection;

public class ElectronicAddictedVisitor extends Visitor implements ShopVisitor{
    @Override
    public void visitShop(final Collection<? extends Item> inventory){
        ElectronicItem theMostPowerfulItem = null;
        for(Item item : inventory){
            if(!(item instanceof ElectronicItem)){
                continue;
            }
            final var electraItem = (ElectronicItem) item;
            lookAt(electraItem);
            System.out.println(item.getName() + " с мощностью " + electraItem.getPower());
            if(null == theMostPowerfulItem){
                theMostPowerfulItem = electraItem;
            }
            if(theMostPowerfulItem.getPower() < electraItem.getPower()){
                theMostPowerfulItem = electraItem;
            }
        }
        if(null != theMostPowerfulItem){
            buy(inventory, theMostPowerfulItem);
        }else{
            offense();
        }
    }
}