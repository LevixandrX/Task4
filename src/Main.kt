fun main() {
    while (true) {
        println("Введите два числа и операцию в формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
        println("Допустимые операции: / (деление), * (умножение), + (сложение), - (вычитание)")

        val input = readlnOrNull()?.trim()

        val parts = input?.split(" ")
        if (parts == null || parts.size != 3) {
            println("Ошибка: Введите данные в правильном формате: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
            continue
        }

        val number1 = parts[0].toDoubleOrNull()
        val number2 = parts[1].toDoubleOrNull()
        val operation = parts[2]

        if (number1 == null || number2 == null || operation !in setOf("/", "*", "+", "-")) {
            println("Ошибка: Введите корректные числа и операцию. Операция должна быть одной из: /, *, +, -")
            continue
        }

        val result = when (operation) {
            "/" -> if (number2 != 0.0) number1 / number2 else {
                println("Ошибка: Деление на ноль.")
                continue
            }
            "*" -> number1 * number2
            "+" -> number1 + number2
            "-" -> number1 - number2
            else -> {
                println("Ошибка: Неправильная операция.")
                continue
            }
        }

        println("Результат: $result")
        break
    }
}