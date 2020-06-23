public class ComparisionEquals {

    public static void main(String[] args) {
        String str1 = "text";
        String str2 = "text";

        Boolean equals = str1.equals(str2);
        System.out.println(equals);


        Integer i1 = 100_500;
        Integer i2 = 100_500;

        System.out.println(i1 .equals( i2));

        Integer i3 = 100;
        Integer i4 = 100;

        System.out.println(i3 .equals( i4));
    }
}
