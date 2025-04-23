package src.com.BTO.Service;

import src.com.BTO.Model.Unit;
import src.com.BTO.Model.Enums.RoomType;

import java.util.ArrayList;
import java.util.List;

public class UnitService {
    
    public static List<Unit> createUnitList(String[] columns, int startIndex, int endIndex) {
        List<Unit> units = new ArrayList<>();
        
        for (int i = startIndex; i < endIndex; i += 3) { 
            String roomTypeStr = columns[i].trim();
            
            int unitCount = Integer.parseInt(columns[i + 1].trim());
            int price = Integer.parseInt(columns[i + 2].trim()); 
        
            RoomType roomType = RoomType.fromString(roomTypeStr);
            
            units.add(new Unit(roomType, unitCount, price));
        }
    
        return units;
    }
    
    
    
}
