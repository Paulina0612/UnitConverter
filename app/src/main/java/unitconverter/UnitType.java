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

    public static UnitType GetUnitType(String name){
        for(int i=0; i<UnitType.values().length; i++)
            if(name == UnitType.values()[i].name)
                return UnitType.values()[i];

        return null; 
    }
}
