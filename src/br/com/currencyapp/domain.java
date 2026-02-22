package br.com.currencyapp;

public enum domain {

    USD("Dólar Americano"),
    EUR("Euro"),
    GBP("Libra Esterlina"),
    JPY("Iene Japonês"),
    ARS("Peso Argentino"),
    CHF("Franco Suíço");

    private final String label;

    domain(String label) {
        this.label = label;
    }

    public String code() {
        return this.name();
    }

    public String label() {
        return label;
    }
}