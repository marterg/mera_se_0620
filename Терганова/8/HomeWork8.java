import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomeWork8 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Vasia vasia1 = new Vasia();
        vasia.setPassword("345");

        System.out.println("Создан объект 'Вася': "+vasia1);
        String serialized = Serializer.serialize(Arrays.asList(vasia1));
        System.out.println("Результат сериализации Васи: "+ serialized);

        List<Vasia> vasias = Serializer.deserialize(serialized, Vasia.class);
        Vasia vasia2 = null;
        if(vasias != null){
            vasia2 = vasias.get(0);
        }
        System.out.println("Результат десериализации Васи: " + vasia2);

        Person[] notIvanov = new Person[2];
        notIvanov[0] = new Person();
        notIvanov[0].setFirstName("Николай");
        notIvanov[0].setParentName("Николаевичч");
        notIvanov[0].setSecondName("Николаев");
        notIvanov[0].setAge(27);
        notIvanov[0].setHasFamily(true);

        notIvanov[1] = new Person();
        notIvanov[1].setFirstName("Семён");
        notIvanov[1].setParentName("Семёнович");
        notIvanov[1].setSecondName("Семенов");
        notIvanov[1].setAge(37);
        notIvanov[1].setHasFamily(true);

        System.out.println("Создан список (неИвановых): ");
        System.out.println(notIvanov[0]);
        System.out.println(notIvanov[1]);

        String serialized2 = Serializer.serialize(Arrays.asList(notIvanov));
        System.out.println("Результат сериализации: " + serialized2);

        List<Person> notIvanov2 = Serializer.deserialize(serialized2, Person.class);
        if(notIvanov2 == null){
            System.out.println("Результат десериализации неИвановых: null");
        } else {
            for (int i = 0; i < notIvanov2.size(); i++) {
                Person notIvan2 = notIvanov2.get(i);
                if(notIvan2 == null){
                    System.out.println("Результат десериализации неИвановых: Объект["+i+"]: null");
                } else{
                    System.out.println("Результат десериализации неИвановых: Объект["+i+"]: "+notIvan2);
                }
            }
        }
    }
}