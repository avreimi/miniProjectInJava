package elements;

import scene.Color;

/**
 * @author Chayim
 *
 */
public class AmbientLight {
	private Color _color; 
	private double _ka;
  
	/**
	 * constructor
	 */
	public AmbientLight(Color color,double ka) {
		_color=new Color(color);
		_ka=ka;
	}
	
	public  AmbientLight(AmbientLight other) {
		_color=new Color(other._color);
		_ka=other._ka;
	}
	
	/// TDOD what about getters and setters ???????????
	
	/**
	 * get the intensity the color
	 * @return the intensity color
	 */
	public Color getIntensity() {
		_color.scale(_ka);
		return _color;
	}


}
