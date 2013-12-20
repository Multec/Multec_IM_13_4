package infopanel;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class Hoofdmenu extends AbstractScene {
	private MTApplication mtApp;

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
		MTTextArea textArDes = new MTTextArea(mtApp, fontHype); 
		MTTextArea textArTec = new MTTextArea(mtApp, fontHype); 
		MTTextArea textArBus = new MTTextArea(mtApp, fontHype); 
		MTTextArea textArDev = new MTTextArea(mtApp, fontHype); 
		MTTextArea textArInt = new MTTextArea(mtApp, fontHype); 
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
		//Add the textfield to our canvas
		
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
	@Override
	public void init() {
	}

	@Override
	public void shutDown() {
	}

}
