package roulette;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	List<Class> betSubs;
	
	public Factory(){
		betSubs = new ArrayList<Class>();
		betSubs.add(OddEven.class);
		betSubs.add(RedBlack.class);
		betSubs.add(ThreeConsecutive.class);
	}
	
	public void printName(){
		for(int i=0; i<betSubs.size(); i++){
			System.out.println(betSubs.get(i).getName());
		}
	}
	
	public Class getClass(int index){
		return betSubs.get(index);
	}
}
