package infopanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTBackgroundImage;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.MTTextField;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.gestureAction.DefaultArcballAction;
import org.mt4j.input.gestureAction.DefaultDragAction;
import org.mt4j.input.gestureAction.DefaultLassoAction;
import org.mt4j.input.gestureAction.DefaultPanAction;
import org.mt4j.input.gestureAction.DefaultRotateAction;
import org.mt4j.input.gestureAction.DefaultScaleAction;
import org.mt4j.input.gestureAction.DefaultZoomAction;
import org.mt4j.input.gestureAction.InertiaDragAction;
import org.mt4j.input.gestureAction.TapAndHoldVisualizer;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.arcballProcessor.ArcballProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.lassoProcessor.LassoProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.panProcessor.PanProcessorTwoFingers;
import org.mt4j.input.inputProcessors.componentProcessors.rotateProcessor.RotateProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.scaleProcessor.ScaleProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapAndHoldProcessor.TapAndHoldEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapAndHoldProcessor.TapAndHoldProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.zoomProcessor.ZoomProcessor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.sceneManagement.Iscene;
import org.mt4j.sceneManagement.transition.BlendTransition;
import org.mt4j.sceneManagement.transition.FadeTransition;
import org.mt4j.sceneManagement.transition.SlideTransition;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.opengl.GLFBO;

import processing.core.PImage;
		
	
public class bussiness extends AbstractScene {
		private MTApplication app;
		private Iscene development;
		private Iscene design;
		private Iscene technology;
		private Iscene integration;
		private Iscene bussiness5;
		
