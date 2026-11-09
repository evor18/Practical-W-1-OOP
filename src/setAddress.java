import java.util.Scanner;

public class setAddress {
    static void set(User user, Order[] list_of_orders){
        Scanner scanner = new Scanner(System.in);
        switch (user.delivery_choice) {
            case Codes.delivery:
                System.out.print("Введите адрес доставки:" + '\n');
                user.adress = scanner.next();
                list_of_orders[Order.count_of_orders] = new Order(user.adress);
                list_of_orders[Order.count_of_orders].setTrail_long();
                Order.total_sum += Order.totalSumIncrease(Codes.delivery, list_of_orders[Order.count_of_orders].trail_long);
                break;
            case Codes.fast_delivery:
                System.out.print("Введите адрес доставки:" + '\n');
                user.adress = scanner.next();
                list_of_orders[Order.count_of_orders] = new Order(user.adress);
                list_of_orders[Order.count_of_orders].setTrail_long();
                Order.total_sum += Order.totalSumIncrease(Codes.fast_delivery, list_of_orders[Order.count_of_orders].trail_long);
        }
    }
}
