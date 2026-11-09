public  class Stuff{
    String name;
    int price;
    int count_on_storage;
    public Stuff (String name, int price, int count_on_storage)
    {
        this.name = name;
        this.price = price;
        this.count_on_storage = count_on_storage;
    }
    public static void showAssort(){
        System.out.print("Ассортимент:" + '\n');
        for (int i = 0; i < Stuff.assortment_list.length; i++) {
            if (Stuff.assortment_list[i].count_on_storage > 0)
                System.out.print((i + 1) + ". " + Stuff.assortment_list[i].name + "  -  " + Stuff.assortment_list[i].price + "грн" + '\n');
        }
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


