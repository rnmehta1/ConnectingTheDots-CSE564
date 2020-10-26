/*
Author: Ria Mehta
File Version: 1.0
Time required: 5 hours
*/
interface Subject {
    void notifyAllObservers();

    void register(Observer o);

    void remove(Observer o);
}
