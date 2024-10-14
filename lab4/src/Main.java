import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {
    public static void main(String[] args) {
//        this.task2();
//        task3();
//        task4();
//        task5();
        task6();

    }

    public void task2(){
        String str = "I learn Java!!!";

        System.out.println("Останній символ: " + str.charAt(str.length() - 1));

        System.out.println("Закінчується на '!!!': " + str.endsWith("!!!"));

        System.out.println("Починається з 'I learn ': " + str.startsWith("I learn "));

        System.out.println("Містить 'Java': " + str.contains("Java"));

        System.out.println("Позиція 'Java': " + str.indexOf("Java"));

        System.out.println("Замінити 'а' на 'о': " + str.replace('a', 'o'));

        System.out.println("Верхній регістр: " + str.toUpperCase());

        System.out.println("Нижній регістр: " + str.toLowerCase());

        System.out.println("Вирізати 'Java': " + str.replace("Java", ""));
    }
    public static void task3(){
        int num1 = 4;
        int num2 = 36;

        StringBuilder sb = new StringBuilder();

        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println(sb.toString());

        sb.setLength(0);

        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(sb.toString());

        sb.setLength(0);

        sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        sb.deleteCharAt(sb.indexOf("="));
        sb.insert(sb.indexOf(" ") + 2, "рівно ");
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        int equalsIndex = sb.indexOf("=");
        sb.replace(equalsIndex, equalsIndex + 1, "рівно");
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        sb.reverse();
        System.out.println("Оборот: " + sb.toString());

        System.out.println("Довжина: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
    public static void task4() {
        Formatter formatter = new Formatter();

        String dateTime = "28.03.2019 13:25:12";
        String[] products = {
                "Джинси", "Спідниця", "Краватка",
                "Сорочка", "Футболка", "Куртка",
                "Шорти", "Сукня", "Шарф", "Чоботи"
        };
        String[] categories = {
                "Жіночий одяг", "Жіночий одяг", "Чоловічий одяг",
                "Чоловічий одяг", "Жіночий одяг", "Чоловічий одяг",
                "Чоловічий одяг", "Жіночий одяг", "Жіночий одяг", "Чоловічий одяг"
        };
        double[] prices = {1500.78, 1000.56, 500.78, 800.00, 400.50, 1200.00, 600.00, 900.00, 300.00, 1000.00};

        double total = 0;

        formatter.format("Дата та час покупки: %s%n", dateTime);
        formatter.format("========================================================%n");
        formatter.format("%-3s %-20s %-15s %-10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("========================================================%n");

        for (int i = 0; i < products.length; i++) {
            formatter.format("%-3d %-20s %-15s %-10.2f ₴%n", i + 1, products[i], categories[i], prices[i]);
            total += prices[i];
        }

        formatter.format("Разом: %.2f ₴%n", total);
        formatter.format("========================================================%n");

        System.out.println(formatter);
        formatter.close();
    }

    public static void task5() {
        Locale currentLocale = Locale.forLanguageTag("de-DE");
//        Locale currentLocale = Locale.forLanguageTag("ua-UA");
//        Locale currentLocale = Locale.forLanguageTag("en-US");
        ResourceBundle bundle = ResourceBundle.getBundle("resources.data", currentLocale);

        String dateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());

        String[] products = {
                "Джинси", "Спідниця", "Краватка", "Сорочка", "Футболка",
                "Куртка", "Шорти", "Сукня", "Шарф", "Чоботи"
        };
        String[] categories = {
                "Жіночий одяг", "Жіночий одяг", "Чоловічий одяг",
                "Чоловічий одяг", "Жіночий одяг", "Чоловічий одяг",
                "Чоловічий одяг", "Жіночий одяг", "Жіночий одяг", "Чоловічий одяг"
        };
        double[] prices = {1500.78, 1000.56, 500.78, 800.00, 400.50,
                1200.00, 600.00, 900.00, 300.00, 1000.00};

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(currentLocale);
        double total = 0;

        System.out.println(bundle.getString("purchase.date").replace("{0}", dateTime));
        System.out.println(bundle.getString("receipt.header"));
        System.out.printf("%s%n", bundle.getString("receipt.table.header"));
        System.out.println(bundle.getString("receipt.footer"));

        for (int i = 0; i < products.length; i++) {
            System.out.printf("%-3d %-20s %-15s %-10s%n", i + 1, products[i], categories[i], currencyFormat.format(prices[i]));
            total += prices[i];
        }

        System.out.println(bundle.getString("receipt.footer"));
        System.out.printf("%s%n", bundle.getString("total").replace("{0}", currencyFormat.format(total)));
    }
     public static void task6() {
         LocalDateTime labStartDate = LocalDateTime.of(2024, 10, 14, 10, 0);

         System.out.println("День тижня: " + labStartDate.getDayOfWeek());
         System.out.println("День у році: " + labStartDate.getDayOfYear());
         System.out.println("Місяць: " + labStartDate.getMonth());
         System.out.println("Рік: " + labStartDate.getYear());
         System.out.println("Години: " + labStartDate.getHour());
         System.out.println("Хвилини: " + labStartDate.getMinute());
         System.out.println("Секунди: " + labStartDate.getSecond());

         boolean isLeapYear = labStartDate.toLocalDate().isLeapYear();
         System.out.println("Рік високосний: " + isLeapYear);

         LocalDateTime currentDateTime = LocalDateTime.now();
         System.out.println("Поточний час: " + currentDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

         if (currentDateTime.isAfter(labStartDate)) {
             System.out.println("Поточна дата після дати лабораторної роботи.");
         } else if (currentDateTime.isBefore(labStartDate)) {
             System.out.println("Поточна дата перед датою лабораторної роботи.");
         } else {
             System.out.println("Поточна дата є такою ж, як дата лабораторної роботи.");
         }

         LocalDateTime modifiedDate = labStartDate.plusDays(5).minusHours(2).withMinute(30);
         System.out.println("Змінена дата та час: " + modifiedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

     }
}




