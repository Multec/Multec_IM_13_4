package infopanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;

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
		private Iscene bussiness;	
		private Iscene bussiness2;
		private int pageCounter = 0;
		
		public bussiness(final MTApplication mtApplication, String name) {
			super(mtApplication, name);
			this.app = mtApplication;
			this.registerGlobalInputProcessor(new CursorTracer(app, this));
			MTBackgroundImage background = new MTBackgroundImage(mtApplication, mtApplication.loadImage("buscom.jpg") , true);
			this.getCanvas().addChild(background);
			
			MTColor white = new MTColor(255,255,255);
			MTColor black = new MTColor(0,0,0);
			MTColor kleurbol1 = new MTColor(248, 76, 76, 125);
			MTColor kleurbol2 = new MTColor(93,160,83, 125);
			MTColor kleurbol3 = new MTColor(65, 135, 206, 125);
			MTColor kleurbol4 = new MTColor(134, 62, 62, 125);
			MTColor kleurbol5 = new MTColor(206, 181, 104, 125);
			MTColor grey = new MTColor(184,184,184);
			
			MTColor textAreaColor = new MTColor(50,100,150,0);
			
			IFont font = FontManager.getInstance().createFont(app, "HYPE.ttf", 40, white, white);
			IFont inhoudfont = FontManager.getInstance().createFont(app, "HYPE.ttf", 28, black, black);
			IFont arrowFont = FontManager.getInstance().createFont(app, "HYPE.ttf", 28, grey, grey);
			
			//arrows+arrowText
			PImage arrowL = mtApplication.loadImage("arrowL.png");
			PImage arrowR = mtApplication.loadImage("arrowR.png");
			MTRectangle arrowLHolder = new MTRectangle (arrowL, app);
			MTRectangle arrowRHolder = new MTRectangle (arrowR, app);
			arrowLHolder.setPositionGlobal(new Vector3D(40, app.height/2 - 8));
			arrowLHolder.setNoStroke(true);
			this.getCanvas().addChild(arrowLHolder);
			clearAllGestures(arrowLHolder);
			arrowRHolder.setPositionGlobal(new Vector3D(app.width-40,app.height/2 - 8));
			arrowRHolder.setNoStroke(true);
			this.getCanvas().addChild(arrowRHolder);
			clearAllGestures(arrowRHolder);
			final MTTextArea arrowLTxt = new MTTextArea(55, app.height/2-25, 220, 300, arrowFont, app); 
			arrowLTxt.setNoStroke(true);
			arrowLTxt.setNoFill(true);
			final MTTextArea arrowRTxt = new MTTextArea(app.width-277, app.height/2-25, 220, 300, arrowFont, app);
			arrowRTxt.setNoStroke(true);
			arrowRTxt.setNoFill(true);
			arrowLTxt.setText("...");
			arrowRTxt.setText("...");
			this.getCanvas().addChild(arrowLTxt);
			this.getCanvas().addChild(arrowRTxt);
			clearAllGestures(arrowRHolder);
			this.clearAllGestures(arrowLTxt);
			this.clearAllGestures(arrowRTxt);

			
			//multecLogo
			PImage multec = mtApplication.loadImage("multec_logo.png");
			MTRectangle multecHolder = new MTRectangle(multec, app);
			multecHolder.setPositionGlobal(new Vector3D(app.width-80,app.height-30,0));
			multecHolder.setNoStroke(true);
			this.getCanvas().addChild(multecHolder);
			
			//downNavigation menu
			MTEllipse specBtn = new MTEllipse(app, new Vector3D((mtApplication.width/5)*0 + 35, app.height - 40), 25, 25);
			specBtn.setFillColor(white);
			specBtn.setNoStroke(true);
			this.clearAllGestures(specBtn);
			getCanvas().addChild(specBtn);
			
			final MTTextArea specTxt = new MTTextArea(10, app.height-55, 200, 50, inhoudfont, app);
			specTxt.setFillColor(textAreaColor);
			specTxt.setStrokeColor(textAreaColor);
			specTxt.setText("SPECIALIZATIONS");
			this.clearAllGestures(specTxt);
			this.getCanvas().addChild(specTxt);
			
			MTEllipse facBtn = new MTEllipse(app, new Vector3D((mtApplication.width/5)*0 + 210, app.height-40), 25, 25);
			facBtn.setFillColor(white);
			facBtn.setNoStroke(true);
			this.clearAllGestures(facBtn);
			getCanvas().addChild(facBtn);
			
			final MTTextArea facTxt = new MTTextArea(185, app.height-55, 200, 50, inhoudfont, app);
			facTxt.setFillColor(textAreaColor);
			facTxt.setStrokeColor(textAreaColor);
			facTxt.setText("STUDENT FACILITIES");
			this.clearAllGestures(specTxt);
			this.getCanvas().addChild(facTxt);
			
			//MENU ITEMS W GESTURES
			MTEllipse circle = new MTEllipse(app, new Vector3D((mtApplication.width/5)*0 + 35, 50), 30, 30);
			circle.setFillColor(kleurbol2);
			circle.setNoStroke(true);
			this.clearAllGestures(circle);
			getCanvas().addChild(circle);
			final MTTextArea tap1 = new MTTextArea(mtApplication, font);
			tap1.setFillColor(textAreaColor);
			tap1.setStrokeColor(textAreaColor);
			tap1.setText("DESIGN");
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
							if (design == null){
								design = new design(app, "design2");
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
			getCanvas().addChild(tap1);
			tap1.setAnchor(PositionAnchor.UPPER_LEFT);
			tap1.setPositionGlobal(new Vector3D((mtApplication.width/5)*0,30,0));
			
		
			MTEllipse circle2 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*1 + 35, 50), 30, 30);
			circle2.setFillColor(kleurbol3);
			circle2.setNoStroke(true);
			getCanvas().addChild(circle2);
			final MTTextArea tap2 = new MTTextArea(mtApplication, font);
			tap2.setFillColor(textAreaColor);
			tap2.setStrokeColor(textAreaColor);
			tap2.setText("TECHNOLOGY");
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
							if (technology == null){
								technology = new technology(app, "technology");
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
			getCanvas().addChild(tap2);
			tap2.setAnchor(PositionAnchor.UPPER_LEFT);
			tap2.setPositionGlobal(new Vector3D((mtApplication.width/5)*1,30,0));
			
			MTEllipse circle3 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*2 + 35, 50), 30, 30);
			circle3.setFillColor(kleurbol5);
			circle3.setNoStroke(true);
			getCanvas().addChild(circle3);
			final MTTextArea tap3 = new MTTextArea(mtApplication, font);
			tap3.setFillColor(textAreaColor);
			tap3.setStrokeColor(textAreaColor);
			tap3.setText("BUSSINESS");
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
							if (bussiness == null){
								bussiness = new bussiness(app, "bussiness");
								//Add the scene to the mt application
								app.addScene(bussiness);
							}
							//Do the scene change
							app.changeScene(bussiness);
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
			circle4.setFillColor(kleurbol1);
			circle4.setNoStroke(true);
			getCanvas().addChild(circle4);
			final MTTextArea tap4 = new MTTextArea(mtApplication, font);
			tap4.setFillColor(textAreaColor);
			tap4.setStrokeColor(textAreaColor);
			tap4.setText("DEVELOPMENT");
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
							if (development == null){
								development = new development(app, "development");
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
			getCanvas().addChild(tap4);
			tap4.setAnchor(PositionAnchor.UPPER_LEFT);
			tap4.setPositionGlobal(new Vector3D((mtApplication.width/5)*3,30,0));
			
			MTEllipse circle5 = new MTEllipse(app, new Vector3D((mtApplication.width/5)*4 + 35, 50), 30, 30);
			circle5.setFillColor(kleurbol4);
			circle5.setNoStroke(true);
			getCanvas().addChild(circle5);
			final MTTextArea tap5 = new MTTextArea(mtApplication, font);
			tap5.setFillColor(textAreaColor);
			tap5.setStrokeColor(textAreaColor);
			tap5.setText("INTEGRATION");
			this.clearAllGestures(tap5);
			this.clearAllGestures(circle5);
			tap5.registerInputProcessor(new TapProcessor(app));
			tap5.addGestureListener(TapProcessor.class, new IGestureEventListener() {
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
								integration = new integration(app, "integration");
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
			getCanvas().addChild(tap5);
			tap5.setAnchor(PositionAnchor.UPPER_LEFT);
			tap5.setPositionGlobal(new Vector3D((mtApplication.width/5)*4,30,0));
			
			//initFonts
			IFont fontTitle = FontManager.getInstance().createFont(mtApplication, "HYPE.ttf", 
					30, 	//Font size
					new MTColor(0,0,0),  //Font fill color
					new MTColor(0,0,0));	//Font outline color
			IFont fontSubtitle = FontManager.getInstance().createFont(mtApplication, "HYPE.ttf", 
					20, 	//Font size
					new MTColor(0,0,0),  //Font fill color
					new MTColor(0,0,0));	//Font outline color
			IFont fontContent = FontManager.getInstance().createFont(mtApplication, "century.TTf", 
					12, 	//Font size
					new MTColor(0,0,0),  //Font fill color
					new MTColor(0,0,0));	//Font outline color
			
			//textAreas
			final MTTextArea title = new MTTextArea(300, 150, 700, 300, fontTitle, app); 
			final MTTextArea subtitle1 = new MTTextArea(300, 200, 700, 300, fontSubtitle, app); 
			final MTTextArea content1 = new MTTextArea(300, 220, 700, 300, fontContent, app); 
			final MTTextArea subtitle2 = new MTTextArea(300, 280, 700, 300, fontSubtitle, app); 
			final MTTextArea content2 = new MTTextArea(300, 300, 700, 300, fontContent, app); 
			final MTTextArea subtitle3 = new MTTextArea(app, fontSubtitle); 
			final MTTextArea content3 = new MTTextArea(app, fontContent);
			title.setNoStroke(true);
			title.setNoFill(true);
			subtitle1.setNoStroke(true);
			subtitle1.setNoFill(true);
			subtitle2.setNoStroke(true);
			subtitle2.setNoFill(true);
			subtitle3.setNoStroke(true);
			subtitle3.setNoFill(true);
			content1.setNoStroke(true);
			content1.setNoFill(true);
			content2.setNoStroke(true);
			content2.setNoFill(true);
			content3.setNoStroke(true);
			content3.setNoFill(true);
			
			//AddTextToTextAreas
			title.setText("BUSSINESS COMMUNICATIONS");
			subtitle1.setText("DESCRIPTION");
			subtitle2.setText("COURSES");
			content1.setText("Bussiness & Communication is divided into 2 main topics. The first is 'communication skills' where students will learn how to communicate in different languages on different media. 'Management' is the second main topic. In management, students will learn how to manage your own project properly, and you'll also learn how to start your own business.");
			content2.appendText("Bussiness & Communication: \nFrench, English, Bussiness communication skills, copyright & mediarights");
			content2.appendText("\nManagement: \nProject management, Online Marketing");
			
			
			//addTextAreas
			this.clearAllGestures(title);
			this.getCanvas().addChild(title);
			this.clearAllGestures(subtitle1);
			this.getCanvas().addChild(subtitle1);
			this.clearAllGestures(subtitle2);
			this.getCanvas().addChild(subtitle2);
			this.clearAllGestures(subtitle3);
			this.getCanvas().addChild(subtitle3);
			this.clearAllGestures(content1);
			this.getCanvas().addChild(content1);
			this.clearAllGestures(content2);
			this.getCanvas().addChild(content2);
			this.clearAllGestures(content3);
			this.getCanvas().addChild(content3);
			
								
			PImage loadedImage = app.loadImage("buscom1.png");
			MTRectangle loadedrectangle = new MTRectangle(loadedImage, app);
			getCanvas().addChild(loadedrectangle);
			loadedrectangle.setPositionGlobal(new Vector3D(450,500,0));
			loadedrectangle.setNoStroke(true);
			this.clearAllGestures(loadedrectangle);
			
			//arrowLTapGesture
			arrowLHolder.registerInputProcessor(new TapProcessor(app));
			arrowLHolder.addGestureListener(TapProcessor.class, new IGestureEventListener() {
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
							
							break;
							}
					default: break;
				}
					return false;			
			}
			});
			//arrowRTabGesture
			arrowRHolder.registerInputProcessor(new TapProcessor(app));
			arrowRHolder.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						MTColor white = new MTColor(10,100,50);
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						
					default: break;
				}
					return false;			
			}
			});
			
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

