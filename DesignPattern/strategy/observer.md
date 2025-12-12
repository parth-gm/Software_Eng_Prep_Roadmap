Wheather station -> { TV Display Observer, Mobile Display Observer}


DisplayObserver 

interface Observable {
	List<DisplayObserver> listOfObserver
	
	add(DisplayObserver obj)
	remove(DisplayObserver obj)
	notify()
	setTemprature();
			
}

class TemperatureObservable implements Observable{


}


class CricketObservable implements Observable{


}

interface DisplayObserver{
	update();
}


MobileDisplayObserver implements DisplayObserver{

	Observable observable;
	MobileDisplayObserver(Observable observable){
		this.observable = observable;
	}
	
	
	
}


TVDisplayObserver implements DisplayObserver{


}