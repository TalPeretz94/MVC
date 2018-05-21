

import javafx.event.ActionEvent;

import javafx.event.EventTarget;


public class myActinEvents extends ActionEvent {




	private static final long serialVersionUID = 1L;
	private String obStringComm;
	 
	
	public myActinEvents(Object ob, EventTarget evt,String obString){
		super(ob,evt);
		this.obStringComm=obString;
		
	}
	
	
	public String getObStringComm() {
		return obStringComm;
	}


	public void setObStringComm(String obStringComm) {
		this.obStringComm = obStringComm;
	}
	
	
	
	
	

}
