interface Subject {
    void notifyAllObservers();

    void register(Observer o);

    void remove(Observer o);
}
