//package graph.drawings
//
//import java.awt.Color
//
//import java.util.ArrayList
//
//import fimme.graph.model.Grid
//
//import fimme.graph.model.Vertex3D
//
//class Tesseract extends TDrawing {
//
//  @BeanProperty
//  var vertices: ArrayList[Vertex3D] = new ArrayList[Vertex3D]()
//
//  @BeanProperty
//  var edges: Grid = null
//
//  makeGraph_Tesseract()
//
//  private def makeGraph_Tesseract(): Unit = {
////		int numVertices = 25;
//    val numVertices: Int = 16
//    val numVerticesPerCube: Int = 8
//    edges = new Grid(numVertices)
//    for (i <- 0 until numVerticesPerCube) {
//      val v: Vertex3D = new Vertex3D(new Color(0xFF0099))
//      v.setLabel(java.lang.Integer.toString(i))
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//    edges.setConnected(0, 1, true)
//    edges.setConnected(1, 2, true)
//    edges.setConnected(2, 3, true)
//    edges.setConnected(3, 0, true)
//    edges.setConnected(4, 5, true)
//    edges.setConnected(5, 6, true)
//    edges.setConnected(6, 7, true)
//    edges.setConnected(7, 4, true)
//    edges.setConnected(0, 4, true)
//    edges.setConnected(1, 5, true)
//    edges.setConnected(2, 6, true)
//    edges.setConnected(3, 7, true)
//    for (i <- 0 until numVerticesPerCube) {
//      val v: Vertex3D = new Vertex3D(new Color(0x3333FF))
//      v.setLabel(java.lang.Integer.toString(i + 8))
//      v.setXYZ(200 + Math.random() * 300,
//               100 + Math.random() * 200,
//               100 + Math.random() * 200)
//      vertices.add(v)
//    }
//    edges.setConnected(0 + 8, 1 + 8, true)
//    edges.setConnected(1 + 8, 2 + 8, true)
//    edges.setConnected(2 + 8, 3 + 8, true)
//    edges.setConnected(3 + 8, 0 + 8, true)
//    edges.setConnected(4 + 8, 5 + 8, true)
//    edges.setConnected(5 + 8, 6 + 8, true)
//    edges.setConnected(6 + 8, 7 + 8, true)
//    edges.setConnected(7 + 8, 4 + 8, true)
//    edges.setConnected(0 + 8, 4 + 8, true)
//    edges.setConnected(1 + 8, 5 + 8, true)
//    edges.setConnected(2 + 8, 6 + 8, true)
//    edges.setConnected(3 + 8, 7 + 8, true)
//    for (i <- 0.until(8)) {
//      edges.setConnected(i, i + 8, true)
//    }
//  }
//  /*
////Maak 8 extra spikes=========================
//    	for( int i=0; i<numVerticesPerCube; i++){
//			Vertex3D v = new Vertex3D( new Color( 0xccffff ));
//			v.setLabel( Integer.toString( i+16 ));
//			v.setXYZ(200+Math.random()*300, 100+Math.random()*200, 100+Math.random()*200);
//			vertices.add( v );
//		}
//    	for( int i=0; i<numVerticesPerCube; i++){
//    		edges.setConnected(i, i+16, true);
//    	}    	
////Maak een gele en
//		Vertex3D v = new Vertex3D( Color.YELLOW );
//		v.setXYZ(200+Math.random()*300, 100+Math.random()*200, 100+Math.random()*200);
//		vertices.add( v );
//    	for( int i=8; i<16; i++){
//    		edges.setConnected(i, 24, true);
//    	}    	
//   */
//
//  /*
////Maak 8 extra spikes=========================
//    	for( int i=0; i<numVerticesPerCube; i++){
//			Vertex3D v = new Vertex3D( new Color( 0xccffff ));
//			v.setLabel( Integer.toString( i+16 ));
//			v.setXYZ(200+Math.random()*300, 100+Math.random()*200, 100+Math.random()*200);
//			vertices.add( v );
//		}
//    	for( int i=0; i<numVerticesPerCube; i++){
//    		edges.setConnected(i, i+16, true);
//    	}    	
////Maak een gele en
//		Vertex3D v = new Vertex3D( Color.YELLOW );
//		v.setXYZ(200+Math.random()*300, 100+Math.random()*200, 100+Math.random()*200);
//		vertices.add( v );
//    	for( int i=8; i<16; i++){
//    		edges.setConnected(i, 24, true);
//    	}    	
// */
//
//}
//
