package infopanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mt4j.MTApplication;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.sceneManagement.Iscene;
import org.mt4j.sceneManagement.transition.FadeTransition;
import org.mt4j.sceneManagement.transition.SlideTransition;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.opengl.GLFBO;

import basic.scenes.Scene3;
import processing.core.PImage;

public class Hoofdmenu extends AbstractScene {
	private MTApplication mtApp;
	protected Screensaver screensaver;

	public Hoofdmenu(MTApplication mtApplication, String name) {
		
		super(mtApplication, name);
		this.mtApp = mtApplication;
		mtApp.smooth();
		//bgColor WHITE
		this.setClearColor(new MTColor(255,255,255));
		this.registerGlobalInputProcessor(new CursorTracer(mtApp, this));
		//contentRect
		MTRectangle contentRect = new MTRectangle(0,mtApp.height/2-mtApp.height/3/2,mtApp.width,mtApp.height/3, mtApp);
		contentRect.setFillColor(new MTColor(209,209,209));
		contentRect.setNoStroke(true);
		//multecLogo
		PImage multec = mtApplication.loadImage("multec_logo.png");
		MTRectangle multecHolder = new MTRectangle(multec, mtApp);
		multecHolder.setPositionGlobal(new Vector3D(mtApp.width-100,mtApp.height-30,0));
		
		
		//circles
		MTEllipse btnDes = new MTEllipse(mtApp,new Vector3D(170,mtApp.height/2,1),35,35);
		btnDes.setFillColor(new MTColor(93,160,83));
		btnDes.setNoStroke(true);
		MTEllipse btnTec = new MTEllipse(mtApp,new Vector3D(420,mtApp.height/2,1),35,35);
		btnTec.setFillColor(new MTColor(65, 135, 206));
		btnTec.setNoStroke(true);
		MTEllipse btnBus = new MTEllipse(mtApp,new Vector3D(770,mtApp.height/2,1),35,35);
		btnBus.setFillColor(new MTColor(206, 181, 104));
		btnBus.setNoStroke(true);
		MTEllipse btnDev = new MTEllipse(mtApp,new Vector3D(1170,mtApp.height/2,1),35,35);
		btnDev.setFillColor(new MTColor(248, 76, 76));
		btnDev.setNoStroke(true);
		MTEllipse btnInt = new MTEllipse(mtApp,new Vector3D(1520,mtApp.height/2,1),35,35);
		btnInt.setFillColor(new MTColor(134, 62, 62));
		btnInt.setNoStroke(true);
		
		//textfields
		IFont fontHype = FontManager.getInstance().createFont(mtApplication, "HYPE.ttf", 
				64, 	//Font size
				new MTColor(255,255,255),  //Font fill color
				new MTColor(255,255,255));	//Font outline color
		final MTTextArea textArDes = new MTTextArea(mtApp, fontHype); 
		final MTTextArea textArTec = new MTTextArea(mtApp, fontHype); 
		final MTTextArea textArBus = new MTTextArea(mtApp, fontHype); 
		final MTTextArea textArDev = new MTTextArea(mtApp, fontHype); 
		final MTTextArea textArInt = new MTTextArea(mtApp, fontHype); 
		textArDes.setNoStroke(true);
		textArDes.setNoFill(true);
		textArTec.setNoStroke(true);
		textArTec.setNoFill(true);
		textArBus.setNoStroke(true);
		textArBus.setNoFill(true);
		textArDev.setNoStroke(true);
		textArDev.setNoFill(true);
		textArInt.setNoStroke(true);
		textArInt.setNoFill(true);
		textArDes.setText("DESIGN");
		textArTec.setText("TECHNOLOGY");
		textArBus.setText("BUSINESS COM");
		textArDev.setText("DEVELOPMENT");
		textArInt.setText("INTEGRATION");
		//Center the textfield on the screen
		textArDes.setPositionGlobal(new Vector3D(220, mtApp.height/2+5,2));
		textArTec.setPositionGlobal(new Vector3D(530, mtApp.height/2+5,2));
		textArBus.setPositionGlobal(new Vector3D(905, mtApp.height/2+5,2));
		textArDev.setPositionGlobal(new Vector3D(1290, mtApp.height/2+5,2));
		textArInt.setPositionGlobal(new Vector3D(1630, mtApp.height/2+5,2));
		
		//removeAllGestures
				this.clearAllGestures(textArDes);
				this.clearAllGestures(textArBus);
				this.clearAllGestures(textArInt);
				this.clearAllGestures(textArDev);
				this.clearAllGestures(textArTec);
				this.clearAllGestures(btnDes);
				this.clearAllGestures(btnTec);
				this.clearAllGestures(btnBus);
				this.clearAllGestures(btnInt);
				this.clearAllGestures(btnDes);
				this.clearAllGestures(multecHolder);
				this.clearAllGestures(contentRect);

		//addButtons
		
		textArDes.registerInputProcessor(new TapProcessor(mtApp));
		textArDes.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			public boolean processGestureEvent(MTGestureEvent ge) {
				TapEvent te = (TapEvent)ge;
				switch (te.getId()) {
				case MTGestureEvent.GESTURE_DETECTED:
					textArDes.setFillColor(new MTColor(220,220,220,255));
					break;
				case MTGestureEvent.GESTURE_UPDATED:
					break;
				case MTGestureEvent.GESTURE_ENDED:
					if (te.isTapped()){
						//Save the current scene on the scene stack before changing
						mtApp.pushScene();
						if (screensaver == null){
							screensaver = new Screensaver(mtApp, "screensaver");
							mtApp.addScene(screensaver);
						}
						//Do the scene change
						mtApp.changeScene(screensaver);
						
					break;
				}
				return false;
			}
				return false;
		}
		});
		
		
		this.getCanvas().addChild(textArDes);
		this.getCanvas().addChild(textArBus);
		this.getCanvas().addChild(textArTec);
		this.getCanvas().addChild(textArDev);
		this.getCanvas().addChild(textArInt);
		
		this.getCanvas().addChild(btnDes);
		this.getCanvas().addChild(btnTec);
		this.getCanvas().addChild(btnBus);
		this.getCanvas().addChild(btnDev);
		this.getCanvas().addChild(btnInt);
		this.getCanvas().addChild(contentRect);
		this.getCanvas().addChild(multecHolder);
	}
	private void clearAllGestures(MTRectangle comp) {
		comp.unregisterAllInputProcessors();
		comp.removeAllGestureEventListeners();
		
	}
	private void clearAllGestures(MTEllipse comp) {
		comp.unregisterAllInputProcessors();
		comp.removeAllGestureEventListeners();
	}
	private void clearAllGestures(MTTextArea comp) {
		comp.unregisterAllInputProcessors();
		comp.removeAllGestureEventListeners();
		
	}
	@Override
	public void init() {
	}

	@Override
	public void shutDown() {
	}

}
