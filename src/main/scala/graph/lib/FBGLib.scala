package graph.lib

class FBGLib {
  def melding (what:String,where:String): Unit = {} //dummy
  
//	//Ook behoefte aan een losse versie
	def formatDouble( waarde:Double ):String = {       	
//	    String dubbel = "";
//	    Locale loc =  Locale.US;
//	    DecimalFormatSymbols sym = new  DecimalFormatSymbols ( loc ); 
//	  	DecimalFormat twoDecFormat = new DecimalFormat( "#,###,##0.00", sym );//localized!
//	  	    dubbel = twoDecFormat.format( waarde ); 
// 	return dubbel;
	  return waarde.toString //quick and dirty
	}

  	//TODO omwerken naar 2D-versie? Nee. Hoogstens Points i.p.v. coords.
  //Kan slimmer Indien niet recht: Drie punten roteren. Vervolgens eenvoudig
  
  
//	def onLine_OUD( xP:Double, yP:Double, x1:Double, y1:Double, x2:Double, y2:Double, d:Double ): Boolean = {
//	
//	  	var  xa, xb, xc, xd, ya, yb, yc, yd = 0.0
//	  	var helling, hoek, sin, cos = 0.0
//	  	//int xPoints[] = new int[4];
//	  	var xPoints = new Array[Double](4)
//	  	var yPoints = new Array[Double](4)
//	  	
//	  	var minX = Math.min(x1,x2)
//	  	var minY = Math.min(y1,y2)
//	  	var maxX = Math.max(x1,x2)
//	  	var maxY = Math.max(y1,y2)
//	  	//bepaal de punten
//	  	if ( y1==y2 || x1==x2)
//	  	{
//	  		xa=minX-d; xb=minX-d; xc=maxX+d; xd=maxX+d;
//	  		ya=minY-d; yb=maxY+d; yc=maxY+d; yd=minY-d;
//	  	}
//	  	else
//	  	{
//	  		helling=(y2-y1)/(x2-x1);
//	//  System.out.println("x1: " + x1 + ", y1: " + y1 + ", x2: "+ x2 + ", y2: " + y2);
//	  		hoek = Math.atan( helling );
//	  		sin = Math.sin( Math.PI/4 - hoek ) * Math.sqrt(2) * d;
//	  		cos = Math.cos( Math.PI/4 - hoek ) * Math.sqrt(2) * d;
//
//	  		if ( helling>0 )//dalend op het scherm!
//	  		{
//	  			//Goed, afblijven!
//	  			xa=minX-sin;
//	  			xb=minX-cos;
//	  			xc=maxX+sin;
//	  			xd=maxX+cos;
//	  			ya=minY-cos;
//	  			yb=minY+sin;
//	  			yc=maxY+cos;
//	  			yd=maxY-sin;
//	//  System.out.println("dalend op het scherm");
//	  		}
//	  		else
//	  		{
//	  			xa=minX-sin;
//	  			xb=minX-cos;
//	  			xc=maxX+sin;
//	  			xd=maxX+cos;
//	  			ya=maxY-cos;
//	  			yb=maxY+sin;
//	  			yc=minY+cos;
//	  			yd=minY-sin;
//	//  System.out.println("stijgend op het scherm");
//	  		}
//	  	}
//	  	xPoints(0)=xa;	xPoints(1)=xb
//	  	xPoints(2)=xc;	xPoints(3)=xd
//	  	yPoints(0)=ya;	yPoints(1)=yb
//	  	yPoints(2)=yc;	yPoints(3)=yd
////	  	Polygon poly = new Polygon ( xPoints, yPoints,4 );
////	  	return poly.contains( xP, yP );
//	  	false
//	}
	
		def onLine( xP:Double, yP:Double, x1:Double, y1:Double, x2:Double, y2:Double, d:Double ): Boolean = {
  		  if (x1==x2 && y1==y2 ) return false

//      translatie naar O:
//      val trans_xP = xP-x1
//		  val trans_yP = yP-y1
//		  val trans_x1 = 0
//		  val trans_y1 = 0
//		  val trans_x2 = x2-x1
//		  val trans_y2 = y2-y1
		  val helling = (y2-y1)/(x2-x1)
		  val hoek = Math.atan( helling )
		  //rotatie over hoek om (a,b), nu (0,0)
		  //x'=(x-a)cos hoek -(y-b)sin hoek + a
		  //y'=(x-a)sin hoek +(y-b)cos hoek + a
		  //Oftewel
		  //x'=(x)cos hoek -(y)sin hoek 
		  //y'=(x)sin hoek -(y)cos hoek 
		  val rot_xP = (xP-x1)*Math.cos(hoek) - (yP-y1)*Math.sin(hoek)
		  val rot_yP = (xP-x1)*Math.sin(hoek) + (yP-y1)*Math.cos(hoek)
		  val rot_x1 = 0
		  val rot_y1 = 0
		  val rot_x2 = (x2-x1)*Math.cos(hoek) - (y2-y1)*Math.sin(hoek)
		  val rot_y2 = (x2-x1)*Math.sin(hoek) + (y2-y1)*Math.cos(hoek)
		  val minx = Math.min(0,rot_x2);val maxx = Math.max(0,rot_x2)
		  val miny = Math.min(0,rot_y2);val maxy = Math.max(0,rot_y2)
		  if (rot_xP < minx -d || rot_xP > maxx + d ||
		      rot_yP < miny -d || rot_yP > maxy + d ) false
		  else true
		}
}