package src.com.BTO.Model;
import src.com.BTO.Model.Enums.RoomType;

public class Unit {
	// variables
	private RoomType roomType;
	private int sellingPrice;
	private int unitCount;
	
	public Unit(RoomType room, int count, int price) {
		roomType = room;
        unitCount = count;
		sellingPrice = price;
		
	}
	
	// setters
	public RoomType getRoomType() { return roomType; }
	public int getSellingPrice() { return sellingPrice; }
	public int getUnitCount() { return unitCount; }
	
	// getters
	public void setRoomType(RoomType newRoomType) { roomType = newRoomType; }
	public void setSellingPrice(int newSellPrice) { sellingPrice = newSellPrice; }
	public void setUnitCount(int newCount) { unitCount = newCount; }
	
	@Override
    public String toString() {
        return "Unit [roomType=" + roomType.name() 
        		+ ", sellingPrice=$" + sellingPrice 
        		+ ", unitCount=" + unitCount 
        		+ "]";
    }
}
