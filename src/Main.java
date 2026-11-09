public class Main {
    public static void main(String[] args) {
        User user = new User("случайный адрес", 5000);
        String hello_phrase = "Здравствуйте! Приветствуем вас в нашем магазине \"Lowkey\" \n";
        boolean work_done = false;
        Order[] list_of_orders = new Order[10];
        System.out.print(hello_phrase);
            do {
                OrdersHistory.show(list_of_orders);
                do {
                    if (!Order.empty)
                        Order.show();
                    user.setMenu(new baseStuffMenu());
                    user.showMenu( user,  list_of_orders);
                } while (user.choice != Codes.exit);
                if (!Order.empty) { // Если заказ не пуст
                    user.setMenu(new Delivery());
                    user.showMenu(user,list_of_orders);
                }
                else
                    work_done = true;
            } while (!work_done);
            System.out.print("Допобачення!" + '\n');
        }
}


