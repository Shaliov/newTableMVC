package by.bsuir.Shaliov.ppvis.laba2.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum AcademicDegrees {
    кн("кандитат наук"),
    дн("доктор наук");

    private String name;

    private AcademicDegrees() {}

    AcademicDegrees(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
