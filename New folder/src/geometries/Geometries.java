package geometries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import primitives.*;

/**
 * @author Chayim
 * class to hold a collection of geometries shapes  
 */
public class Geometries implements Geometry {
	private List<Geometry> _geometries;

	// ***************** Constructors ********************** //
	/**
	 * constructor
	 */
	public Geometries(List<Geometry> list) {
		_geometries=new ArrayList<Geometry>();
	    _geometries.addAll(list);
	}

	// ***************** operations ********************** //
	@Override
	public Vector getNormal(Point3D point) {
		return null;
	}

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		List<Point3D> pointsList = new ArrayList<Point3D>();
		for (Geometry geometry : _geometries) {
			pointsList.addAll(geometry.findIntersections(ray));
		}
		return pointsList;
	}

	/**
	 * add Geometry shapes to the list of the class
	 * @param geometry the Geometry to add
	 */
	public void add(Geometry geometry) {
		_geometries.add(geometry);
	}
	
	/**
	 * get the iterator of the list in the class
	 * @return the iterator of _geometries
	 */
	public Iterator<Geometry> getIterator() {
		return _geometries.iterator();
	}
}
