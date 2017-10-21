package labs;

public class Country {
    private String name;
    private String codeName;

    public Country(){}

    public Country(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!name.equals(country.name)) return false;
        return codeName.equals(country.codeName);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + codeName.hashCode();
        return result;
    }
}
