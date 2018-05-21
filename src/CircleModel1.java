

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CircleModel1 {

	private DoubleProperty radiusProperty = new SimpleDoubleProperty(20);
	private ObjectProperty<Color> colorProperty=new SimpleObjectProperty<>(Color.BLACK);
	private BooleanProperty filledProperty=new SimpleBooleanProperty();
	private ArrayList<EventHandler<myActinEvents>> eventList=new ArrayList<>();

	public double getRadius() {
		return radiusProperty.get();
	}

	public void setRadius(double radius) {
		radiusProperty.set(radius);
		
		 // Notify the listener for the change on radius
	    processEvent(
	      new myActinEvents(this, null, "radius"));

	}

	public boolean isFilled() {
		return filledProperty.get();
	}

	public void setFilled(boolean filled) {
		filledProperty.set(filled);
		 // Notify the listener for the change on filled
	    processEvent(
	      new myActinEvents(this,null, "filled"));
	}

	public Paint getColor() {
		return colorProperty.get();
	}

	public void setColor(Color color) {
		colorProperty.set(color);
		  // Notify the listener for the change on color
	    processEvent(new myActinEvents(this, null, "color"));
	}
	
	  /** Register an action event listener */
	  public synchronized void addListener(EventHandler<myActinEvents> l)
	  { if (eventList == null)
		  eventList = new ArrayList<EventHandler<myActinEvents>>();
	  eventList.add(l);
	  }
	  /** Remove an action event listener */
	  public synchronized void removeListener(EventHandler<myActinEvents> l)
	  { if (eventList != null && eventList.contains(l))
		  eventList.remove(l);
	  }
	
	  private void processEvent(myActinEvents e)
	  { 
	    System.out.println("size of actionListenerList is: " 
	      + eventList.size());
	    synchronized (this)
	    { if (eventList == null) return;
	    }
	    for (int i = 0; i < eventList.size(); i++)
	    { EventHandler<myActinEvents> listevent = eventList.get(i);
	      System.out.println("event is: " + e.getObStringComm()); 
	      listevent.handle(e);;
	    }
	  }

}
