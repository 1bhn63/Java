import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        greetUser();
    }

    public static void greetUser() {
        System.out.println("Добро пожаловать!");
        System.out.println("Выберите программу:");
        System.out.println("1. Приветствие с пользователем");
        System.out.println("2. Ввод персональных данных");
        System.out.println("3. Проверка возраста");
        System.out.println("4. Нахождение площади, периметра и радиуса окружности");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                greet();
                break;
            case 2:
                inputPersonalData();
                break;
            case 3:
                checkAge();
                break;
            case 4:
                calculateGeometry();
                break;
            default:
                System.out.println("Ошибка: некорректный выбор программы.");
                break;
        }
    }

    public static void greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name + "!");
    }

    public static void inputPersonalData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите вашу дату рождения (в формате ДД.ММ.ГГГГ): ");
        String birthDateInput = scanner.nextLine();

        // Преобразование введенной даты рождения в объект LocalDate
        LocalDate birthDate = LocalDate.parse(birthDateInput, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate currentDate = LocalDate.now();

        System.out.println("Ваши персональные данные:");
        System.out.println("Имя: " + name);
        System.out.println("Дата рождения: " + birthDate);
        System.out.println("Возраст: " + calculateAge(birthDate, currentDate));
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    public static void checkAge() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вашу дату рождения (в формате ДД.ММ.ГГГГ): ");
        String birthDateInput = scanner.nextLine();

        LocalDate birthDate = LocalDate.parse(birthDateInput, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate currentDate = LocalDate.now();

        int age = calculateAge(birthDate, currentDate);

        if (age < 18) {
            System.out.println("Вы несовершеннолетний");
        } else {
            System.out.println("Вы совершеннолетний");
        }
    }

    public static void calculateGeometry() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите фигуру:");
        System.out.println("1. Круг");
        System.out.println("2. Квадрат");
        System.out.println("3. Прямоугольник");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateCircle();
                break;
            case 2:
                calculateSquare();
                break;
            case 3:
                calculateRectangle();
                break;
            default:
                System.out.println("Ошибка: некорректный выбор фигуры.");
                break;
        }
    }

    public static void calculateCircle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус окружности: ");
        double radius = scanner.nextDouble();

        double perimeter = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2);

        System.out.println("Периметр окружности: " + perimeter);
        System.out.println("Площадь окружности: " + area);
        System.out.println("Радиус окружности: " + radius);
    }

    public static void calculateSquare() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину стороны квадрата: ");
        double side = scanner.nextDouble();

        double perimeter = 4 * side;
        double area = Math.pow(side, 2);

        System.out.println("Периметр квадрата: " + perimeter);
        System.out.println("Площадь квадрата: " + area);
        System.out.println("Длина стороны квадрата: " + side);
    }

    public static void calculateRectangle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ширину прямоугольника: ");
        double width = scanner.nextDouble();

        System.out.print("Введите высоту прямоугольника: ");
        double height = scanner.nextDouble();

        double perimeter = 2 * (width + height);
        double area = width * height;

        System.out.println("Периметр прямоугольника: " + perimeter);
        System.out.println("Площадь прямоугольника: " + area);
        System.out.println("Ширина прямоугольника: " + width);
        System.out.println("Высота прямоугольника: " + height);
    }
}