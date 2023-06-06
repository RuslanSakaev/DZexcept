//исправьте код там, где требуется
/*

    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }


Необхоимо внести следующие изменения:

Удалить throws Exception из main метода, так как нет необходимости в указании этого исключения.
Заменить Throwable на ArithmeticException в первом catch блоке, чтобы перехватывать только исключение деления на ноль.
Можно заменить IndexOutOfBoundsException на ArrayIndexOutOfBoundsException в последнем catch блоке для перехвата исключений,
связанных с выходом за пределы массива.
Заменить значение индекса в abc[3] = 9; на abc[2] = 9;, чтобы не выйти за пределы массива.
Убрать throws FileNotFoundException из printSum метода, так как в нем нечему вызвать это исключение.
*/

//исправленный код:

package HomeWork2;

public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[2] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка деления на ноль");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Индекс выходит за пределы размера массива!");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
