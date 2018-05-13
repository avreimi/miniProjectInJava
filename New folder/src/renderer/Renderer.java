package renderer;

import java.util.ArrayList;
import java.util.List;

import geometries.Geometries;
import primitives.Point3D;
import primitives.Ray;
import scene.Color;
import scene.Scene;

/**
 * @author Chayim
 *
 */
public class Renderer {

	private Scene _scene;
	private ImageWriter _imageWriter;
	
	/**
	 * 
	 */
	public Renderer(Scene scene,ImageWriter imageWriter) {
		_scene=new Scene(scene);
		_imageWriter=new ImageWriter(imageWriter);
	}
	
	public Renderer(Renderer other) {
		_scene=new Scene(other._scene);
		_imageWriter=new ImageWriter(other._imageWriter);
	}
	
	//TDOD I havt to see if its expected to make getters and setters !!!!!!!!
	
	/**
	 * @return the _scene
	 */
	public Scene get_scene() {
		return _scene;
	}

	/**
	 * @param _scene the _scene to set
	 */
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}

	/**
	 * @return the _imageWriter
	 */
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}

	/**
	 * @param _imageWriter the _imageWriter to set
	 */
	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}
	
	
	public void renderImage() {
		int nx=_imageWriter.getNx(), ny=_imageWriter.getNy();
		//the index have to begin 0 or 1 ????  (any case it have to stop <nx - else exception)
		for (int i = 1; i < nx; i++) {
			for (int j = 1; j < ny; j++) {
				Ray ray = _scene.get_camera().constructRayThroughPixel 
						(_imageWriter.getNx(), _imageWriter.getNy() , i, j, _scene.get_screenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
						List<Point3D> intersectionPoints = getSceneRayIntersections(ray);
						if(intersectionPoints.isEmpty()) {
							_imageWriter.writePixel(i, j, _scene.get_background().get_color()); 
						}
						else {
							Point3D closestPoint = getClosestPoint(intersectionPoints);
							_imageWriter.writePixel(i, j, calcColor(closestPoint).get_color());
						}
			}
		}
	}
	
	public void printImage(int interval) {
		int width=_imageWriter.getWidth(), height=_imageWriter.getHeight();
		//the index have to begin 0 or 1 ????  (any case it have to stop <nx - else exception)
		for (int i = 1; i < width; i+=interval) {
			for (int j = 1; j < height; j++) {
				_imageWriter.writePixel(i, j, _scene.get_ambientLight().getIntensity().get_color());
			}
		}
		for (int j = 1; j < width; j+=interval) {
			for (int i = 1; i < height; i++) {
				_imageWriter.writePixel(i, j, _scene.get_ambientLight().getIntensity().get_color());
			}
		}
	}
		
	

	/**
	 * 
	 * @param point3d
	 * @return
	 */
	private Color calcColor(Point3D point3d) {
		return _scene.get_ambientLight().getIntensity();
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private Point3D getClosestPoint(List<Point3D> intersectionPoints) { 
		double distance = Double.MAX_VALUE; 
		Point3D p0 = _scene.get_camera().get_p0(); 
		Point3D minDistancePoint = null;
		for (Point3D point : intersectionPoints) { 
			if (p0.distance(point) < distance) {
				minDistancePoint = new Point3D(point); 
				distance = p0.distance(point);
			}
		}
		return minDistancePoint;
	}

	
	/**
	 * 
	 * @param ray
	 * @return
	 */
	private List<Point3D> getSceneRayIntersections (Ray ray){
		ArrayList<Point3D> pointsList=new ArrayList<Point3D>();
		
	        for (Geometries geometries : _scene.get_geometries()) {
				pointsList.addAll(geometries.findIntersections(ray));
			}
	    return pointsList;
	}

}
