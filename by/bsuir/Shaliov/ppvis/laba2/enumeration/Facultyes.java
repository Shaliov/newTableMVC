package by.bsuir.Shaliov.ppvis.laba2.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum Facultyes {
    ФИТУ("Факультет информационных технологий и управления"),
    ФРЭ("Факультет радиотехники и электроники"),
    ФКП("Факультет компьютерного проектирования");

    private String name;

    private Facultyes() {}

    Facultyes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
