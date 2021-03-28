package gameTypes;

public enum SupportedTypes {
    TEXASHOLDEM (1),
    OMAHA (2),
    FIVECARD (3),
    ROYAL (4);

    private final int typeId;

    SupportedTypes(int typeId) {
        this.typeId = typeId;
    }

    public void printType() {
        System.out.println(typeId + ". " + this.toString());
    }

    public int getId() {
        return typeId;
    }
}
