
import enums.Gender;
import enums.Location;
import models.*;
import models.Car;

public class Main {
    public static void main(String[] args) {
        Car teacherCar = new Car("Toyota");
        Car employeeCar = new Car("Ford");

        Student student = new Student("John", "Doe", 20, Gender.MALE, Location.KIEV, "Computer Science", 2, "KPI");
        Teacher teacher = new Teacher("Jane", "Smith", 35, Gender.FEMALE, Location.ZHYTOMYR, "Mathematics", "ZHNU", teacherCar);
        Employee employee = new Employee("Mike", "Brown", 40, Gender.MALE, Location.VINNYTSYA, "Google", "Engineer", employeeCar);

        student.getOccupation();
        student.sayFullName();
        student.sayAge();
        student.sayLocation();
        student.sayGender();
        System.out.println(student.getFullInfo());

        teacher.getOccupation();
        teacher.sayFullName();
        System.out.println(teacher.getFullInfo());
        teacherCar.engineIsRunning();

        employee.getOccupation();
        employee.sayFullName();
        System.out.println(employee.getFullInfo());
        employeeCar.engineIsRunning();

        if (teacher instanceof Person) {
            System.out.println("Teacher is a Person.");
        }

        Student.showCounter();
        Teacher.showCounter();
        Employee.showCounter();
    }
}
