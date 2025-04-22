package src.com.BTO.Service.Filter;
import java.util.ArrayList;

import src.com.BTO.Model.Project;

public interface IFilterViewProject{
	public ArrayList<Project> filter(ArrayList<Project> projects);
	default void setCondition(String cond) {};
}
