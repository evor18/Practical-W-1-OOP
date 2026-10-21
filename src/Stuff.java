import  java.util.Scanner;
public  class Stuff {
    String name;
    int price;
    int count_on_storage;
    Stuff (String name, int price, int count_on_storage)
    {
        this.name = name;
        this.price = price;
        this.count_on_storage = count_on_storage;
    }
    public static void menu_of_stuff(int stuff_number)
    {
        System.out.print("Введите кол-во товара: " + '\n');
        Scanner scanner = new Scanner(System.in);
        int count_stuff = scanner.nextInt();
        if (count_stuff <= Stuff.assortment_list[stuff_number-1].count_on_storage ){
            Order.buff[stuff_number-1] = count_stuff;
            Stuff.assortment_list[stuff_number-1].count_on_storage = Stuff.assortment_list[stuff_number-1].count_on_storage - count_stuff;
            if (count_stuff>0)
                Order.empty = false;
            Order.total_sum += Stuff.assortment_list[stuff_number-1].price * count_stuff;
        }
        else
            System.out.print("Операция не может быть выполнена"+ '\n');

    }
    static Stuff kinder_pingie = new Stuff ("Киндер Пингви" , 40, 10);
    static Stuff rope = new Stuff ("Верёвка", 80, 15);
    static Stuff soap = new Stuff ("Мыло", 70, 15);
    static Stuff dark_souls_3 = new Stuff("Тёмные души 3 игра на русском языке", 500, 31);
    static Stuff pushilins_portrait = new Stuff ("Портрет главы ДНР Д. Пушилина", 400, 12);
    static  Stuff toothless_funkopop_figure = new Stuff ("Фигурка ФанкоПоп Беззубик из" +
            " \" Как приручить дракона\" ", 1000, 32);
    public static Stuff[] assortment_list = {kinder_pingie, rope, soap, dark_souls_3, pushilins_portrait,
            toothless_funkopop_figure};
}


