package by.bsuir.Shaliov.ppvis.laba2.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum Departments {
    // здесь всё норм, смотри - здесь 6 объектов и можно сделать следующее. Это пример чтобы лучше понял энамы
    ИИТ("Кафедра Интеллектуальныых информационных технологий"),
    ИТАС(),
    СУ(),
    ТОЭ,
    РС,
    ИР;

    private String name;

    //ничего не поменялось
    Departments() {
    }

    // а вот так - немного меняется
    Departments(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
