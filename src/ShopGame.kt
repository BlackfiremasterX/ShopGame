import java.lang.NumberFormatException

fun main() {
    Info()
    ShopGame()
}
fun Info() {
    print(
        "Вас привествует игра 'ShopGame', тут есть покупки и закупки. C оптом и без опта.\n" +
                "scan - обзор цен на все товары\n" +
                "buy - покупка товара за цену указанную сверху\n" +
                "sell - продажа выбранных Вами продуктов, которые есть у Вас в наличии\n" +
                "В начале игры у Вас на депозите есть деньги(240$)\n" +
                "Вы должны их преумножить, но помните, что помимо товаров деньги можно потерять на функции scan(-5 за 1 раз)\n" +
                "Пишите команды в консоль для покупки(buy), продажи(sell) и поиска информации(scan)\n"
    )
}
fun ShopGame() {

    val goods_names = mutableMapOf(
        1 to "Кока-Коли",
        2 to "Молоко",
        3 to "Хлеб",
        4 to "Вода",
        5 to "Собакас"
    )
    var pr = goods_names.values
    var Money = 240
    var koka_count = 0
    var milk_count = 0
    var bread_count = 0
    var water_count = 0
    var sobakas_count = 0
    var mass_buy_sell = 0
    var product = 0
    var product_price = 0
    var product_count = 0
    var name_buffer = ""
    var run = true

    while (run) {
        print("\nВыберите действие[buy/sell/scan]: ")
        var user_choise = readLine()!!.toString().toLowerCase()
        when (user_choise) {
            "buy" -> {
                print("Выберите количество товара $name_buffer для покупки: "); mass_buy_sell = readLine()!!.toInt()
                if (Money >= (product_price * mass_buy_sell)) {
                    Money = Money - product_price * mass_buy_sell;println("Ваш счет: $Money$")
                    when (product) {
                        1 -> koka_count = koka_count + mass_buy_sell
                        2 -> milk_count = milk_count + mass_buy_sell
                        3 -> bread_count = bread_count + mass_buy_sell
                        4 -> water_count = water_count + mass_buy_sell
                        5 -> sobakas_count = sobakas_count + mass_buy_sell
                        else -> print("\nОшибка!")
                    }
                } else {
                    println("Недостаточно денег! Вы можете купить только ${(Money / product_price).toInt()}шт. $name_buffer")
                }
            }
            "sell" -> {
                try {
                    print("Выберите количество товара $name_buffer для продажи: "); mass_buy_sell = readLine()!!.toInt()
                    when (product) {
                        1 -> {
                            product_count = koka_count
                            if ((koka_count > 0) && (koka_count >= mass_buy_sell)) {
                                koka_count = koka_count - mass_buy_sell
                                Money = Money + product_price * mass_buy_sell;println("Ваш счет: $Money$")
                            }
                            else
                                print("Недостаточно товара на складе!\n" +
                                        "Товара $name_buffer всего лишь $product_count шт.")
                        }
                        2 -> { product_count = milk_count

                            if ((milk_count > 0) && (milk_count >= mass_buy_sell)) {
                                milk_count = milk_count - mass_buy_sell
                                Money = Money + product_price * mass_buy_sell;println("Ваш счет: $Money$")
                            }
                            else
                                print("Недостаточно товара на складе!\n" +
                                        "Товара $name_buffer всего лишь $product_count шт.")
                        }
                        3 -> {
                            product_count = bread_count
                            if ((bread_count > 0) && (bread_count >= mass_buy_sell)) {
                                bread_count = bread_count - mass_buy_sell
                                Money = Money + product_price * mass_buy_sell;println("Ваш счет: $Money$")
                            }
                            else
                                print("Недостаточно товара на складе!\n" +
                                        "Товара $name_buffer всего лишь $product_count шт.")
                        }
                        4 -> {
                            product_count = water_count
                            if ((water_count > 0) && (water_count >= mass_buy_sell)) {
                                water_count = water_count - mass_buy_sell
                                Money = Money + product_price * mass_buy_sell;println("Ваш счет: $Money$")
                            }
                            else
                                print("Недостаточно товара на складе!\n" +
                                        "Товара $name_buffer всего лишь $product_count шт.")
                        }
                        5 -> {
                            product_count = sobakas_count
                            if ((sobakas_count > 0) && (sobakas_count >= mass_buy_sell)) {
                                sobakas_count = sobakas_count - mass_buy_sell
                                Money = Money + product_price * mass_buy_sell;println("Ваш счет: $Money$")
                            }
                            else
                                print("Недостаточно товара на складе!\n" +
                                        "Товара $name_buffer всего лишь $product_count шт.")
                        }
                        else -> print("\nОшибка!")
                    }
                }
                catch (e:Exception)
                {
                    print("Вы ввели не предусмотренное значение попробуйте еще раз!")
                }
                catch (e:NumberFormatException)
                {
                    print("Вы ввели не предусмотренное значение попробуйте еще раз!")
                }
            }
            "scan" -> {
                try{  Money = Money - 5
                print(
                    "\nВыберите продукт:\n" +
                            "1.Кока-Коли[$koka_count]\n" +
                            "2.Молоко[$milk_count]\n" +
                            "3.Хлеб[$bread_count]\n" +
                            "4.Вода 'Грязный источник'[$water_count]\n" +
                            "5.Собакас[$sobakas_count]\n"
                ); print("Выберите продукт: ");
                product = readLine()!!.toInt();
                var koka = 56
                var milk = 50
                var bread = 23
                var water = 19
                var sobakas = 115
                when (product) {
                    1 -> {
                        name_buffer = "Кока-коли"
                        koka = (40..64).random();print("\nКока-Коли: $koka$\n");product_price =
                            koka;print("Ваш банк: $Money$")
                    }
                    2 -> {
                        name_buffer = "Молоко"
                        milk = (35..70).random();print("\nМолоко: $milk$\n");product_price =
                            milk;print("Ваш банк: $Money$")
                    }
                    3 -> {
                        name_buffer = "Хлеб"
                        bread = (15..30).random();print("\nХлеб: $bread$\n");product_price =
                            bread;print("Ваш банк: $Money$")
                    }
                    4 -> {
                        name_buffer = "Вода 'Грязный источник'"
                        water = (8..22).random();print("\nВода: $water$\n");product_price =
                            water;print("Ваш банк: $Money$")
                    }
                    5 -> {
                        name_buffer = "Собакас"
                        sobakas = (80..150).random();print("\nСобакас: $sobakas$\n");product_price =
                            sobakas;print("Ваш банк: $Money$")
                    }
                    else -> print("\nОшибка!")
                }
            }
              catch(e:Exception)
              {
                  print("Вы ввели не предусмотренное значение попробуйте еще раз!")
              }
            }
            else -> print("Ошибка! Введите одну из предусмотренных команд[buy/sell/scan]\n")
        }
    }
}