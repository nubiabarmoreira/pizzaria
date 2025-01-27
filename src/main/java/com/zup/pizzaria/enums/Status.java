package com.zup.pizzaria.enums;

public enum Status {

    PENDENTE(1),
    EM_PREPARO(2),
    FINALIZADO(3);

    private int code;

    private Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if (code == value.getCode()) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status code");
    }
}
