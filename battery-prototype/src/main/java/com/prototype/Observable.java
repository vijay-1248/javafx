package com.prototype;

public interface Observable {

	void notifyObservers();

	void register(Observer observer);

	void unregister(Observer observer);
}
