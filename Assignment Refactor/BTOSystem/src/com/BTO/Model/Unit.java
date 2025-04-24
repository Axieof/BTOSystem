package BTO.Model;

import BTO.Enum.RoomType;

public class Unit {
    private RoomType roomType;
    private int sellingPrice;
    private int unitCount;

    public Unit(RoomType roomType, int unitCount, int sellingPrice) {
        this.roomType = roomType;
        this.unitCount = unitCount;
        this.sellingPrice = sellingPrice;
    }

    public RoomType getRoomType() { return roomType; }
    public int getSellingPrice() { return sellingPrice; }
    public int getUnitCount() { return unitCount; }

    public void setRoomType(RoomType roomType) { this.roomType = roomType; }
    public void setSellingPrice(int sellingPrice) { this.sellingPrice = sellingPrice; }
    public void setUnitCount(int unitCount) { this.unitCount = unitCount; }

    @Override
    public String toString() {
        return roomType + ": " + unitCount + " units @ $" + sellingPrice;
    }
}
