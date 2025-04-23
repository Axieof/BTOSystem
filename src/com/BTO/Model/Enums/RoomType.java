package src.com.BTO.Model.Enums;

public enum RoomType {
    TWOROOM("2-Room"),
    THREEROOM("3-Room"),
    FOURROOM("4-Room"),
    FIVEROOM("5-Room");

    private final String label;

    RoomType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static RoomType fromString(String input) {
        for (RoomType rt : RoomType.values()) {
            if (rt.label.equalsIgnoreCase(input.trim())) {
                return rt;
            }
        }
        throw new IllegalArgumentException("Unknown RoomType: " + input);
    }

    @Override
    public String toString() {
        return label;
    }
}
