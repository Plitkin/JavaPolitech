package lab1.Country;

import java.text.DecimalFormat;

public class Country {
    private String name;
    private double area;
    private double population;
    private String capitalName;
    private double capitalPopulation;

    // Конструктор, принимающий значения всех атрибутов
    public Country(String name, double area, double population, String capitalName, double capitalPopulation) {
        // Проверка на корректность входных данных с использованием сеттеров
        setName(name);
        setArea(area);
        setPopulation(population);
        setCapital(capitalName, capitalPopulation);
    }

    // Конструктор для городов-государств
    public Country(String name, double area, double population) {
        // Проверка на корректность входных данных с использованием сеттеров
        setName(name);
        setArea(area);
        setPopulation(population);
        resetCapital();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPopulation() {
        return population;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public double getCapitalPopulation() {
        return capitalPopulation;
    }

    // Геттер для плотности населения
    public String getPopulationDensity() {
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(population / area);
    }

    // Сеттеры
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название страны не может быть пустым");
        }
        this.name = name;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть больше нуля");
        }
        this.area = area;
    }

    public void setPopulation(double population) {
        if (population <= 0) {
            throw new IllegalArgumentException("Население должно быть больше нуля");
        }
        this.population = population;
    }

    // Метод для задания/сброса данных о столице
    public void setCapital(String capitalName, double capitalPopulation) {
        if (capitalPopulation <= 0 || capitalName == null || capitalName.isEmpty()) {
            throw new IllegalArgumentException("Неверные данные для столицы");
        }
        this.capitalName = capitalName;
        this.capitalPopulation = capitalPopulation;
    }

    public void resetCapital() {
        this.capitalName = "";
        this.capitalPopulation = 0;
    }

    // Метод для печати информации о стране
    public void print() {
        DecimalFormat format = new DecimalFormat("0.0"); // Создаем форматтер для чисел с одним знаком после запятой
        String formattedArea = format.format(area / 1e6) + " млн. кв. км."; // Форматируем площадь в миллионах кв. км.
        String formattedPopulation = format.format(population / 1e6) + " млн. чел."; // Форматируем население в миллионах человек
        String formattedCapitalPopulation = format.format(capitalPopulation / 1e6) + " млн чел."; // Форматируем население столицы в миллионах человек

        String areaString = area < 1e6 ? format.format(area / 1e3) + " тыс. кв. км." : formattedArea; // Форматируем площадь в тысячах кв. км., если она меньше миллиона, иначе оставляем форматированную площадь в миллионах
        String populationString = population < 1e6 ? format.format(population / 1e3) + " тыс. чел." : formattedPopulation; // Форматируем население в тысячах человек, если оно меньше миллиона, иначе оставляем форматированное население в миллионах

        System.out.println("Название страны: " + name); // Выводим название страны
        System.out.println("Площадь: " + areaString); // Выводим площадь
        System.out.println("Население: " + populationString); // Выводим население

        if (!capitalName.isEmpty()) {
            String capitalPopulationString = capitalPopulation < 1e6 ? format.format(capitalPopulation / 1e3) + " тыс. чел." : formattedCapitalPopulation; // Форматируем население столицы в тысячах человек, если оно меньше миллиона, иначе оставляем форматированное население столицы в миллионах

            System.out.println("Столица: " + capitalName); // Выводим название столицы
            System.out.println("Население столицы: " + capitalPopulationString); // Выводим население столицы
        }
        System.out.println("Плотность населения: " + getPopulationDensity() + " чел./кв. км"); // Выводим плотность населения
    }

    // Статический метод для печати информации о массиве стран
    public static void printAll(Country[] countries) {
        for (Country country : countries) {
            country.print();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Country[] countries = new Country[5];
        countries[0] = new Country("Russia", 17.1e6, 146.7e6, "Moscow", 12.6e6);
        countries[1] = new Country("Finland", 338e3, 5.5e6, "Helsinki", 655e3);
        countries[2] = new Country("France", 643.8e3, 67.8e6, "Paris", 2.1e6);
        countries[3] = new Country("Andorra", 467e3, 85.4e3, "Andorra la Vella", 22.6e3);
        countries[4] = new Country("Singapore", 725e3, 5.7e6);

        Country.printAll(countries);
    }
}