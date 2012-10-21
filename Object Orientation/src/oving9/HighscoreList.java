package oving9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HighscoreList extends ObservableList implements Iterable<Comparable>  {
	
	ArrayList<Comparable> scores = new ArrayList<Comparable>();
	int maxSize;
	
	public HighscoreList(int maximumSize){
		this.maxSize = maximumSize;
	}
	
	public void addResult(Comparable comp){
		int start = 0;
		int end = 0;
		boolean hasBeenAdded = false;
		
		for (int i = 0; i < this.size(); i++) {
			if(scores.get(i).compareTo(comp)>0){
				if(this.getList().size()<this.maxSize){
					this.scores.add(i, comp);
					hasBeenAdded = true;
					start = i;
					end = this.size()-1;
					this.fireListChanged(start, end);
					break;
				}
				else if(this.getList().size()>=this.maxSize){
					this.scores.remove(size()-1);
					this.scores.add(i, comp);
					hasBeenAdded = true;
					start = i;
					end = this.size()-1;
					this.fireListChanged(start, end);
					break;
				}
			}
		}
		if(!hasBeenAdded){
			if(this.getList().size()<this.maxSize){
				this.scores.add(this.size(), comp);
				start = this.size()-1;
				end = this.size()-1;
				this.fireListChanged(start, end);				
			}
		}
	}
	
	@Override
	public Iterator<Comparable> iterator() {
		return scores.iterator();
	}


	@Override
	public List getList() {
		return scores;
	}
	

}
