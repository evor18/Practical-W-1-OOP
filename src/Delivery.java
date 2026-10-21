import java.util.Scanner;
public class Delivery {
    public static final double delivery_koef = 1.2, fast_delivery_koef = 1.5;
    public static String address = "ул. Грибоедова д.6";
    static int totalSumIncrease(int code, int trail_long) {
        if (code == Codes.delivery)
                return (int) (Delivery.delivery_koef * trail_long) + 100;
        else if (code == Codes.fast_delivery)
                return  (int) ( Delivery.fast_delivery_koef * trail_long) + 100;
        else return  0; // невозможно, но компилятор ругается, так что пусть будет
    }
    static void setAddress(User user, Order[] list_of_orders){
        Scanner scanner = new Scanner(System.in);
        switch (user.delivery_choice) {
            case Codes.exit:
                break;
            case Codes.samovivoz:
                list_of_orders[Order.count_of_orders] = new Order(Delivery.address, Order.buff);
                break;
            case Codes.delivery:
                System.out.print("Введите адрес доставки:" + '\n');
                user.adress = scanner.next();
                list_of_orders[Order.count_of_orders] = new Order(user.adress, Order.buff);
                list_of_orders[Order.count_of_orders].setTrail_long();
                Order.total_sum += Delivery.totalSumIncrease(Codes.delivery, list_of_orders[Order.count_of_orders].trail_long);
                break;
            case Codes.fast_delivery:
                System.out.print("Введите адрес доставки:" + '\n');
                user.adress = scanner.next();
                list_of_orders[Order.count_of_orders] = new Order(user.adress, Order.buff);
                list_of_orders[Order.count_of_orders].setTrail_long();
                Order.total_sum += Delivery.totalSumIncrease(Codes.fast_delivery, list_of_orders[Order.count_of_orders].trail_long);
        }
    }
    public static void menu(User user, Order[] list_of_orders) {

        System.out.print("Как хотите получить заказ?" + '\n' + Codes.samovivoz + " Самовывоз;" + '\n' + Codes.delivery
                + " Доставкой;" + '\n' + Codes.fast_delivery + " Экспресс-доставкой;" + '\n' + Codes.exit + " Вернуться. \n");
        user.delivery_choice = User.check_enter(Codes.exit - 1, Codes.fast_delivery);
        setAddress( user, list_of_orders);
        list_of_orders[Order.count_of_orders].setNumber();
        if (user.delivery_choice != Codes.samovivoz && user.delivery_choice != Codes.exit) {
            Courier.showNames();
            user.courier_choice = User.check_enter(0, Courier.names.length);
            Order.showTotalSum();

            if (user.money>=Order.total_sum) {
                System.out.print("Вам везёт заказ " + Courier.names[user.courier_choice - 1] + '.' + '\n');
                while (list_of_orders[Order.count_of_orders].trail_long > 0) {
                    System.out.print("Ожидайте заказ номер: " +   list_of_orders[Order.count_of_orders].number +
                            ". Осталось " + list_of_orders[Order.count_of_orders].trail_long / Courier.speeds[user.delivery_choice - 2] + " минут. \n");
                    list_of_orders[Order.count_of_orders].trail_long -= Courier.speeds[user.delivery_choice - 2];
                }
                System.out.print("Заберите заказ! \n");
                Order.count_of_orders++;
                Order.empty = true; // Для оформления нового заказа
                Order.array_in_zero(Order.buff);
                user.money-= Order.total_sum;
                Order.total_sum = 0;
            }
            else
                System.out.print("Недостаточно средств. \n");
        } else if (user.delivery_choice == Codes.samovivoz) {
            Order.showTotalSum();
            if (user.money>=Order.total_sum) {
                System.out.print("Номер вашего заказа: " + list_of_orders[Order.count_of_orders].number + ". Заберите заказ по адресу: " + Delivery.address + '.' + '\n');
                Order.empty = true; // Для оформления нового заказа
                Order.count_of_orders++;
                Order.array_in_zero(Order.buff);
                user.money-=Order.total_sum;
                Order.total_sum = 0;
            }
            else
                System.out.print("Недостаточно средств. \n");
        }
    }


}

