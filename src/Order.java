public class Order {
    String adress;
    int trail_long;
    int number;
    int[] stuff_array = new int[Stuff.assortment_list.length];
    public Order (String adress){
        this.adress = adress;
        this.number = (int) (Math.random() * 20)+1;
        for (int i = 0; i < stuff_array.length; i++)
            this.stuff_array[i] = buff[i];
    }
    public static void show(){
        System.out.print("Ваш заказ:");
        for (int i = 0; i < Order.buff.length; i++)
            if (Order.buff[i] != 0)
                System.out.print(" " + (i+1) + "." + (Stuff.assortment_list[i].name) + " x " + Order.buff[i] + ';');
        System.out.print('\n' + "Общая сумма заказа: " + Order.total_sum + '\n');
    }
    public void setTrail_long(){
        this.trail_long = (int) (Math.random()*20) + 1;
    }
    static int totalSumIncrease(int code, int trail_long) {
        if (code == Codes.delivery)
            return (int) (Delivery.delivery_koef * trail_long) + 100;
        else if (code == Codes.fast_delivery)
            return  (int) ( Delivery.fast_delivery_koef * trail_long) + 100;
        else return  0; // невозможно, но компилятор ругается, так что пусть будет
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
