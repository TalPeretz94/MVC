

import javafx.event.EventHandler;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView1 extends StackPane implements EventHandler<myActinEvents> {
	Circle circle =new Circle();
	//private static final long serialVersionUID = 1L;
	private CircleModel1 model;

	@Override
	public void handle(myActinEvents event) {
		paintOval();

	}

	/** Set a model */
	public void setModel(CircleModel1 newModel) {
		model = newModel;
/*		if (model != null)
			// Register the view as listener for the model
			
		//repaint
		 * 
*/		model.addListener(this);
		paintOval();
		getChildren().add(circle);
	}

	public CircleModel1 getModel() {
		return model;

	}
	
	public void paintOval(){
			
		 		 
		   // if (model == null) return;
		    circle.setRadius(model.getRadius());
		    circle.setStroke(model.getColor());
		    
		    
		    if(model.isFilled()){
		    	 circle.setFill(model.getColor());
		    }
		    else{
		    	circle.setFill(Color.TRANSPARENT); 
		    }
	
		
		
	}
}