		public bussiness(final MTApplication mtApplication, String name) {
			super(mtApplication, name);
			this.app = mtApplication;
			this.registerGlobalInputProcessor(new CursorTracer(app, this));
			MTBackgroundImage background = new MTBackgroundImage(mtApplication, mtApplication.loadImage("buscom.jpg") , true);
			this.getCanvas().addChild(background);
			
			MTColor white = new MTColor(255,255,255);
			MTColor black = new MTColor(0,0,0);
			MTColor kleurbol1 = new MTColor(255, 51, 51, 125);
			MTColor kleurbol2 = new MTColor(60, 146, 48, 125);
			MTColor kleurbol3 = new MTColor(0, 102, 204, 125);
			MTColor kleurbol4 = new MTColor(191, 21, 165, 125);
			MTColor kleurbol5 = new MTColor(204, 153, 0, 125);
			
			MTColor textAreaColor = new MTColor(50,100,150,0);
			
			IFont font = FontManager.getInstance().createFont(app, "HYPE.ttf", 40, white, white);
			IFont inhoudfont = FontManager.getInstance().createFont(app, "HYPE.ttf", 17, black, black);

			//Tap gesture
			MTEllipse circle = new MTEllipse(app, new Vector3D((mtApplication.width/5)*0 + 35, 50), 30, 30);
			circle.setFillColor(kleurbol1);
			circle.setNoStroke(true);
			this.clearAllGestures(circle);
			getCanvas().addChild(circle);
			final MTTextArea tap1 = new MTTextArea(mtApplication, font);
			tap1.setFillColor(textAreaColor);
			tap1.setStrokeColor(textAreaColor);
			tap1.setText("DEVELOPMENT");
			this.clearAllGestures(tap1);
			tap1.registerInputProcessor(new TapProcessor(app));
			tap1.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						MTColor white = new MTColor(10,100,50);
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							app.pushScene();
							if (development == null){
								development = new development(app, "Scene 1");
								//Add the scene to the mt application
								app.addScene(development);
							}
							//Do the scene change
							app.changeScene(development);
							break;
							}
					default: break;
				}
					return false;			
			}
			});
			getCanvas().addChild(tap1);
			tap1.setAnchor(PositionAnchor.UPPER_LEFT);
			tap1.setPositionGlobal(new Vector3D((mtApplication.width/5)*0,30,0));
			
			//Tap and Hold gesture
			final MTTextArea fifthpage2 = new MTTextArea(mtApplication, font);
			fifthpage2.setFillColor(textAreaColor);
			fifthpage2.setStrokeColor(textAreaColor);
			fifthpage2.setText("NEXT");
			this.clearAllGestures(fifthpage2);
			fifthpage2.registerInputProcessor(new TapAndHoldProcessor(app, 2000));
			fifthpage2.addGestureListener(TapAndHoldProcessor.class, new TapAndHoldVisualizer(app, getCanvas()));
			fifthpage2.addGestureListener(TapAndHoldProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {
					TapAndHoldEvent th = (TapAndHoldEvent)ge;
					switch (th.getId()) {
					case TapAndHoldEvent.GESTURE_DETECTED:
						break;
					case TapAndHoldEvent.GESTURE_UPDATED:
						break;
					case TapAndHoldEvent.GESTURE_ENDED:
						if (th.isHoldComplete()){
							app.pushScene();
							if (bussiness5 == null){ 
								bussiness5 = new bussiness2(app, "Scene 55"); //Maak een tweede scene aan voor de vijfde pijler.
								//Add the scene to the mt application
								app.addScene(bussiness5);
							}
							//Do the scene change
							app.changeScene(bussiness5);
							break;	
						}
					default: break;
					}
					return false;
				}
			});
			this.getCanvas().addChild(fifthpage2);
			fifthpage2.setAnchor(PositionAnchor.UPPER_LEFT);
			fifthpage2.setPositionGlobal(new Vector3D(500,500,0));
				
			MTEllipse circle2 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*1 + 35, 50), 30, 30);
			circle2.setFillColor(kleurbol2);
			circle2.setNoStroke(true);
			getCanvas().addChild(circle2);
			final MTTextArea tap2 = new MTTextArea(mtApplication, font);
			tap2.setFillColor(textAreaColor);
			tap2.setStrokeColor(textAreaColor);
			tap2.setText("DESIGN");
			this.clearAllGestures(tap2);
			tap2.registerInputProcessor(new TapProcessor(app));
			tap2.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						MTColor white = new MTColor(10,100,50);
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							app.pushScene();
							if (design == null){
								design = new design(app, "Scene 2");
								//Add the scene to the mt application
								app.addScene(design);
							}
							//Do the scene change
							app.changeScene(design);
							break;
							}
					default: break;
				}
					return false;
					
			}
			});
			getCanvas().addChild(tap2);
			tap2.setAnchor(PositionAnchor.UPPER_LEFT);
			tap2.setPositionGlobal(new Vector3D((mtApplication.width/5)*1,30,0));
			
			MTEllipse circle3 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*2 + 35, 50), 30, 30);
			circle3.setFillColor(kleurbol3);
			circle3.setNoStroke(true);
			getCanvas().addChild(circle3);
			final MTTextArea tap3 = new MTTextArea(mtApplication, font);
			tap3.setFillColor(textAreaColor);
			tap3.setStrokeColor(textAreaColor);
			tap3.setText("TECHNOLOGY");
			this.clearAllGestures(tap3);
			tap3.registerInputProcessor(new TapProcessor(app));
			tap3.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						MTColor white = new MTColor(10,100,50);
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							app.pushScene();
							if (technology == null){
								technology = new technology(app, "Scene 3");
								//Add the scene to the mt application
								app.addScene(technology);
							}
							//Do the scene change
							app.changeScene(technology);
							break;
							}
					default: break;
				}
					return false;			
			}
			});
			getCanvas().addChild(tap3);
			tap3.setAnchor(PositionAnchor.UPPER_LEFT);
			tap3.setPositionGlobal(new Vector3D((mtApplication.width/5)*2,30,0));
			
			MTEllipse circle4 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*3 + 35, 50), 30, 30);
			circle4.setFillColor(kleurbol4);
			circle4.setNoStroke(true);
			getCanvas().addChild(circle4);
			final MTTextArea tap4 = new MTTextArea(mtApplication, font);
			tap4.setFillColor(textAreaColor);
			tap4.setStrokeColor(textAreaColor);
			tap4.setText("INTEGRATION PROJECT");
			this.clearAllGestures(tap4);
			tap4.registerInputProcessor(new TapProcessor(app));
			tap4.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						MTColor white = new MTColor(10,100,50);
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							app.pushScene();
							if (integration == null){
								integration = new integration(app, "Scene 4");
								//Add the scene to the mt application
								app.addScene(integration);
							}
							//Do the scene change
							app.changeScene(integration);
							break;
							}
					default: break;
				}
					return false;				
			}
			});
			getCanvas().addChild(tap4);
			tap4.setAnchor(PositionAnchor.UPPER_LEFT);
			tap4.setPositionGlobal(new Vector3D((mtApplication.width/5)*3,30,0));
			
			MTEllipse circle5 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*4 + 35, 50), 30, 30);
			circle5.setFillColor(kleurbol5);
			circle5.setNoStroke(true);
			getCanvas().addChild(circle5);
			final MTTextArea tap5 = new MTTextArea(mtApplication, font);
			tap5.setFillColor(textAreaColor);
			tap5.setStrokeColor(textAreaColor);
			tap5.setText("BUSINESS COMMUNICATION");
			this.clearAllGestures(tap5);
			tap5.registerInputProcessor(new TapProcessor(app));
			getCanvas().addChild(tap5);
			tap5.setAnchor(PositionAnchor.UPPER_LEFT);
			tap5.setPositionGlobal(new Vector3D((mtApplication.width/5)*4,30,0));
			
			//Textarea
			final MTTextArea tekstinhoud = new MTTextArea(300, 150, 700, 300, inhoudfont, mtApplication); 
			tekstinhoud.setNoFill(true);
			tekstinhoud.setNoStroke(true);
			tekstinhoud.setText("COMMUNICATION SKILLS                                                                                                                                          "
								+"IN THESE COURSES, THE STUDENTS WILL LEARN HOW TO COMMUNICATE PROFESSIONALY, IN MULTIPLE LANGUAGES.                                                                        "
								+ "LANGUAGES:                                                                    "
								+ "   DUTCH, FRENCH AND ENGLISH                                                                                                                                   "
								+ "SOFTWARE:                                                                    "
								+ "    MICROSOFT OFFICE WORD, MICROSOFT OFFICE EXCEL, MICROSOFT OFFICE POWERPOINT, GOOGLE DRIVE                                                                                   "
								+ "COURSES:                                                                     "
								+ "    BUSINESS COMMUNICATION SKILLS, FRENCH, ENGLISH, COPYRIGHT AND MEDIARIGHTS                                                                                                  "
								+ "TEACHERS:                                                                    "
								+ "    HERMAN GILLAERTS"
					
					);
			this.clearAllGestures(tekstinhoud);
			this.getCanvas().addChild(tekstinhoud);
								
			PImage loadedImage = app.loadImage("buscom1.png");
			MTRectangle loadedrectangle = new MTRectangle(loadedImage, app);
			getCanvas().addChild(loadedrectangle);
			loadedrectangle.setPositionGlobal(new Vector3D(1200,300,0));
			loadedrectangle.setNoStroke(true);
			this.clearAllGestures(loadedrectangle);
			
			//Set a scene transition - Flip transition only available using opengl supporting the FBO extenstion
			if (MT4jSettings.getInstance().isOpenGlMode() && GLFBO.isSupported(app))
				this.setTransition(new FadeTransition(app, 700));
			else{
				this.setTransition(new FadeTransition(app, 700));
			}
								
		}

		
		private void clearAllGestures(MTComponent comp){
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

