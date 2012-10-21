package oving9;

public interface ListListener {
	
	/**
	 * The method listChanged, that is called when the ObservableList changes. 
	 * It has receives three arguments: the ObservableList that has changed, the lowest index that has changed and the highest index that has changed. Note that both indices can be greater or equal to the list's size, since they may refer to indices that existed before the change, but not after. E.g. if the last element of the ObservableList is removed, both indices will be equal to the list's size.
	 * @param Liste med observat¿rer
	 * @param laveste index
	 * @param h¿yeste index
	 */
	
	public void listChanged(ObservableList ol, int lowestIndex, int highestIndex);

}
