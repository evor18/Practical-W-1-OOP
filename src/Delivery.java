import java.util.Scanner;
public class Delivery implements Menu {
    public static final double delivery_koef = 1.2, fast_delivery_koef = 1.5;
    public static final String address = "ул. Грибоедова д.6";
    public void showMenu(User user, Order[] list_of_orders) {
        System.out.print("Как хотите получить заказ?" + '\n' + Codes.samovivoz + " Самовывоз;" + '\n' + Codes.delivery
                + " Доставкой;" + '\n' + Codes.fast_delivery + " Экспресс-доставкой;" + '\n' + Codes.exit + " Вернуться. \n");
        user.delivery_choice = User.check_enter(Codes.exit - 1, Codes.fast_delivery);
        if (user.delivery_choice == Codes.exit)
            return;
        else if (user.delivery_choice == Codes.samovivoz) {
            Order.showTotalSum();
            if (user.money >= Order.total_sum) {
                list_of_orders[Order.count_of_orders] = new Order(Delivery.address);
                System.out.print("Номер вашего заказа: " + list_of_orders[Order.count_of_orders].number + ". Заберите заказ по адресу: " + Delivery.address + '.' + '\n');
                Order.empty = true; // Для оформления нового заказа
                Order.count_of_orders++;
                Order.array_in_zero(Order.buff);
                user.money -= Order.total_sum;
                Order.total_sum = 0;
            } else
                System.out.print("Недостаточно средств. \n");
        }
        else {
            user.setMenu(new Courier());
            user.showMenu(user, list_of_orders);
        }
    }
}

