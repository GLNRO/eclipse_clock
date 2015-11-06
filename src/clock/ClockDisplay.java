package clock;

import processing.core.PApplet;
import processing.core.PImage;

public class ClockDisplay extends PApplet 
{
	PImage img;
	
	public void setup()
	{
		size(400,400);		//set canvas size
		background(0,0,0);	//set canvas color
		noStroke();			//set pen color	
		img = loadImage("https://upload.wikimedia.org/wikipedia/commons/b/bc/Eclipse_2010_Hao_1.JPG");
		img.resize(0,height);	//resize image
		image(img,0,0);			//display image
	}
	
	public void draw()
	{
		int[] color = sunColorSec(second());
		int turnDegree = turnSecond(second());
		fill(10,10,10);
		arc(194,192,600,600,radians(second()),radians(second() +6));//calculate color for sun
		fill(color[0],color[1],color[2]);		//set sun color
		ellipse(194,192,192,192); //draw sun
	}
	
	public int[] sunColorSec(float seconds)
	{
		int[] rgb = new int[3];
		//Scale color based on seconds. 0 is black, 30 is yellow
		float diffFrom30 = Math.abs(30-seconds);
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = (int)(255*ratio);
		return rgb;		
	}
	
	public int turnSecond(float seconds)
	{
		float diff60 = Math.abs(seconds*6 );
		return (int)(diff60);
	}
}
