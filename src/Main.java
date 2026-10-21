public User user = new User("случайный адрес", 5000 );
String hello_phrase = "Здравствуйте! Приветствуем вас в нашем магазине \"Lowkey\" \n";
boolean work_done = false;
Order[] list_of_orders = new Order[10];
void main()
{
    System.out.print(hello_phrase);
    do {
        OrdersHistory.show(list_of_orders);
        do {
            System.out.print("Ассортимент:" + '\n');
            for (int i = 0; i < Stuff.assortment_list.length; i++) {
                if (Stuff.assortment_list[i].count_on_storage > 0)
                    System.out.print((i + 1) + ". " + Stuff.assortment_list[i].name + "  -  " + Stuff.assortment_list[i].price + "грн" + '\n');
            }
            System.out.print("Что хотите заказать? Введите номер товара (для завершения совершения заказа введите '0', для отмены - '-1'):" + '\n');
            user.choice = User.check_enter(Codes.return_stuff - 1, Stuff.assortment_list.length);
            if (user.choice > Codes.exit && user.choice <= Stuff.assortment_list.length)
                Stuff.menu_of_stuff(user.choice);
            else if (user.choice == Codes.return_stuff && !Order.empty)
                Order.delete_stuff();
            if (!Order.empty) {
                Order.show();
            }
        } while (user.choice != Codes.exit);
        if (!Order.empty)  // Если заказ не пуст
            Delivery.menu(user, list_of_orders);
        else
            work_done = true;
    }while (!work_done);
    System.out.print("Допобачення!" + '\n');
}

