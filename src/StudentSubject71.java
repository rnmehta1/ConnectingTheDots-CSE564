/*
Author: Ria Mehta
File Version: 1.5
Time required: 5 hours
*/
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

class StudentSubject71 implements Subject71 {
    private List<Observer> observers = new LinkedList<>();
    private int state;

    public int getState() {
        return state;
    }

	/*
	 * public void setState(int state) { this.state = state; notifyAllObservers(); }
	 */

    @Override
    public void notifyAllObservers() {

        for (Observer o : observers)
            o.update(null, o);

    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

}
