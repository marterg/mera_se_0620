import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class ShopTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Comparator<ShopItem> comparator = shop.getSorters().get(ThreadLocalRandom.current().nextInt(shop.getSorters().size()));
        shop.getGoods()
                .stream()
                .sorted((comparator))
                .forEach(System.out::println);
    }
}