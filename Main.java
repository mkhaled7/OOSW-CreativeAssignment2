import view.Paint;

public class Main {

	public static void main(String[] args){

		Paint paint = new Paint();
		paint.view();
	}
}

/*REFERENCES and acknowledgemnets:
Thanks to my friend, Shelby Koch, who helped find a bug with my button listeners
-> missed () on a method call and missed keyword "public" on a class which was used in another file,
- so its members were not visible due to the class not being public
https://www.programcreek.com/java-api-examples/?class=java.awt.Component&method=createImage
https://stackoverflow.com/questions/9445182/drawimage-doesnt-draw/9445499
https://www.codota.com/code/java/methods/java.awt.Graphics/drawImage
https://stackoverflow.com/questions/20170641/creating-a-custom-method-to-draw-graphics-2d-g2-is-null
,etc
*/