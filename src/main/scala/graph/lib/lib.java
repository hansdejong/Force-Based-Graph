package graph.lib;

import java.awt.Polygon;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Lib {
//	public static int dim_2D = 2;
//	public static int dim_3D = 3;
//	public static int dim_4D = 4;

	public static void melding( String melding)
	{
		createMsg( melding, "" );
	}

	public static void melding( String melding, boolean toon)
	{
		if( toon )
		createMsg( melding, "" );
	}

	public static void melding( String melding, String plaats)
	{
		createMsg( melding, plaats );
	}


	public static void melding( String melding, String plaats, boolean toon)
	{
		if( toon )
		createMsg( melding, plaats );
	}

	
	private static void createMsg( String melding, String plaats )
	{
		boolean fout = false;
		if ( melding.indexOf("fout")!= -1 ||
		        melding.indexOf("error") != -1 ||
		        melding.indexOf("exception") != -1) fout = true;
	    if ( !plaats.equals( "" ))
		{
			if( !melding.endsWith("\n") )
			    plaats = " (Locatie: " + plaats + ")";
			else
			    plaats = "in " + plaats;
		}
		melding += plaats;
		if(fout)
		    System.err.println( melding );//De enige println()
		else
		    System.out.println( melding );//De enige println()
	}
	//Ook behoefte aan een losse versie
	public static String formatDouble( double waarde )
	{       	
	    String dubbel = "";
	    Locale loc =  Locale.US;
	    DecimalFormatSymbols sym = new  DecimalFormatSymbols ( loc ); 
	  	DecimalFormat twoDecFormat = new DecimalFormat( "#,###,##0.00", sym );//localized!
	  	    dubbel = twoDecFormat.format( waarde ); 
	  	return dubbel;
	}
	
	//TODO omwerken naar 2D-versie? Nee. Hoogstens Points i.p.v. coords. 
	public static boolean onLine( double xP, double yP, double x1, double y1, double x2, double y2, double d )
	{
	  	double xa, xb, xc, xd;
	  	double ya, yb, yc, yd;
	  	double helling,hoek,sin,cos;
	  	int xPoints[] = new int[4];
	  	int yPoints[] = new int[4];
	  	double minX, minY, maxX, maxY;
	  	minX = Math.min(x1,x2);
	  	minY = Math.min(y1,y2);
	  	maxX = Math.max(x1,x2);
	  	maxY = Math.max(y1,y2);
	  	//bepaal de punten
	  	if ( y1==y2 || x1==x2)
	  	{
	  		xa=minX-d; xb=minX-d; xc=maxX+d; xd=maxX+d;
	  		ya=minY-d; yb=maxY+d; yc=maxY+d; yd=minY-d;
	  	}
	  	else
	  	{
	  		helling=(y2-y1)/(x2-x1);
	//  System.out.println("x1: " + x1 + ", y1: " + y1 + ", x2: "+ x2 + ", y2: " + y2);
	  		hoek = Math.atan( helling );
	  		sin = Math.sin( Math.PI/4 - hoek ) * Math.sqrt(2) * d;
	  		cos = Math.cos( Math.PI/4 - hoek ) * Math.sqrt(2) * d;

	  		if ( helling>0 )//dalend op het scherm!
	  		{
	  			//Goed, afblijven!
	  			xa=minX-sin;
	  			xb=minX-cos;
	  			xc=maxX+sin;
	  			xd=maxX+cos;
	  			ya=minY-cos;
	  			yb=minY+sin;
	  			yc=maxY+cos;
	  			yd=maxY-sin;
	//  System.out.println("dalend op het scherm");
	  		}
	  		else
	  		{
	  			xa=minX-sin;
	  			xb=minX-cos;
	  			xc=maxX+sin;
	  			xd=maxX+cos;
	  			ya=maxY-cos;
	  			yb=maxY+sin;
	  			yc=minY+cos;
	  			yd=minY-sin;
	//  System.out.println("stijgend op het scherm");
	  		}
	  	}
	  	xPoints[0]=(int)xa;	xPoints[1]=(int)xb;
	  	xPoints[2]=(int)xc;	xPoints[3]=(int)xd;
	  	yPoints[0]=(int)ya;	yPoints[1]=(int)yb;
	  	yPoints[2]=(int)yc;	yPoints[3]=(int)yd;
	  	Polygon poly = new Polygon ( xPoints, yPoints,4 );
	  	return poly.contains( xP, yP );
	}
}
