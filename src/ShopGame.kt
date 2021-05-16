fun main() {
    ShopGame()


}

fun ShopGame() {

    var Money = 1000
    var koka_count = 0
    var milk_count = 0
    var bread_count = 0
    var water_count = 0
    var sobakas_count = 0
    var product = 0
    var product_price = 0


    var run = true
    while (run) {

        print("\nВыберите действие[buy/sell/scan]: ")
        var user_choise = readLine()!!.toString().toLowerCase()
        when (user_choise) {
            "buy" -> {
                Money = Money - product_price;println("Ваш счет: $Money$")
                when (product) {
                    1 -> koka_count++
                    2 -> milk_count++
                    3 -> bread_count++
                    4 -> water_count++
                    5 -> sobakas_count++
                    else -> print("\nОшибка!")
                }
            }
            "sell" -> {
                when(product)
                {
                    1 -> if(koka_count>0){koka_count--}
                    2 -> if(milk_count>0){milk_count--}
                    3 -> if(bread_count>0){bread_count--}
                    4 -> if(water_count>0){water_count--}
                    5 -> if(sobakas_count>0){sobakas_count--}
                    else -> print("\nОшибка!")



                }




                Money = Money + product_price;println("Ваш счет: $Money$")
            }
            "scan" -> {
                print(
                    "\nВыберите продукт:\n" +
                            "1.Кока-Коли\n" +
                            "2.Молоко\n" +
                            "3.Хлеб\n" +
                            "4.Вода\n" +
                            "5.Собакас\n"
                ); print("Выберите продукт: ");
                product = readLine()!!.toInt();
                var koka = 56
                var milk = 50
                var bread = 23
                var water = 19
                var sobakas = 115

                when (product) {
                    1 -> {
                        koka = (40..64).random();print("\nКока-Коли: $koka$\n");product_price = koka;print("Ваш банк: $Money$")
                    }
                    2 -> {
                        milk = (35..70).random();print("\nМолоко: $milk$\n");product_price = milk;print("Ваш банк: $Money$")
                    }
                    3 -> {
                        bread = (15..30).random();print("\nХлеб: $bread$\n");product_price = bread;print("Ваш банк: $Money$")
                    }
                    4 -> {
                        water = (8..22).random();print("\nВода: $water$\n");product_price = water;print("Ваш банк: $Money$")
                    }
                    5 -> {
                        sobakas = (80..150).random();print("\nСобакас: $sobakas$\n");product_price = sobakas;print("Ваш банк: $Money$")
                    }
                    else -> print("\nОшибка!")
                }
            }
            else -> print("Ошибка!")

        }

    }
}




