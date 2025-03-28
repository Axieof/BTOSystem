package BTOSystem;


public class Unit {
	// variables
	private RoomType roomType;
	private int sellingPrice;
	private int unitCount;
	
	// setters
	public RoomType getRoomType() { return roomType; }
	public int getSellingPrice() { return sellingPrice; }
	public int getUnitCount() { return unitCount; }
	
	// getters
	public void setRoomType(RoomType newRoomType) { roomType = newRoomType; }
	public void setSellingPrice(int newSellPrice) { sellingPrice = newSellPrice; }
	public void setUnitCount(int newCount) { unitCount = newCount; }
}