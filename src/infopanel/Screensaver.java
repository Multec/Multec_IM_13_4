package infopanel;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTBackgroundImage;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.*;

public class Screensaver extends AbstractScene {
	
	protected Hoofdmenu hoofdmenu;

	public Screensaver(final MTApplication mtApplication, String name) {
		super(mtApplication, name);
		// TODO Auto-generated constructor stub
		
		
		
		
		//Create background
		MTBackgroundImage background = new MTBackgroundImage(mtApplication, mtApplication.loadImage("bgscreensaver.png") , true);
		
		//Set background
		this.getCanvas().addChild(background);
		
		// Create images needed
		PImage multec = mtApplication.loadImage("multecButton.png");
		MTRectangle multecRectangle = new MTRectangle(multec, mtApplication);
		multecRectangle.setPositionGlobal(new Vector3D(425, mtApplication.height/2, 0));
		
		PImage digx = mtApplication.loadImage("digx.png");
		MTRectangle digxRectangle = new MTRectangle(digx, mtApplication);
		digxRectangle.setPositionGlobal(new Vector3D(mtApplication.width-(mtApplication.width/3)+ (mtApplication.width/35), mtApplication.height/2,0));
		
		PImage stripeL = mtApplication.loadImage("stripeL.png");
		MTRectangle stripeLRectangle = new MTRectangle(stripeL, mtApplication);
		stripeLRectangle.setPositionGlobal(new Vector3D(75, (mtApplication.height/2)-100));
		
		PImage stripeR = mtApplication.loadImage("stripeR.png");
		MTRectangle stripeRRectangle = new MTRectangle(stripeR, mtApplication);
		stripeRRectangle.setPositionGlobal(new Vector3D(mtApplication.width-(mtApplication.width/3)+350 + (mtApplication.width/35), mtApplication.height/2 + 100));
		
		// put  image to scene
		
		this.getCanvas().addChild(multecRectangle);
		multecRectangle.setNoStroke(true);
		
		
		this.getCanvas().addChild(digxRectangle);
		digxRectangle.setNoStroke(true);
		
		this.getCanvas().addChild(stripeLRectangle);
		stripeLRectangle.setNoStroke(true);
		
		this.getCanvas().addChild(stripeRRectangle);
		stripeRRectangle.setNoStroke(true);
		
		this.clearAllGestures(stripeRRectangle);
		this.clearAllGestures(stripeLRectangle);
		this.clearAllGestures(digxRectangle);
		this.clearAllGestures(multecRectangle);
		// set images to button
			
		MTImageButton goToMultec = new MTImageButton(multec, mtApplication);
		MTImageButton goToDigx = new MTImageButton(digx, mtApplication);
		
		multecRectangle.registerInputProcessor(new TapProcessor(mtApplication));
		multecRectangle.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			public boolean processGestureEvent(MTGestureEvent ge) {
				TapEvent te = (TapEvent)ge;
				switch (te.getId()) {
				case MTGestureEvent.GESTURE_DETECTED:
					break;
				case MTGestureEvent.GESTURE_UPDATED:
					break;
				case MTGestureEvent.GESTURE_ENDED:
					if (te.isTapped()){
						//Save the current scene on the scene stack before changing
						mtApplication.pushScene();
						if (hoofdmenu == null){
							hoofdmenu = new Hoofdmenu(mtApplication, "Hoofdmenu");
							mtApplication.addScene(hoofdmenu);
						}
						//Do the scene change
						mtApplication.changeScene(hoofdmenu);
						
					break;
				}
				return false;
			}
				return false;
		}
		});
		
		// ClearAll gestures
		

		
	}
		
		
		
		
		private void clearAllGestures(MTRectangle comp){
			comp.unregisterAllInputProcessors();
			comp.removeAllGestureEventListeners();
		}
		
	
	
	
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		
	}

}
