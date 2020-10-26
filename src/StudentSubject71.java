/*
Author: Ria Mehta
File Version: 1.5
Time required: 5 hours
*/
import java.util.LinkedList;
import java.util.List;

class StudentSubject71 implements Subject71 {
    private List<Observer71> observers = new LinkedList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {

        for (Observer71 o : observers)
            o.update();

    }

    @Override
    public void register(Observer71 o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer71 o) {
        observers.remove(o);
    }

}
