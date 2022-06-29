package uebung.uebungspringgemischt.controller;

import uebung.uebungspringgemischt.entity.Grade;

public class TooManyGradesException extends Throwable {
    @Override
    public String getMessage() {
        return "Die maximale Anzahl von " + Grade.MAX_GRADES_PER_COURSE + " Antritten ist bereits erreicht";
    }
}
