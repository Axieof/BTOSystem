package src.com.BTO.Service.Filter;

import java.util.ArrayList;
import src.com.BTO.Model.Project;

public interface IFilterProject extends IFilterGeneral<Project>{
	public ArrayList<Project> filter(ArrayList<Project> items);
	default void setCondition(String cond) {};
}
