package unitconverter;

public enum UnitType {
    LENGTH("Length"),
    TEMPERATURE("Temperature"),
    AREA("Area"),
    VOLUME("Volume"),
    WEIGHT("Weight"),
    TIME("Time");

    private String name;

    private UnitType (String n){
        this.name = n;
    }

    public String GetName(){
        return name;
    }
}
