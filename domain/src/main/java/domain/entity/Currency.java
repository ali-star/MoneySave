package domain.entity;

public enum Currency {

    UNKNOWN("UNKNOWN"), IRR("IRR"), IRT("IRT");

    private final String value;

    Currency(String value) {
        this.value = value;
    }

    public static Currency getBuValue(String value) {
        Currency[] values = values();
        for (int i =0; i < value.length(); i++) {
            if (values[i].value.equals(value))
                return values[i];
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return value;
    }
}
