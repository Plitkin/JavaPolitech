package lab1.Book;

public class Main {
    public static void main(String[] args) {
        Publisher publisher1 = new Publisher("Проспект", "Москва");
        Publisher publisher2 = new Publisher("Питер", "Санкт-Петербург");
        Publisher publisher3 = new Publisher("БХВ", "Санкт-Петебург");
        Publisher publisher4 = new Publisher("Диалектика", "Киев");

        Book[] books = new Book[5];
        books[0] = new Book("Computer Science: основы программирования на Java, ООП, алгоритмы и структуры данных", new String[]{"Седжвик Роберт", "Уэйн Кевин"}, 2018, publisher2);
        books[1] = new Book("Разработка требований к программному обеспечению. 3-е издание, дополненное", "Вигерс Карл", 2019, publisher3);
        books[2] = new Book("Java. Полное руководство, 10-е издание", "Шилдт Герберт", 2018, publisher4);
        books[3] = new Book("C/C++. Процедурное программирование", "Полубенцева М.И.", 2017, publisher3);
        books[4] = new Book("Конституция РФ", 2020, publisher1);

        // 1. Печатаем массив
        System.out.println("Массив книг:");
        Book.printAll(books);

        // 2. Исправляем ошибку в названии города издательства "БХВ"
        publisher3.setCity("Санкт-Петербург");

        // 3. Печатаем массив ещё раз
        System.out.println("Исправленный массив книг:");
        Book.printAll(books);

        /*
        При втором вызове печати массива в консоли будет видно, что название города издательства
        "БХВ" было исправлено на "Санкт-Петербург". Это произошло потому, что объект publisher3
        был изменен, и все книги, использующие это издательство, автоматически отражают это изменение.
        */
    }
}
