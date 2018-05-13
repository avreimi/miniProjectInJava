package scene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Geometry;

/**
 * @author Chayim
 *
 */
public class Scene {
	private String _sceneName;
	//what is about safety and getters/setters for the next 2 fields ????
	private Color _background;
	private List<Geometries> _geometries;
	private AmbientLight _ambientLight;
    private Camera _camera;
    private double _screenDistance;

 // ***************** Constructors ********************** //
	/**
	 * constructor
	 */
	public Scene(String name) {
		this._sceneName=name;
		_geometries=new ArrayList<Geometries>();
	}
	
	public Scene(Scene other) {
		_sceneName=other.get_sceneName();
		_background=new Color(other._background);
		_geometries=new ArrayList<Geometries>(other._geometries);
		_ambientLight=new AmbientLight(other.get_ambientLight());
		_camera=new Camera(other.get_camera());
		_screenDistance=other.get_screenDistance();
	}

	// ***************** setters/getters ********************** //
	/**
	 * getter for scene's name
	 * @return name
	 */
	public String get_sceneName() {
		return _sceneName;
	}

	/**
	 * setter for scene's name
	 * @param _name scene's nama
	 */
	public void set_sceneName(String _name) {
		this._sceneName = _name;
	}

	/**
	 * @return the _background
	 */
	public Color get_background() {
		return _background;
	}

	/**
	 * @param _background the _background to set
	 */
	public void set_background(Color _background) {
		this._background = _background;
	}

	/**
	 * @return the _geometries
	 */
	public List<Geometries> get_geometries() {
		return _geometries;
	}

	/**
	 * @param _geometries the _geometries to set
	 */
	public void set_geometries(List<Geometries> _geometries) {
		this._geometries = _geometries;
	}

	/**
	 * @return the _ambientLight
	 */
	public AmbientLight get_ambientLight() {
		return _ambientLight;
	}

	/**
	 * @param _ambientLight the _ambientLight to set
	 */
	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}

	/**
	 * fetter for camera
	 * @return camera
	 */
	public Camera get_camera() {
		return _camera;
	}

	/**
	 * setter for camera
	 * @param _camera - camera
	 */
	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}

	/**
	 * getter for distance of the camera from the screen
	 * @return distance
	 */
	public double get_screenDistance() {
		return _screenDistance;
	}

	/**
	 * setter for the distance of the camera from the screen
	 * @param _distance - distace
	 */
	public void set_screenDistance(double _distance) {
		this._screenDistance = _distance;
	}
	
	// ***************** operations ********************** //
	public Boolean addGeometry(Geometries geometries) {
		return _geometries.add(geometries);
	}
	
	/*this fonc show in the first gersion of the matzeget but not at the 2nd one !!!
	//TDOD I change from Geometry to Geomeries ... unlike the matzeget. !!!!
	public Iterator<Geometries> getGeometriesIterator(){
		return _geometries.iterator();
	}
	*/
}
