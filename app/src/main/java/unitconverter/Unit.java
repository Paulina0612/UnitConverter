package unitconverter;

public enum Unit {
    // LENGTH
    METER(UnitType.LENGTH, 1, 0, "m"),
    KILOMETER(UnitType.LENGTH, 0.001, 0, "km"),
    CENTIMETER(UnitType.LENGTH, 100, 0, "cm"),
    MILIMETER(UnitType.LENGTH, 1000, 0, "mm"),
    MICROMETER(UnitType.LENGTH, 1000000, 0, "um"),
    NANOMETER(UnitType.LENGTH, 1000000000, 0, "nm"),

    // TEMPERATURE
    CELSIUS(UnitType.TEMPERATURE, 1, 0, "°C"),
    KELVIN(UnitType.TEMPERATURE, 1, -273.15, "K"),

    // AREA
    SQUARE_METER(UnitType.AREA, 1, 0, "m^2"),
    SQUARE_KILOMETER(UnitType.AREA, 0.000001, 0, "km^2"),
    SQUARE_CENTIMETER(UnitType.AREA, 100000, 0, "cm^2"),
    SQUARE_MILIMETER(UnitType.AREA, 10000000, 0, "mm^2"),
    HECTARE(UnitType.AREA, 0.0001, 0, "ha"),

    // // VOLUME
    CUBIC_METER(UnitType.VOLUME, 1, 0, "m^3"),
    CUBIC_KILOMETER(UnitType.VOLUME, 0.000000001, 0, "km^3"),
    CUBIC_CENTIMETER(UnitType.VOLUME, 1000000, 0, "cm^3"),
    CUBIC_MILIMETER(UnitType.VOLUME, 1000000000, 0, "mm^3"),
    LITER(UnitType.VOLUME, 1000, 0, "l"),
    MILILITER(UnitType.VOLUME, 1000000, 0, "ml"),

    // WEIGHT
    GRAM(UnitType.WEIGHT, 1000, 0, "g"),
    KILOGRAM(UnitType.WEIGHT, 1, 0, "kg"),
    MILIGRAM(UnitType.WEIGHT, 1000000, 0, "mg"),

    // TIME
    SECOND(UnitType.TIME, 86400, 0, "s"),
    MILISECOND(UnitType.TIME, 86400000, 0, "ms"),
    MINUTE(UnitType.TIME, 1440, 0, "min"),
    HOUR(UnitType.TIME, 24, 0, "hours"),
    DAY(UnitType.TIME, 1, 0, "days");

    private UnitType type;
    private double factor;
    private double toAddtoBasicValue;
    private String shortage;

    private Unit(UnitType t, double f, double v, String s){
        this.type = t;
        this.factor = f;
        this.toAddtoBasicValue = v;
        this.shortage = s;
    }

    public UnitType GetUnitType(){ return type; }
    public double GetFactor(){ return factor; }
    public double GetValueToAddtoBasicValue(){ return toAddtoBasicValue; }
    public String GetShortage(){ return shortage; }
    
    public Unit GetBasicValue(UnitType unitType){ 
        switch (unitType) {
            case LENGTH: return METER; 
            case TEMPERATURE: return KELVIN; 
            case AREA: return SQUARE_METER; 
            case VOLUME: return CUBIC_METER;
            case WEIGHT: return KILOGRAM; 
            case TIME: return DAY; 
            default: return null; 
        }
    }

    public static int GetAmountOfUnits(UnitType type){
        int value=0;
        int amount = Unit.values().length;

        for(int i=0; i<amount; i++)
            if(Unit.values()[i].GetUnitType() == type)
                value++;

        return value;
    }

    public static double Convert(double value, Unit inUnit, Unit outUnit){
        value=value/inUnit.GetFactor();
        value=value*outUnit.GetFactor();
        value=value+inUnit.GetValueToAddtoBasicValue();
        value=value-outUnit.GetValueToAddtoBasicValue();

        return value;
    } 

    public static Unit GetUnit(String shortage){
        for(int i=0; i<Unit.values().length; i++)
            if(shortage == Unit.values()[i].shortage)
                return Unit.values()[i];

        return null; 
    }
}
