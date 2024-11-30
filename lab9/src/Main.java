import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {

//        task2();
        try {
//            task3();
            task4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public static void task2(){
         String data = """
            Іванов Іван, 35 років, Менеджер, 10 років досвіду, м. Київ, 
            ivanov@gmail.com, +380671234567, Дата народження: 20.05.1988
            Петров Петро, 28 років, Програміст, 5 років досвіду, м. Харків, 
            petrov@ukr.net, +380503334455, Дата народження: 15.02.1995
            Сидорова Марія, 42 роки, HR, 15 років досвіду, м. Львів, 
            sidorova@mail.ua, +380931112233, Дата народження: 03.11.1981
            """;

         System.out.println("Телефони:");
         Pattern phonePattern = Pattern.compile("\\+380\\d{9}");
         Matcher phoneMatcher = phonePattern.matcher(data);
         while (phoneMatcher.find()) {
             System.out.println(phoneMatcher.group());
         }

         System.out.println("\nЕмайли:");
         Pattern emailPattern = Pattern.compile("[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}");
         Matcher emailMatcher = emailPattern.matcher(data);
         while (emailMatcher.find()) {
             System.out.println(emailMatcher.group());
         }

         System.out.println("\nЗмінені дати народження:");
         Pattern datePattern = Pattern.compile("\\b(\\d{2})\\.(\\d{2})\\.(\\d{4})\\b");
         Matcher dateMatcher = datePattern.matcher(data);
         String updatedData = dateMatcher.replaceAll("$3-$2-$1");
         System.out.println(updatedData);

         System.out.println("\nЗмінені посади:");
         String updatedPositions = updatedData.replace("Менеджер", "Директор")
                 .replace("HR", "Рекрутер");
         System.out.println(updatedPositions);
     }


     public static void task3() throws Exception{
         Class<MyClass> classObj1 = MyClass.class;
         Class<?> classObj2 = MyClass.class;
         Class<?> classObj3 = Class.forName("MyClass");

         System.out.println("Fields:");
         for (Field field : classObj1.getDeclaredFields()) {
             System.out.println(" - " + field.getName() + " (type: " + field.getType().getName() + ")");
         }

         System.out.println("\nMethods:");
         for (Method method : classObj1.getDeclaredMethods()) {
             System.out.print(" - " + method.getName() + "(");
             Class<?>[] paramTypes = method.getParameterTypes();
             for (int i = 0; i < paramTypes.length; i++) {
                 System.out.print(paramTypes[i].getName());
                 if (i < paramTypes.length - 1) System.out.print(", ");
             }
             System.out.println(") -> " + method.getReturnType().getName());
         }

         System.out.println("\nConstructors:");
         for (Constructor<?> constructor : classObj1.getDeclaredConstructors()) {
             System.out.print(" - " + constructor.getName() + "(");
             Class<?>[] paramTypes = constructor.getParameterTypes();
             for (int i = 0; i < paramTypes.length; i++) {
                 System.out.print(paramTypes[i].getName());
                 if (i < paramTypes.length - 1) System.out.print(", ");
             }
             System.out.println(")");
         }

         Constructor<MyClass> constructor = classObj1.getConstructor(String.class, int.class);
         MyClass myInstance = constructor.newInstance("Hello", 99);

         Method publicMethod = classObj1.getMethod("publicMethod");
         publicMethod.invoke(myInstance);

         Field privateField = classObj1.getDeclaredField("privateField");
         privateField.setAccessible(true);
         privateField.set(myInstance, 123);
         System.out.println("\nUpdated privateField: " + privateField.get(myInstance));

         Method privateMethod = classObj1.getDeclaredMethod("privateMethod", String.class);
         privateMethod.setAccessible(true);
         privateMethod.invoke(myInstance, "Hello from Reflection!");
     }


     public static void task4() throws Exception {
         // 1. Отримання анотації з класу
         Class<AnnotatedClass> clazz = AnnotatedClass.class;
         if (clazz.isAnnotationPresent(MyAnnotation.class)) {
             MyAnnotation classAnnotation = clazz.getAnnotation(MyAnnotation.class);
             System.out.println("Class Annotation: value = " + classAnnotation.value() +
                     ", version = " + classAnnotation.version());
         }

         // 2. Отримання анотації з методу
         Method method = clazz.getMethod("annotatedMethod");
         if (method.isAnnotationPresent(MyAnnotation.class)) {
             MyAnnotation methodAnnotation = method.getAnnotation(MyAnnotation.class);
             System.out.println("Method Annotation: value = " + methodAnnotation.value() +
                     ", version = " + methodAnnotation.version());
         }

         // 3. Виклик методу
         AnnotatedClass obj = new AnnotatedClass();
         method.invoke(obj);
     }

}