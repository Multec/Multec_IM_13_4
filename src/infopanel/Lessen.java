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
		
	
public class Lessen extends AbstractScene {
		private MTApplication app;
		private Iscene development;
		private Iscene technology;
		private Iscene integration;
		private Iscene bussiness;
		private Iscene design2;
		private Iscene design;
		private int positionX = 0;
		
		
		public Lessen (final MTApplication mtApplication, String name) {
			super(mtApplication, name);
			this.app = mtApplication;
			this.registerGlobalInputProcessor(new CursorTracer(app, this));
			MTBackgroundImage background = new MTBackgroundImage(mtApplication, mtApplication.loadImage("design.jpg") , true);
			this.getCanvas().addChild(background);
			
			MTColor white = new MTColor(255,255,255);
			MTColor black = new MTColor(0,0,0);
			MTColor kleurbol1 = new MTColor(248, 76, 76, 125);
			MTColor kleurbol2 = new MTColor(93,160,83, 125);
			MTColor kleurbol3 = new MTColor(65, 135, 206, 125);
			MTColor kleurbol4 = new MTColor(134, 62, 62, 125);
			MTColor kleurbol5 = new MTColor(206, 181, 104, 125);
			
			MTColor textAreaColor = new MTColor(50,100,150,0);
			
			IFont font = FontManager.getInstance().createFont(app, "HYPE.ttf", 40, white, white);
			IFont inhoudfont = FontManager.getInstance().createFont(app, "HYPE.ttf", 17, black, black);
	
	
			final MTTextArea tekstinhoud = new MTTextArea(300 + positionX, 150, 700, 300, inhoudfont, mtApplication); 
			tekstinhoud.setNoFill(true);
			tekstinhoud.setNoStroke(true);
			tekstinhoud.setText("DESIGN AND VISUAL                                                                                                                                             "
								+"IN THESE COURSES, THE STUDENTS WILL LEARN HOW TO DESIGN FOR WEB AS WELL AS AUDIO VISUAL DESIGN.                                                                               "
								+ "SOFTWARE:                                                                "
								+ "       PHOTOSHOP, ILLUSTRATOR, PREMIERE PRO AND FLASH.                                                                                                                    "
								+ "COURSES:                                                                     "
								+ "   DESIGN PRINCIPLES, AUDIOVISUAL DESIGN, USER EXPERIENCE DESIGN, COCNEPT DESIGN, MOTION DESIGN,          CROSS MEDIA DESIGN, DATA VISUALISATION                                                                                                                           "
								+ "TEACHERS:                                                                    "
								+ "   FILIP VANDEPUTTE, STEFAN TILBURGS                                                                                                        "
					);
		
			
			PImage Image1 = app.loadImage("design1.png"); //PLAATS HIER DE NAAM VAN UW FOTO'S-------------------------------------
			MTRectangle RectangleImage1 = new MTRectangle(Image1, app);
			getCanvas().addChild(RectangleImage1);
			RectangleImage1.setPositionGlobal(new Vector3D(1200,300,0));
			RectangleImage1.setNoStroke(true);
			
			PImage Image2 = app.loadImage("design2.png"); //PLAATS HIER DE NAAM VAN UW FOTO'S-------------------------------------
			MTRectangle RectangleImage2 = new MTRectangle(Image2, app);
			getCanvas().addChild(RectangleImage2);
			RectangleImage2.setPositionGlobal(new Vector3D(1600,300,0));
			RectangleImage2.setNoStroke(true);
			
			
			
			
			
			
			
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
