package lab1.Book;

// Определение класса Publisher для хранения информации об издательствах.
class Publisher {
    private String name; // Название издательства
    private String city; // Город издательства

    // Конструктор класса Publisher для инициализации названия и города издательства.
    public Publisher(String name, String city) {
        setName(name);
        setCity(city);
    }

    // Геттеры для получения названия и города издательства.
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    // Сеттеры для установки названия и города издательства с проверкой на пустую ссылку.
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя издательства не может быть пустым");
        }
    }

    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("Город издательства не может быть пустым");
        }
    }
}

// Определение класса Book для хранения информации о книгах.
class Book {
    private String title; // Название книги
    private Publisher publisher; // Издательство книги
    private int year; // Год издания
    private String[] authors; // Массив авторов книги

    // Конструкторы класса Book для инициализации книги.
    // Конструктор для инициализации книги с названием, годом и издательством (без авторов).
    public Book(String title, int year, Publisher publisher) {
        setTitle(title);
        setYear(year);
        setPublisher(publisher);
    }

    // Конструктор для инициализации книги с названием, одним автором, годом и издательством.
    public Book(String title, String author, int year, Publisher publisher) {
        this(title, year, publisher);
        setAuthors(new String[]{author});
    }

    // Конструктор для инициализации книги с названием, списком авторов, годом и издательством.
    public Book(String title, String[] authors, int year, Publisher publisher) {
        this(title, year, publisher);
        setAuthors(authors);
    }

    // Геттеры для получения названия, издательства, года издания и авторов книги.
    public String getTitle() {
        return title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getAuthorCount() {
        return authors == null ? 0 : authors.length;
    }

    public String getAuthor(int index) {
        // Проверяем, что массив авторов не является пустым, и индекс находится в допустимом диапазоне.
        if (authors != null && index >= 0 && index < authors.length) {
            return authors[index];
        } else {
            throw new IllegalArgumentException("Некорректный индекс автора");
        }
    }

    // Сеттеры для установки названия, издательства, года издания и авторов книги с проверкой на корректность данных.
    // Сеттер для установки названия книги.
    public void setTitle(String title) {
        // Проверяем, что переданное название не является пустой ссылкой и не является пустой строкой.
        if (title != null && !title.isEmpty()) {
            // Если название валидно, устанавливаем его для книги.
            this.title = title;
        } else {
            // Если название не валидно, выбрасываем исключение с сообщением об ошибке.
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
    }

    // Сеттер для установки издательства книги.
    public void setPublisher(Publisher publisher) {
        // Проверяем, что переданное издательство не является пустой ссылкой.
        if (publisher != null) {
            // Если издательство валидно, устанавливаем его для книги.
            this.publisher = publisher;
        } else {
            // Если издательство не валидно, выбрасываем исключение с сообщением об ошибке.
            throw new IllegalArgumentException("Издательство не может быть пустой ссылкой");
        }
    }

    // Сеттер для установки года издания книги.
    public void setYear(int year) {
        // Проверяем, что год издания больше нуля.
        if (year > 0) {
            // Если год валиден, устанавливаем его для книги.
            this.year = year;
        } else {
            // Если год не валиден, выбрасываем исключение с сообщением об ошибке.
            throw new IllegalArgumentException("Год издания должен быть больше нуля");
        }
    }

    // Сеттер для установки массива авторов книги.
    public void setAuthors(String[] authors) {
        // Проверяем, что переданный массив авторов не является пустой ссылкой.
        if (authors != null) {
            // Проверяем, что массив авторов не содержит пустых ссылок.
            for (String author : authors) {
                if (author == null) {
                    // Если обнаружена пустая ссылка в массиве, выбрасываем исключение с сообщением об ошибке.
                    throw new IllegalArgumentException("Массив авторов не должен содержать пустых ссылок");
                }
            }
            // Если массив авторов валиден, устанавливаем его для книги.
            this.authors = authors;
        }
    }

    // Метод для печати информации о книге, включая название, авторов (если есть), издательство и год издания.
    public void print() {
        System.out.println("Название: " + title);
        if (authors != null && authors.length > 0) {
            System.out.print("Автор(ы): ");
            for (int i = 0; i < authors.length; i++) {
                System.out.print(authors[i]);
                if (i < authors.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("Издательство: " + publisher.getName());
        System.out.println("Город: " + publisher.getCity());
        System.out.println("Год издания: " + year);
        System.out.println();
    }

    // Статический метод для печати информации о всех книгах в массиве.
    public static void printAll(Book[] books) {
        for (Book book : books) {
            book.print();
        }
    }
}