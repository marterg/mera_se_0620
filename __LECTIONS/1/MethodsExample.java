public class MethodsExample {


    public static void main(String[] args) {


/*
        Integer i1 = 1;
        Integer i2 = 3;
        final Integer res = addOneNumberToAnother(i1, i2);

        System.out.println(res);*/


        final Integer result = addOneNumberToAnother(4, 4);
        addOneNumberToAnotherAndPrint(result,  1);





     /*   addOneNumberToAnotherAndPrint(2, 2);
        addOneNumberToAnotherAndPrint(3, 3);
*/

     /*   printHello();
        printHello();
        printHello();
        printHello();*/



    }



    static void printHello() {
        System.out.println("Hello, world!");

    }


    static void addOneNumberToAnotherAndPrint(Integer one, Integer another) {
        System.out.println("Складываю " + one + " " + another);
        System.out.println(one + another);

    }


    static Integer addOneNumberToAnother(Integer one, Integer another) {
        Integer result = one + another;
        return result;
    }
}
