package src.com.BTO.Service.Filter;

import java.util.ArrayList;

import src.com.BTO.Model.Application;

public interface IFilterApplication extends IFilterGeneral<Application>{
	public ArrayList<Application> filter(ArrayList<Application> items);
	default void setCondition(String cond) {};
}
