import java.util.Random;

public class ArraysFor {
    public static void main(String[] args) {


        Random random = new Random();

        Integer[] array = new Integer[3];

        array[0] = random.nextInt(1000);
        array[1] = random.nextInt(1000);
        array[2] = random.nextInt(1000);


        for (int currentForIndex = 0; currentForIndex < array.length;)  {
            System.out.println(array[currentForIndex]);
            currentForIndex++;
        }

    }
}
