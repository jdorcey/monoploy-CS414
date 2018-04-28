package monopoly.engine.game;

import java.util.ArrayList;

public class GuiStateTracker {
	private static GuiStateTracker INSTANCE = null;
	private boolean[] states;
	
	private GuiStateTracker() {
		states = new boolean[40];
		reset();
	}
	
	public static GuiStateTracker getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GuiStateTracker();
		}
		return INSTANCE;
	}
	
	public boolean stateAtIndex(int index) {
		return states[index];
	}
	
	public boolean anySelected() {
		for (int i = 0; i < states.length; i++)
			if (states[i])
				return true;
		return false;
	}
	
	public ArrayList<Integer> getSelected(){
		ArrayList<Integer> ret = new ArrayList<>();
		for(int i = 0; i < states.length; i++)
			if (states[i])
				ret.add(new Integer(i));
		reset();
		return ret;
	}
	
	public void toggleIndex(int index) {
		states[index]  = !states[index];
	}
	
	public void reset() {
		for(int i = 0; i < states.length; i++)
			states[i] = false;
	}
}
