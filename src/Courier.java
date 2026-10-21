public class Courier {
    public static String[] names = {"Мухридин", "Рахмаджон", "Мансур"};
    public static final int not_fast_speed = 2, fast_speed = 3;
    static int[] speeds = {not_fast_speed, fast_speed};
    public static void showNames(){
        System.out.print("Выберите курьера: " + '\n');
        for (int i = 0; i < Courier.names.length; i++) {
            if (i != Courier.names.length - 1)
                System.out.print(i + 1 + ". " + ' ' + Courier.names[i] + ';' + '\n');
            else
                System.out.print(i + 1 + ". " + ' ' + Courier.names[i] + '.' + '\n');
        }
    }
}
