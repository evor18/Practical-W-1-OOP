public class Order {
    String adress;
    int trail_long;
    public void setTrail_long() {
        this.trail_long =(int) (Math.random()*20) + 1;
    }
    int number;
    int[] stuff_array = new int[Stuff.assortment_list.length];

    public Order (String adress,  int[] stuff_array){
        this.adress = adress;
        for (int i = 0; i < stuff_array.length; i++)
            this.stuff_array[i] = stuff_array[i];
    }
    static void delete_stuff(){
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
    public static void show(){
        System.out.print("Ваш заказ:");
        for (int i = 0; i < Order.buff.length; i++)
            if (Order.buff[i] != 0)
                System.out.print(' ' + (Stuff.assortment_list[i].name) + " x " + Order.buff[i] + ';');
        System.out.print('\n' + "Общая сумма заказа: " + Order.total_sum + '\n');
    }
    void setNumber(){
        this.number = (int) (Math.random() * 20);
    }
    public static void showTotalSum(){ System.out.print("С вас " + Order.total_sum + " гривен." + '\n');}
    static int total_sum = 0;
    static int count_of_orders = 0;
    static boolean empty = true;
    static int[] buff = new int[Stuff.assortment_list.length];
    public static int[] array_in_zero(int[] a)
    {
        for (int i = 0; i < a.length; i++)
            a[i] = 0;
        return a;
    }
}
