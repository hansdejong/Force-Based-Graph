//package graph.gui
////
////import java.awt.BorderLayout
////
////import java.awt.Color
////
////import java.awt.GridLayout
////
////import javax.swing._
////
////import javax.swing.border.BevelBorder
////
////import javax.swing.event.ChangeEvent
////
////import javax.swing.event.ChangeListener
////
//import graph.drawings.EDrawings
//import graph.drawings.EDrawings._
////import org.scalajs.dom
////import dom.html
////
/////////import fimme.graph.ioDialog.ChooserDialog;
////import fimme.graph.lib.Lib
////
////import fimme.graph.model.IGraphModel
////
////import fimme.graph.opstart.StartGraph
////
////import toolsSwing.ConverterRangeModel
////
////import toolsSwing.DecimalField
////
////import toolsSwing.FollowerRangeModel
////
////import java.awt.event._
////
////import java.text.NumberFormat
////
//////remove if not needed
////import scala.collection.JavaConversions._
////
//class GraphGui(/*var canvas:html.Canvas,var tekstvak:html.TextArea*/)/*(private var isApplet: Boolean) extends JPanel*/ {
////def appendText(extra:String)={ tekstvak.value = tekstvak.value + extra }
////appendText("\nDit is GraphGui")
//
//// AANROEP TIJDELIJK ER UIT
//  var graphPanel: FBGPaintingPanel = _
//
//
////
////////private ChooserDialog chooserDialog;
////  private var saveMenuItem: JMenuItem = _
////
////  private var openMenuItem: JMenuItem = _
////
////  private var buttonNewGraph: JButton = new JButton("Klik mij")
////
//////sleep of edit
////  private var buttonMouseMode: JButton = new JButton("Sleep")
////
////  private var buttonColor: JButton = new JButton("Kleur" + "")
////
////  private var mouseModeDrag: Boolean = true
////
////  private var vakInvoer1: DecimalField = _
////
////  private var vakInvoer2: DecimalField = _
////
////  private var vakInvoer3: DecimalField = _
////
////  private var slider1: JSlider = _
////
////  private var slider2: JSlider = _
////
////  private var slider3: JSlider = _
////
////  private var sliderModel1: ConverterRangeModel = _
////
////  private var sliderModel2: ConverterRangeModel = _
////
////  private var sliderModel3: ConverterRangeModel = _
////
////  private var followerSliderModel1: FollowerRangeModel = _
////
////  private var followerSliderModel2: FollowerRangeModel = _
////
////  private var followerSliderModel3: FollowerRangeModel = _
////
//  private var numberOfVertices: Int = 15
////
//  private var maxNumberOfEdges: Int = 20
////
//////Hier instellen
////  private var usingXml: Boolean = true
////
//  private var withLabels: Boolean = false
////
////  createGuiPanel()
////
////  addListeners()
////
//////  Opbouw GUI
////  private def createGuiPanel(): Unit = {
////    this.layout = new BorderLayout()
//////		}
////    add(createUitvoerPanel(), BorderLayout.CENTER)
////    add(createBottomPanel(), BorderLayout.SOUTH)
////  }
//////		JMenuBar bar = createMenuBar();
//////		if( bar != null){
//////			if( !isApplet || usingXml ){ add(createMenuBar(), BorderLayout.NORTH );}
//////		JMenuBar bar = createMenuBar();
//////		if( bar != null){
//////			if( !isApplet || usingXml ){ add(createMenuBar(), BorderLayout.NORTH );}
////
//  //private def createUitvoerPanel():Unit /*JPanel*/ = {
////    val thePanel: JPanel = new JPanel()
////    thePanel.setLayout(new BorderLayout())
//    //val achtergrondkleurtje: Color = "#F0F8FF"//new Color(0xF0F8FF)
//    val achtergrondkleurtje: String = "#F0F8FF"
//    val graphName: EDrawings = getRandomDrawing
//	    graphPanel = new FBGPaintingPanel( numberOfVertices, maxNumberOfEdges, achtergrondkleurtje, withLabels);
//
//   //AANROEP TIJDELIJK ER UIT
////     graphPanel = new FBGPaintingPanel(
//// 
////                                                  /*canvas,
////                                                  tekstvak,*/
////                                                  graphName,
////                                                  achtergrondkleurtje,
////                                                  withLabels)
//                                                 
//    
////		    thePanel.add( scrollPane , BorderLayout.CENTER );
////    thePanel.add(graphPanel, BorderLayout.CENTER)
////    thePanel
//  //}
//////	    JScrollPane scrollPane = new JScrollPane( graphPanel ,
//////	    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//////	    		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//////	    JScrollPane scrollPane = new JScrollPane( graphPanel ,
//////	    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//////	    		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
////
//////Kopietje. Duplicaat verwijderen
////  private def getRandomDrawing_org(): EDrawings = {
////    //https://stackoverflow.com/questions/36386610/how-to-efficiently-pick-a-random-element-from-an-enumeration-in-scala
////    val waarden: ValueSet = EDrawings.values
////    val numItems: Int = waarden.size
////    val num: Int = (Math.random() * numItems).toInt
////    waarden(num)
////    EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
////  }
//
// private def getRandomDrawing(): EDrawings = {
//    val graph = EDrawings(scala.util.Random.nextInt(EDrawings.maxId))
// //    println(ClassTag(graph.getClass))
// //   println(graph)
//   graph 
// }
//
////
////  private def createBottomPanel(): JPanel = {
////    val thePanel: JPanel = new JPanel()
////    thePanel.setLayout(new BorderLayout())
////    thePanel.add(createSliderPanel(), BorderLayout.CENTER)
////    thePanel.add(createButtonPanel(), BorderLayout.EAST)
//////thePanel.add( buttonNewGraph , BorderLayout.EAST );
////    thePanel
////  }
////
////  private def createSliderPanel(): JPanel = {
////    val thePanel: JPanel = new JPanel()
//////Vrij aantal rijen, 2 kolommen
////    thePanel.setLayout(new GridLayout(0, 3))
////    thePanel.add(createInvoerPanel1())
////    thePanel.add(createInvoerPanel2())
////    thePanel.add(createInvoerPanel3())
////    thePanel
////  }
////
////  private def createButtonPanel(): JPanel = {
////    val thePanel: JPanel = new JPanel()
//////2 rijen, vrij aantal kolommen
////    thePanel.setLayout(new GridLayout(2, 0))
////    thePanel.add(buttonNewGraph)
////    thePanel.add(buttonMouseMode)
////    thePanel.add(buttonColor)
////    thePanel
////  }
////
////  private def createInvoerPanel1(): JPanel = {
////    val thePanel: JPanel = new JPanel()
////    thePanel.setLayout(new BorderLayout())
////    thePanel.add(new JLabel(" Aantal knooppunten"), BorderLayout.NORTH)
////    val nf: NumberFormat = NumberFormat.getNumberInstance
////    nf.setMaximumFractionDigits(0)
////    vakInvoer1 = new DecimalField(0.0, 20, nf)
//////double numVertices = numberOfVertices;//8;
////    sliderModel1 = new ConverterRangeModel()
////    sliderModel1.setDoubleValue(numberOfVertices)
////    followerSliderModel1 = new FollowerRangeModel(sliderModel1)
////    vakInvoer1.setValue(sliderModel1.getDoubleValue)
////    thePanel.add(vakInvoer1, BorderLayout.CENTER)
//////Checken Maakt kennelijk niet uit
////    slider1 = new JSlider(sliderModel1)
////    slider1.setMaximum(30)
////    slider1.setMinorTickSpacing(1)
////    slider1.setMajorTickSpacing(5)
////    slider1.setPaintTicks(true)
////    slider1.setPaintLabels(true)
//////werkt niet
////    slider1.setSnapToTicks(false)
////    thePanel.add(slider1, BorderLayout.SOUTH)
////    thePanel
////  }
////
////  private def createInvoerPanel2(): JPanel = {
////    val thePanel: JPanel = new JPanel()
////    thePanel.setLayout(new BorderLayout())
////    thePanel.add(new JLabel(" Aantal connecties (random poging)"),
////                 BorderLayout.NORTH)
////    val nf: NumberFormat = NumberFormat.getNumberInstance
////    nf.setMaximumFractionDigits(0)
////    vakInvoer2 = new DecimalField(0.0, 20, nf)
//////double numEdges = numberOfEdges; //6;
////    sliderModel2 = new ConverterRangeModel()
////    sliderModel2.setDoubleValue(maxNumberOfEdges)
////    followerSliderModel2 = new FollowerRangeModel(sliderModel2)
////    vakInvoer2.setValue(sliderModel2.getDoubleValue)
////    thePanel.add(vakInvoer2, BorderLayout.CENTER)
//////Checken Maakt kennelijk niet uit
////    slider2 = new JSlider(sliderModel2)
////    slider2.setMaximum(30)
////    slider2.setMinorTickSpacing(1)
////    slider2.setMajorTickSpacing(5)
////    slider2.setPaintTicks(true)
////    slider2.setPaintLabels(true)
//////werkt niet
////    slider2.setSnapToTicks(false)
////    thePanel.add(slider2, BorderLayout.SOUTH)
////    thePanel
////  }
////
////  private def createInvoerPanel3(): JPanel = {
////    val thePanel: JPanel = new JPanel()
////    thePanel.setLayout(new BorderLayout())
////    thePanel.add(new JLabel(" Zoomfactor"), BorderLayout.NORTH)
////    val nf: NumberFormat = NumberFormat.getNumberInstance
////    nf.setMaximumFractionDigits(2)
////    vakInvoer3 = new DecimalField(0.0, 20, nf)
//////double numEdges = numberOfEdges; //6;
////    sliderModel3 = new ConverterRangeModel()
////    sliderModel3.setDoubleValue(1)
////    followerSliderModel3 = new FollowerRangeModel(sliderModel3)
////    vakInvoer3.setValue(sliderModel3.getDoubleValue)
////    thePanel.add(vakInvoer3, BorderLayout.CENTER)
//////Checken Maakt kennelijk niet uit
////    slider3 = new JSlider(sliderModel3)
////    slider3.setMinimum(1)
////    slider3.setMaximum(10)
////    slider3.setMinorTickSpacing(1)
////    slider3.setMajorTickSpacing(5)
////    slider3.setPaintTicks(true)
////    slider3.setPaintLabels(true)
//////werkt niet
////    slider3.setSnapToTicks(false)
////    thePanel.add(slider3, BorderLayout.SOUTH)
////    thePanel
////  }
////
////  private def addListeners(): Unit = {
////    buttonNewGraph.addActionListener(new ActionListener() {
////      def actionPerformed(e: ActionEvent): Unit = {
////        val graphName: EDrawings = getRandomDrawing
////        graphPanel.setNewModel(graphName)
////        graphPanel.recalcGraph()
////      }
////    })
////    buttonMouseMode.addActionListener(new ActionListener() {
////      def actionPerformed(e: ActionEvent): Unit = {
////        if (mouseModeDrag) {
////          buttonMouseMode.setText("Wijzig")
////          mouseModeDrag = false
////        } else {
////          buttonMouseMode.setText("Sleep")
////          mouseModeDrag = true
////        }
////        graphPanel.setDragMode(mouseModeDrag)
////      }
////    })
////    buttonColor.addActionListener(new ActionListener() {
////      def actionPerformed(e: ActionEvent): Unit = {
////        val button: JButton = new JButton("Kies een kleur")
//////Swingboek 727
////        val colorChooser: JColorChooser = new JColorChooser()
////        colorChooser.setPreviewPanel(new JPanel())
//////colorChooser.setPreviewPanel( new PreviewPane( colorChooser ));//Werkt niet
////        val okListener: ActionListener = new ActionListener() {
////          def actionPerformed(e: ActionEvent): Unit = {
////            graphPanel.setDefaultVertexColor(colorChooser.getColor)
////          }
////        }
////        val dialog: JDialog = JColorChooser.createDialog(
////          button,
////          "Kies Knooppuntkleur (bij wijzig, rechtermuisknop)",
////          true,
////          colorChooser,
////          okListener,
////          null)
////        dialog.setVisible(true)
////      }
////    })
//////=======
////    sliderModel1.addChangeListener(new ChangeListener() {
////      def stateChanged(e: ChangeEvent): Unit = {
////        val x: Double = followerSliderModel1.getDoubleValue
////        vakInvoer1.setValue(x)
////      }
////    })
////    vakInvoer1.addActionListener(new ActionListener() {
////      def actionPerformed(e: ActionEvent): Unit = {
////        followerSliderModel1.setDoubleValue(vakInvoer1.getValue)
////      }
////    })
//////=======
////    sliderModel2.addChangeListener(new ChangeListener() {
////      def stateChanged(e: ChangeEvent): Unit = {
////        val x: Double = followerSliderModel2.getDoubleValue
////        vakInvoer2.setValue(x)
////      }
////    })
////    vakInvoer2.addActionListener(new ActionListener() {
////      def actionPerformed(e: ActionEvent): Unit = {
////        followerSliderModel2.setDoubleValue(vakInvoer2.getValue)
////      }
////    })
//////=======
////    sliderModel3.addChangeListener(new ChangeListener() {
////      def stateChanged(e: ChangeEvent): Unit = {
////        val x: Double = followerSliderModel3.getDoubleValue
////        vakInvoer3.setValue(x)
////        graphPanel.setZoomFactor(vakInvoer3.getValue)
//////werkt niet
////        graphPanel.repaint()
////      }
////    })
////    vakInvoer3.addActionListener(new ActionListener() {
////      def actionPerformed(e: ActionEvent): Unit = {
////        followerSliderModel3.setDoubleValue(vakInvoer3.getValue)
////        graphPanel.setZoomFactor(vakInvoer3.getValue)
//////een repaint werkt niet
////        graphPanel.repaint()
////      }
////    })
////  }
//////	    if(!isApplet || usingXml ){//Checken. Ik snap dat "usingXml" hier niet meer, werkt wel.
//////				saveMenuItem.addActionListener(new ActionListener( ){
//////					     public void actionPerformed( ActionEvent e){
//////				    	chooserDialog.save( graphPanel.getModel() );
//////				    	if( !isApplet ){
//////				    		StartGraph.setStaticTitleCallBack( chooserDialog.getSelectedPathAndFile() );
//////				    	}
//////					    //testSave();	
//////				    }
//////				});
//////				openMenuItem.addActionListener(new ActionListener( ){
//////				        public void actionPerformed( ActionEvent e){
//////				        IGraphModel model = null;
//////			        	model = chooserDialog.open();//BUITEN DE if() NADAT DE FOUT IS HERSTELD!!Geen idee meer: proberen
//////			        	//Geladen modellen verschijnen als stip in de hoek!!!!!
//////				        if( !isApplet ){
//////				        	//model = chooserDialog.open();//BUITEN DE if() NADAT DE FOUT IS HERSTELD!!
//////				        	StartGraph.setStaticTitleCallBack( chooserDialog.getSelectedPathAndFile() );
//////				        }
//////				        if( model != null){
//////						    graphPanel.setNewModel( model );
//////						    graphPanel.repaint();
//////					    }
//////				        //testOpen();	
//////				    }
//////				});
//////		}
//////	    if(!isApplet || usingXml ){//Checken. Ik snap dat "usingXml" hier niet meer, werkt wel.
//////				saveMenuItem.addActionListener(new ActionListener( ){
//////					     public void actionPerformed( ActionEvent e){
//////				    	chooserDialog.save( graphPanel.getModel() );
//////				    	if( !isApplet ){
//////				    		StartGraph.setStaticTitleCallBack( chooserDialog.getSelectedPathAndFile() );
//////				    	}
//////					    //testSave();	
//////				    }
//////				});
//////				openMenuItem.addActionListener(new ActionListener( ){
//////				        public void actionPerformed( ActionEvent e){
//////				        IGraphModel model = null;
//////			        	model = chooserDialog.open();//BUITEN DE if() NADAT DE FOUT IS HERSTELD!!Geen idee meer: proberen
//////			        	//Geladen modellen verschijnen als stip in de hoek!!!!!
//////				        if( !isApplet ){
//////				        	//model = chooserDialog.open();//BUITEN DE if() NADAT DE FOUT IS HERSTELD!!
//////				        	StartGraph.setStaticTitleCallBack( chooserDialog.getSelectedPathAndFile() );
//////				        }
//////				        if( model != null){
//////						    graphPanel.setNewModel( model );
//////						    graphPanel.repaint();
//////					    }
//////				        //testOpen();	
//////				    }
//////				});
//////		}
////
//}
////
//////import fimme.graph.io.IoAdapter;
////
