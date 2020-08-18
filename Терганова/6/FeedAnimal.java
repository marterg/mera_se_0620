
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FeedAnimal {
    public static void main(String[] args) {
        List<Pair<Animal, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(new Animal("кот", "Матроскин"), "бутерброд"));
        pairs.add(new Pair<>(new Animal("галчонок", "Ктотам"), "муха"));
        pairs.add(new Pair<>(new Animal("собака", "Шарик"), "кость"));
        pairs.add(new Pair<>(new Animal("корова", "Мурка"), "трава"));

        feedAnimal(pairs);

        if(pairs.get(0).equals(pairs.get(1))) {
            System.out.printf("Выбраны одинаковые животные");
        } else {
            System.out.printf("Рассмотрим животное %s и животное %s :", pairs.get(0), pairs.get(1));
        }

        if(pairs.get(2).equals(pairs.get(3))) {
            System.out.printf("Выбраны одинаковые животные");
        } else {
            System.out.printf("Рассмотрим животное %s и животное %s :", pairs.get(2), pairs.get(3));
        }
    }
    public static void feedAnimal(List<Pair<Animal, String >> pairs) {
        int lucky = ThreadLocalRandom.current().nextInt(pairs.size());

        for(int i = 0; i < pairs.size(); i++) {
            Pair<Animal, String> pair = pairs.get(i);
            if (i == lucky) {
                System.out.printf("Счастливое животное %s получает двойную порцию %s\n", pair.getFirst().getName(), pair.getSecond());
            } else {
                System.out.printf("Животное %s с радостью ест %s\n", pair.getFirst().getName(), pair.getSecond());
            }

        }
    }
}