package com.example.admindesktop.model.value;

public class Telefone {

    private String telefone;

    public Telefone() {
    }

    public Telefone(String telefone) {
        String somenteNumeros = telefone != null ? telefone.replaceAll("\\D", "") : null;

        if (!isValid(somenteNumeros)) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = somenteNumeros;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String somenteNumeros = telefone != null ? telefone.replaceAll("\\D", "") : null;

        if (!isValid(somenteNumeros)) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = somenteNumeros;
    }

    private boolean isValid(String telefone) {
        return telefone != null && telefone.matches("\\d{10,11}");
    }

    @Override
    public String toString() {
        return telefone;
    }
}
