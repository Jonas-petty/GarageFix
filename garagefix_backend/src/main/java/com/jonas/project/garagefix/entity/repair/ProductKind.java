package com.jonas.project.garagefix.entity.repair;

public enum ProductKind {
    TELEVISAO("televisao"),
    SOM("som"),
    CELULAR("celular"),
    OUTROS("outros");

    public final String value;

    private ProductKind(String value) {
        this.value = value;
    }
}
