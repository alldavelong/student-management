package uebung.uebungspringgemischt.controller;

import uebung.uebungspringgemischt.entity.Course;

public class TooManyGradesException extends Throwable {
    @Override
    public String getMessage() {
        return "Die maximale Anzahl von " + Course.MAX_GRADES + " Antritten ist bereits erreicht";
    }
}
