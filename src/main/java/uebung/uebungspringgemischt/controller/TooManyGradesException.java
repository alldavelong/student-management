package uebung.uebungspringgemischt.controller;

public class TooManyGradesException extends Throwable {
    @Override
    public String getMessage() {
        return "Die maximale Anzahl von Antritten ist bereits erreicht";
    }
}
