
import javafx.collections.FXCollections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CircleController1 extends GridPane {

	private CircleModel1 model;


	private TextField jtfRadius = new TextField();
	private ComboBox<Boolean> cbFjcboFilledill =
			new ComboBox<>(FXCollections.observableArrayList(false, true));
	private ColorPicker piker = new ColorPicker();

	public CircleController1() {
		setPadding(new Insets(20));
		setHgap(10);
		setVgap(10);
		setAlignment(Pos.CENTER_LEFT);
		piker.setValue(Color.BLACK);
		cbFjcboFilledill.getSelectionModel().selectFirst();
		add(new Label("radius"), 0, 0);
		add(new Label("filled"), 0, 1);
		add(new Label("color"), 0, 2);
		add(jtfRadius, 1, 0);
		add(cbFjcboFilledill, 1, 1);
		add(piker, 1, 2);
		cbFjcboFilledill.setValue(false);

		jtfRadius.setPrefWidth(100);
		cbFjcboFilledill.setPrefWidth(100);
		piker.setPrefWidth(100);
		jtfRadius.setOnAction(e -> setRadiusController());
		cbFjcboFilledill.setOnAction(e -> setFilledController());
		piker.setOnAction(e->setColorController());

	}

	public void setRadiusController() {
		model.setRadius(Double.parseDouble(jtfRadius.getText()));
	}

	public void setFilledController() {
		model.setFilled(cbFjcboFilledill.getValue());
	}

	public void setColorController() {
		model.setColor(piker.getValue());
	}
	public CircleModel1 getModel() {
		return model;
	}

	public void setModel(CircleModel1 model) {
		this.model = model;
	}

}
