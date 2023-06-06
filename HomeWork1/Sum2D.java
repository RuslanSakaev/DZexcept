//    Посмотрите на код,
/*
public static int sum2d(String[][]arr){
int sum=0;
for(int i=0;i<arr.length;i++){
for(int j=0;j< 5;j++){
int val=Integer.parseInt(arr[i][j]);
sum+=val;
}
}
return sum;
}
 */
// и подумайте сколько разных типов исключений вы тут сможете получить?
/*
Можно выделить несколько типов исключений:

1. NumberFormatException: Возникает при попытке преобразования строки в число методом `Integer.parseInt()`.
Если в `arr[i][j]` содержится некорректное числовое значение, то будет выброшено исключение.

2. NullPointerException: Если переменная `arr` является `null`,
то будет выброшено исключение при попытке обращения к ней для получения её длины или элементов.

3. ArrayIndexOutOfBoundsException: Если значение переменной `i` превышает длину `arr`
или значение переменной `j` превышает 4 (так как во внутреннем цикле используется фиксированное значение 5),
то будет выброшено исключение при обращении к элементам массива.

*/

// Обработайте возможные исключительные ситуации.
// Битые значения в исходном коде принимать за null

package HomeWork1;

public class Sum2D {
    public static int sum2D(String[][] arr) {
        int sum = 0;
        if (arr == null) {
            System.out.println("Массив не инициализирован");
            return sum;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = new String[0];
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка преобразования строки в число: " + arr[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] arr = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        int totalSum = sum2D(arr);
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}


