package visitors;

import goods.Item;

import java.util.Collection;

public class ImJustLookingVisitor extends Visitor implements ShopVisitor{
    @Override
    public void visitShop(final Collection<? extends Item> inventory){
        for(Item item: inventory){
            lookAt(item);
        }
    }
}