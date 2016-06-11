package by.bsuir.Shaliov.ppvis.laba2.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum Facultyes {
    ФИТУ("информационных технологий и управления"),
    ФРЭ("радиотехники и электроники"),
    ФКП("компьютерного проектирования");

    private String name;

    Facultyes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
