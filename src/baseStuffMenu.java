public class baseStuffMenu implements  Menu{
    public void showMenu(User user, Order[] list_of_orders){
        Stuff.showAssort();
        System.out.print("Что хотите заказать? Введите номер товара (для завершения совершения заказа введите '" + Codes.exit + "', для отмены товара" +
                " - '" + Codes.return_stuff + "')\n");
        user.choice = User.check_enter(Codes.return_stuff - 1, Stuff.assortment_list.length);
        if (user.choice == Codes.return_stuff && !Order.empty){
            Order.show();
            int index_delete_stuff;
            int count_delete_stuff;
            System.out.print("Какой товар хотите вернуть? Введите индекс товара: \n");
            index_delete_stuff = User.check_enter(0, Stuff.assortment_list.length)  - 1;
            if (Order.buff[index_delete_stuff] > 0) {
                System.out.print("Какое количество товара хотите вернуть? \n");
                count_delete_stuff = User.check_enter(-1, Order.buff[index_delete_stuff]);
                if (count_delete_stuff <= Order.buff[index_delete_stuff]){
                    Order.buff[index_delete_stuff]-= count_delete_stuff;
                    Stuff.assortment_list[index_delete_stuff].count_on_storage += count_delete_stuff;
                    Order.total_sum-= count_delete_stuff * Stuff.assortment_list[index_delete_stuff].price;
                }
                else
                    System.out.print("В корзине нет столько товара! \n");
            }
            else
                System.out.print("В корзине нет товара по этому индексу! \n");
            Order.empty = true;
            for (int i = 0; i < Stuff.assortment_list.length; i++ ) // Проверяем, не опустел ли заказ
                if (Order.buff[i]>0) Order.empty=false;
        }
        else if (user.choice!=Codes.exit) {
            int stuff_number = user.choice;
            System.out.print("Введите кол-во товара: " + '\n');
            int count_stuff = User.check_enter(-1, Integer.MAX_VALUE);
            if (count_stuff <= Stuff.assortment_list[stuff_number - 1].count_on_storage) {
                Order.buff[stuff_number - 1] = count_stuff;
                Stuff.assortment_list[stuff_number - 1].count_on_storage = Stuff.assortment_list[stuff_number - 1].count_on_storage - count_stuff;
                if (count_stuff > 0)
                    Order.empty = false;
                Order.total_sum += Stuff.assortment_list[stuff_number - 1].price * count_stuff;
            } else
                System.out.print("Операция не может быть выполнена" + '\n');
        }
    }
}
