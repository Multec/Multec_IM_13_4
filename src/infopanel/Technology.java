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
		
	
public class Technology extends AbstractScene {
		private MTApplication app;
		private Iscene Development;
		private Iscene Design;
		private Iscene Technology;
		private Iscene Integration;
		private Iscene Bussiness;
		private Iscene Specialization;
		private Iscene Facilities;
		private int pageCounter = 0;
		private MTEllipse smallCircle2;
		private MTEllipse smallCircle3;
		private Iscene Screensaver;
		private MTRectangle rectangleImage1;
		private MTRectangle rectangleImage2;
		
		public Technology(final MTApplication mtApplication, String name) {
			super(mtApplication, name);
			this.app = mtApplication;
			this.registerGlobalInputProcessor(new CursorTracer(app, this));
			MTBackgroundImage background = new MTBackgroundImage(mtApplication, mtApplication.loadImage("Technology.jpg") , true);
			this.getCanvas().addChild(background);
			
			MTColor white = new MTColor(255,255,255);
			MTColor black = new MTColor(0,0,0);
			MTColor kleurbol1 = new MTColor(248, 76, 76, 125);
			MTColor kleurbol2 = new MTColor(93,160,83, 125);
			MTColor kleurbol3 = new MTColor(65, 135, 206, 125);
			MTColor kleurbol4 = new MTColor(134, 62, 62, 125);
			MTColor kleurbol5 = new MTColor(206, 181, 104, 125);
			MTColor grey = new MTColor(184,184,184);
			MTColor whiteTrans = new MTColor(255,255,255, 125);
			
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
			
			clearAllGestures(arrowRHolder);
			final MTTextArea arrowLTxt = new MTTextArea(55, app.height/2-25, 220, 300, arrowFont, app); 
			arrowLTxt.setNoStroke(true);
			arrowLTxt.setNoFill(true);
			final MTTextArea arrowRTxt = new MTTextArea(app.width-277, app.height/2-25, 220, 300, arrowFont, app);
			arrowRTxt.setNoStroke(true);
			arrowRTxt.setNoFill(true);
			arrowLTxt.setText("DATA AND MEDIA");
			arrowRTxt.setText("DATA AND MEDIA");
			this.getCanvas().addChild(arrowLTxt);
			this.getCanvas().addChild(arrowRTxt);
			clearAllGestures(arrowRHolder);
			this.clearAllGestures(arrowLTxt);
			this.clearAllGestures(arrowRTxt);
			
			//contentCircleViewers
			smallCircle2 = new MTEllipse (app, new Vector3D((app.width/2 - 8), app.height - 30), 5, 5);
			smallCircle2.setFillColor(white);
			smallCircle2.setNoStroke(true);
			getCanvas().addChild(smallCircle2);
			this.clearAllGestures(smallCircle2);
			smallCircle3 = new MTEllipse (app, new Vector3D((app.width/2 + 8), app.height - 30), 5, 5);
			smallCircle3.setFillColor(whiteTrans);
			smallCircle3.setNoStroke(true);
			getCanvas().addChild(smallCircle3);
			this.clearAllGestures(smallCircle3);
			
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
			this.clearAllGestures(facTxt);
			this.getCanvas().addChild(facTxt);
			
			//multecLogo
			PImage multec = mtApplication.loadImage("multec_logo.png");
			MTRectangle multecHolder = new MTRectangle(multec, app);
			multecHolder.setPositionGlobal(new Vector3D(app.width-80,app.height-30,0));
			multecHolder.setNoStroke(true);
			this.clearAllGestures(multecHolder);
			this.getCanvas().addChild(multecHolder);
			multecHolder.registerInputProcessor(new TapProcessor(app));
			multecHolder.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							if (Screensaver == null){
								Screensaver = new Screensaver(app, "Screensaver");
								//Add the scene to the mt application
								app.addScene(Screensaver);
							}
							//Do the scene change
							app.destroySceneAfterTransition(Technology);
							System.gc();
							app.changeScene(Screensaver);
							break;
							}
					default: break;
				}
					return false;			
			}
			});

			//SUB MENU ITEM BUTTONS
			//specialization page
			specTxt.registerInputProcessor(new TapProcessor(app));
			specTxt.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							if (Specialization == null){
								Specialization = new Specialization(app, "specialization_page");
								//Add the scene to the mt application
								
								app.addScene(Specialization);
							}
							//Do the scene change
							app.destroySceneAfterTransition(Technology);
							System.gc();
							app.changeScene(Specialization);
							break;
							}
					default: break;
				}
					return false;			
			}
			});
			//facilities page
			facTxt.registerInputProcessor(new TapProcessor(app));
			facTxt.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				public boolean processGestureEvent(MTGestureEvent ge) {					
					TapEvent te = (TapEvent)ge;
					switch (te.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						break;
					case MTGestureEvent.GESTURE_ENDED:
						if (te.isTapped()){
							app.pushScene();
							if (Facilities == null){
								Facilities = new Facilities(app, "facilities_page");
								//Add the scene to the mt application
								app.addScene(Facilities);
							}
							//Do the scene change
							app.changeScene(Facilities);
							break;
							}
					default: break;
				}
					return false;			
			}
			});
			//pageCircle
			MTEllipse pCircle = new MTEllipse(app, new Vector3D(330, 167), 30, 30);
			pCircle.setFillColor(kleurbol3);
			pCircle.setNoStroke(true);
			this.clearAllGestures(pCircle);
			getCanvas().addChild(pCircle);
			//MENU ITEM Design
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
							if (Design == null){
								Design = new Design(app, "Design2");
								//Add the scene to the mt application
								app.addScene(Design);
							}
							//Do the scene change
							app.changeScene(Design);
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
							if (Technology == null){
								Technology = new Technology(app, "Technology");
								//Add the scene to the mt application
								app.addScene(Technology);
							}
							//Do the scene change
							app.changeScene(Technology);
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
			tap3.setText("BUSINESS");
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
							if (Bussiness == null){
								Bussiness = new Bussiness(app, "Bussiness");
								//Add the scene to the mt application
								app.addScene(Bussiness);
							}
							//Do the scene change

							app.changeScene(Bussiness);
							System.gc();
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
							if (Development == null){
								Development = new Development(app, "Development");
								//Add the scene to the mt application
								app.addScene(Development);
							}
							//Do the scene change
							app.changeScene(Development);
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
			this.clearAllGestures(circle5);
			this.clearAllGestures(tap5);
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
							if (Integration == null){
								Integration = new Integration(app, "Integration");
								//Add the scene to the mt application
								app.addScene(Integration);
							}
							//Do the scene change
							app.changeScene(Integration);
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
			final MTTextArea subtitle3 = new MTTextArea(300, 330, 700, 300, fontSubtitle, app); 
			final MTTextArea content3 = new MTTextArea(300, 350, 700, 300, fontContent, app); 
			final MTTextArea title2 = new MTTextArea(1100, 150, 700, 300, fontSubtitle, app);
			final MTTextArea docent1 = new MTTextArea(1050, 380, 700 ,300, fontContent, app);
			final MTTextArea docent2 = new MTTextArea(1350, 380, 700 ,300, fontContent, app);
			title2.setNoStroke(true);
			title2.setNoFill(true);
			docent1.setNoStroke(true);
			docent1.setNoFill(true);
			docent2.setNoStroke(true);
			docent2.setNoFill(true);
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
			title.setText("ELECTRONICS");
			subtitle1.setText("DESCRIPTION");
			subtitle2.setText("COURSES");
			content1.setText("In these courses, students will learn about IT and electronics, not only from a book, but also trough practice. These courses are mainly based on creativity, practice and electronics. These courses are a large part of the specialisation Art and Technology."); 
			content2.appendText("AV and IT Principles, Physical Interaction Design, Visual Performance and Installation Technology, Interactive Storytelling");
			subtitle3.setText("LANGUAGES");
			content3.setText("Arduino(Processing)");
			docent1.setText("Jan de Coster");
			
			//add projects to content
			PImage Voorbeeld1 = app.loadImage("TECH1mini.jpg"); 
			final MTRectangle RectangleImage3 = new MTRectangle(Voorbeeld1, app);
			getCanvas().addChild(RectangleImage3);
			RectangleImage3.setPositionGlobal(new Vector3D(535,685,0));
			RectangleImage3.setNoStroke(true);	
			this.clearAllGestures(RectangleImage3);
			
			PImage Voorbeeld2 = app.loadImage("TECH2mini.jpg"); 
			final MTRectangle RectangleImage4 = new MTRectangle(Voorbeeld2, app);
			getCanvas().addChild(RectangleImage4);
			RectangleImage4.setPositionGlobal(new Vector3D(970,685,0));
			RectangleImage4.setNoStroke(true);
			this.clearAllGestures(RectangleImage4);
			
			PImage Voorbeeld3 = app.loadImage("TECH3mini.jpg"); 
			final MTRectangle RectangleImage5 = new MTRectangle(Voorbeeld3, app);
			getCanvas().addChild(RectangleImage5);
			RectangleImage5.setPositionGlobal(new Vector3D(1405,685,0));
			RectangleImage5.setNoStroke(true);
			this.clearAllGestures(RectangleImage5);
			
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
			this.clearAllGestures(docent1);
			this.getCanvas().addChild(docent1);
			this.clearAllGestures(docent2);
			this.getCanvas().addChild(docent2);
			
			
			PImage Image1 = app.loadImage("Technology1.png"); 
			rectangleImage1 = new MTRectangle(Image1, app);
			getCanvas().addChild(rectangleImage1);
			rectangleImage1.setPositionGlobal(new Vector3D(1200,290,0));
			rectangleImage1.setNoStroke(true);
			this.clearAllGestures(rectangleImage1);
			
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
							if (pageCounter==0){
								getCanvas().removeChild(rectangleImage1);
								title.setText("DATA AND MEDIA");
								content1.setText("In these courses, students will learn how to generate and manage data and media. These courses are mainly focused on data management and media development.");
								content2.setText("Data management, Networked Media, New Trends, Media in Performance, New Media Devices.");
								content3.setText("MySQL");
								pageCounter = 1;
								arrowLTxt.setText("ELECTRONICS");
								arrowRTxt.setText("ELECTRONICS");
								smallCircle2.setFillColor(new MTColor(255,255,255, 125));
								smallCircle3.setFillColor(new MTColor(255,255,255));
								docent1.setText("Bert Van Rillaer");
								docent2.setText("Robbie Delaere");
								
								PImage Image1 = app.loadImage("Technology3.png"); 
								rectangleImage1 = new MTRectangle(Image1, app);
								getCanvas().addChild(rectangleImage1);
								rectangleImage1.setPositionGlobal(new Vector3D(1200,290,0));
								rectangleImage1.setNoStroke(true);
								this.clearAllGestures(rectangleImage1);
								
								PImage Image2 = app.loadImage("Technology2.png"); 
								rectangleImage2 = new MTRectangle(Image2, app);
								getCanvas().addChild(rectangleImage2);
								rectangleImage2.setPositionGlobal(new Vector3D(1500,290,0));
								rectangleImage2.setNoStroke(true);
								this.clearAllGestures(rectangleImage2);
								
								//add projects to content
								PImage Voorbeeld1 = app.loadImage("DATA1mini.jpg"); 
								final MTRectangle RectangleImage3 = new MTRectangle(Voorbeeld1, app);
								getCanvas().addChild(RectangleImage3);
								RectangleImage3.setPositionGlobal(new Vector3D(535,685,0));
								RectangleImage3.setNoStroke(true);	
								this.clearAllGestures(RectangleImage3);
								
								PImage Voorbeeld2 = app.loadImage("DATA2mini.jpg"); 
								final MTRectangle RectangleImage4 = new MTRectangle(Voorbeeld2, app);
								getCanvas().addChild(RectangleImage4);
								RectangleImage4.setPositionGlobal(new Vector3D(970,685,0));
								RectangleImage4.setNoStroke(true);
								this.clearAllGestures(RectangleImage4);
								
								PImage Voorbeeld3 = app.loadImage("DATA3mini.jpg"); 
								final MTRectangle RectangleImage5 = new MTRectangle(Voorbeeld3, app);
								getCanvas().addChild(RectangleImage5);
								RectangleImage5.setPositionGlobal(new Vector3D(1405,685,0));
								RectangleImage5.setNoStroke(true);
								this.clearAllGestures(RectangleImage5);
							}
							else if (pageCounter == 1)
							{
								getCanvas().removeChild(rectangleImage1);
								getCanvas().removeChild(rectangleImage2);
								title.setText("ELECTRONICS");
								content1.setText("In these courses, students will learn about IT and electronics, not only from a book, but also trough practice.  These courses are a large part of the specialisation Art and Technology.");
								content2.setText("AV and IT Principles, Physical Interaction Design, Visual Performance and Installation Technology, Interactive Storytelling.");
								content3.setText("Arduino(Processing)");
								pageCounter = 0;
								arrowLTxt.setText("DATA AND MEDIA");
								arrowRTxt.setText("DATA AND MEDIA");
								smallCircle2.setFillColor(new MTColor(255,255,255));
								smallCircle3.setFillColor(new MTColor(255,255,255, 125));
								docent1.setText("Jan de Coster");
								docent2.setText("");
								PImage Image1 = app.loadImage("Technology1.png"); 
								rectangleImage1 = new MTRectangle(Image1, app);
								getCanvas().addChild(rectangleImage1);
								rectangleImage1.setPositionGlobal(new Vector3D(1200,290,0));
								rectangleImage1.setNoStroke(true);
								this.clearAllGestures(rectangleImage1);	
								
								//add projects to content
								PImage Voorbeeld1 = app.loadImage("TECH1mini.jpg"); 
								final MTRectangle RectangleImage3 = new MTRectangle(Voorbeeld1, app);
								getCanvas().addChild(RectangleImage3);
								RectangleImage3.setPositionGlobal(new Vector3D(535,685,0));
								RectangleImage3.setNoStroke(true);	
								this.clearAllGestures(RectangleImage3);
								
								PImage Voorbeeld2 = app.loadImage("TECH2mini.jpg"); 
								final MTRectangle RectangleImage4 = new MTRectangle(Voorbeeld2, app);
								getCanvas().addChild(RectangleImage4);
								RectangleImage4.setPositionGlobal(new Vector3D(970,685,0));
								RectangleImage4.setNoStroke(true);
								this.clearAllGestures(RectangleImage4);
								
								PImage Voorbeeld3 = app.loadImage("TECH3mini.jpg"); 
								final MTRectangle RectangleImage5 = new MTRectangle(Voorbeeld3, app);
								getCanvas().addChild(RectangleImage5);
								RectangleImage5.setPositionGlobal(new Vector3D(1405,685,0));
								RectangleImage5.setNoStroke(true);
								this.clearAllGestures(RectangleImage5);
							}
							break;
							}
					default: break;
				}
					return false;			
			}
			private void clearAllGestures(MTRectangle comp) {
				comp.unregisterAllInputProcessors();
				comp.removeAllGestureEventListeners();	
			}
			});
			this.getCanvas().addChild(arrowRHolder);
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
						if (te.isTapped()){
							if (pageCounter==0){
								getCanvas().removeChild(rectangleImage1);
								title.setText("DATA AND MEDIA");
								content1.setText("In these courses, students will learn how to generate and manage data and media.");
								content2.setText("Data management, Networked Media, New Trends, Media in Performance, New Media Devices.");
								content3.setText("MySQL");
								pageCounter = 1;
								arrowLTxt.setText("ELECTRONICS");
								arrowRTxt.setText("ELECTRONICS");
								smallCircle2.setFillColor(new MTColor(255,255,255, 125));
								smallCircle3.setFillColor(new MTColor(255,255,255));
								docent1.setText("Bert Van Rillaer");
								docent2.setText("Robbie Delaere");
								
								PImage Image1 = app.loadImage("Technology3.png"); 
								rectangleImage1 = new MTRectangle(Image1, app);
								getCanvas().addChild(rectangleImage1);
								rectangleImage1.setPositionGlobal(new Vector3D(1200,290,0));
								rectangleImage1.setNoStroke(true);
								this.clearAllGestures(rectangleImage1);
								
								PImage Image2 = app.loadImage("Technology2.png"); 
								rectangleImage2 = new MTRectangle(Image2, app);
								getCanvas().addChild(rectangleImage2);
								rectangleImage2.setPositionGlobal(new Vector3D(1500,290,0));
								rectangleImage2.setNoStroke(true);
								this.clearAllGestures(rectangleImage2);
							}
							else if (pageCounter == 1)
							{
								getCanvas().removeChild(rectangleImage1);
								getCanvas().removeChild(rectangleImage2);
								title.setText("ELECTRONICS");
								content1.setText("In these courses, students will learn about IT and electronics, not only from a book, but also trough practice.  These courses are a large part of the specialisation Art and Technology.");
								content2.setText("AV and IT Principles, Physical Interaction Design, Visual Performance and Installation Technology, Interactive Storytelling.");
								content3.setText("Arduino(Processing)");
								pageCounter = 0;
								arrowLTxt.setText("DATA AND MEDIA");
								arrowRTxt.setText("DATA AND MEDIA");
								smallCircle2.setFillColor(new MTColor(255,255,255));
								smallCircle3.setFillColor(new MTColor(255,255,255, 125));
								docent1.setText("Jan de Coster");
								docent2.setText("");
								PImage Image1 = app.loadImage("Technology1.png"); 
								rectangleImage1 = new MTRectangle(Image1, app);
								getCanvas().addChild(rectangleImage1);
								rectangleImage1.setPositionGlobal(new Vector3D(1200,290,0));
								rectangleImage1.setNoStroke(true);
								this.clearAllGestures(rectangleImage1);
							}
							break;
							}
					default: break;
				}
					return false;			
			}

				private void clearAllGestures(MTRectangle rectangleImage1) {
					rectangleImage1.unregisterAllInputProcessors();
					rectangleImage1.removeAllGestureEventListeners();
					
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
		this.destroy();
	}

}
