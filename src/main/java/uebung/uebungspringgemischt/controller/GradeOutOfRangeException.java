package uebung.uebungspringgemischt.controller;

import uebung.uebungspringgemischt.entity.Grade;

public class GradeOutOfRangeException extends Throwable {
    @Override
    public String getMessage() {
        return "Es gibt nur Noten von " + Grade.LOWEST_GRADE + " bis " + Grade.HIGHEST_GRADE + ".";
    }
}
