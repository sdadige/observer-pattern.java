// Observer pattern -- Structural example
 // @since JDK 5.0
 import java.util.ArrayList;


 abstract class flight {
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer observer) {
       observers.add(observer);
    }
    public void detach(Observer observer) {
       observers.remove(observer);
    }
    public void notifyObservers() {
       for (Observer o : observers)    
          o.update();
   }
 }

 class ConcreteFlight extends flight {
  
  private String flightStatus;

  public String getflightStatus() {
    return flightStatus;
  }
  public void setFlightStatus(String value) {
    flightStatus = value;
  }
 }
  
 abstract class Observer {
  
   abstract public void update();
 }

 class ConcreteObserver extends Observer {

  private String name;
  private String observerState;
  private ConcreteFlight flight;
 

  public ConcreteObserver(ConcreteFlight flight, String name) 
  {
     this.flight = flight;
     this.name = name;
     
  }

  public void update() {
     observerState = flight.getflightStatus();
     System.out.printf("Observer %s's new state is %s\n", name, observerState);
  }
 }

 public class Client {
   public static void main(String[] args) {
      
      ConcreteFlight s = new ConcreteFlight();
      s.attach(new ConcreteObserver(s, "A"));
      s.attach(new ConcreteObserver(s, "B"));
      s.attach(new ConcreteObserver(s, "C"));

      
      s.setFlightStatus("flight status");
      s.notifyObservers();
   }
 }
