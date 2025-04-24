package src.com.BTO.Service.Filter;

import java.util.ArrayList;

public interface IFilterGeneral<T> {
	public ArrayList<T> filter(ArrayList<T> items);
	default void setCondition(String cond) {};
}
