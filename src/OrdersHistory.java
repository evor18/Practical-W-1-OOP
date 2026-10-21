public class OrdersHistory {

    public static void show(Order []list_of_orders) {
        if (Order.count_of_orders > 0) {
            System.out.print("История заказов: \n ");
            for (int i = 0; i < Order.count_of_orders; i++) {

                System.out.print('\n' + "N" + list_of_orders[i].number + ':');
                for (int j = 0; j < Stuff.assortment_list.length; j++)
                    if (list_of_orders[i].stuff_array[j] > 0)
                        System.out.print(' ' + Stuff.assortment_list[j].name + " X " + list_of_orders[i].stuff_array[j] + ',');
            }
            System.out.print('\n');
        }
    }
}
