

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SingleCircleMVC1 extends Application {
	
	 private Button jbtController = new Button("Show Controller");
	 private Button jbtView = new Button("Show View");
	 private CircleModel1 model = new CircleModel1();

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane flp= new FlowPane();
		Scene scene =new Scene(flp,250,40);
		flp.getChildren().add(jbtController);
		flp.getChildren().add(jbtView);
		flp.setAlignment(Pos.CENTER);
		flp.setHgap(10);
		flp.setVgap(10);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SingleCircleMVC1");
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.show();
		jbtController.setOnAction(e->{
			Stage controllerStage =new Stage();
			CircleController1 circleCon1=new CircleController1();
			Scene controllerScene =new Scene(circleCon1);
			circleCon1.setModel(model);			
			controllerStage.setScene(controllerScene);
			controllerStage.setTitle("Controller Circle 1");
			controllerStage.setAlwaysOnTop(true);
			controllerStage.show();
			
		});
		jbtView.setOnAction(e->{
			Stage viewStage =new Stage();
			CircleView1 circleview =new CircleView1();
			Scene viewScene =new Scene(circleview,250,250);
			circleview.setModel(model);
			viewStage.setScene(viewScene);
			viewStage.setTitle("view number 1");
			viewStage.setAlwaysOnTop(true);
			viewStage.show();
			
			
		});

		
	}
	
	public static void main(String[]args){
		launch(args);
	}
	
	


	
	

	

}
