package oving9;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
	
	private ArrayList<ListListener> lyttere = new ArrayList<ListListener>();
	
	
	public void addListListener(ListListener lytter){
		if (!lyttere.contains(lytter)) {
			lyttere.add(lytter);			
		}
	}
	
	public void removeListListener(ListListener lytter){
		lyttere.remove(lytter);
	}
	
	protected void fireListChanged(int index1, int index2){
		for (int i = 0; i < lyttere.size(); i++) {
			lyttere.get(i).listChanged(this, index1, index2);			
		}
	}
	
	/**
	 * The getList method returns a non-specialized List. The list must be the actual list that is observed. The method is abstract and hence must be implemented by (non-abstract) subclasses. ObservableList must use this method in its implementation if the size, addElement and removeElement methods.
	 * @return non-specialized List
	 */
	
	protected abstract List getList();
	
	
	public int size(){
		return this.getList().size();
	}
	
	protected void addElement(int index, Object obj){
		this.getList().add(index, obj);
		fireListChanged(index, (size()-1));
	}
	
	protected void removeElement(int index){
		this.getList().remove(index);
		fireListChanged(index, size());
	}
	
	
	
	

}
