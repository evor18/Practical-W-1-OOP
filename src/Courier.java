public class Courier implements Menu {
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
    public void showMenu(User user, Order[] list_of_orders) {
        Courier.showNames();
        System.out.print("Для выхода обратно введите: '" + Codes.exit + "'." + '\n');
        user.courier_choice = User.check_enter(Codes.exit-1, Courier.names.length);
        if (user.courier_choice !=Codes.exit) {
            if (user.money >= Order.total_sum) {
                setAddress.set(user, list_of_orders);
                Order.showTotalSum();
                System.out.print("Вам везёт заказ " + Courier.names[user.courier_choice - 1] + '.' + '\n');
                while (list_of_orders[Order.count_of_orders].trail_long > 0) {
                    System.out.print("Ожидайте заказ номер: " + list_of_orders[Order.count_of_orders].number +
                            ". Осталось " + list_of_orders[Order.count_of_orders].trail_long / Courier.speeds[user.delivery_choice - 2] + " минут. \n");
                    list_of_orders[Order.count_of_orders].trail_long -= Courier.speeds[user.delivery_choice - 2];
                }
                System.out.print("Заберите заказ! \n");
                Order.count_of_orders++;
                Order.empty = true; // Для оформления нового заказа
                Order.array_in_zero(Order.buff);
                user.money -= Order.total_sum;
                Order.total_sum = 0;
            } else
                System.out.print("Недостаточно средств. \n");
        }
    }
}
