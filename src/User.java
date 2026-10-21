import java.util.Scanner;

public class User {
    String adress;
    int money;
    public User (String adress, int money)
    {
        this.adress = adress;
        this.money = money;
    }
    int choice;
    int delivery_choice;
    int courier_choice;
    static int check_enter ( int low_border, int high_border)
    {
        Scanner scanner = new Scanner(System.in);
        int message_int = 0;
        String message;
        boolean wrong_enter = false;
        do {
            message = scanner.next();
            wrong_enter = false;
            try {
                message_int = Integer.parseInt(message);
                if (message_int <= low_border || message_int > high_border)
                    System.out.print("Неверный ввод!" + '\n');
            } catch (NumberFormatException e) {
                System.out.print("Неправильный ввод!" + '\n');
                wrong_enter = true;
            }
        } while (wrong_enter || message_int <= low_border || message_int > high_border);
        return message_int;
    }
}
