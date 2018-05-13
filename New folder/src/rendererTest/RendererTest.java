package rendererTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Geometry;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Renderer;
import scene.Color;
import scene.Scene;

class RendererTest {

	@Test
	void test() {
	
		Scene scene=new Scene("my scene");
		scene.set_background(new Color(100, 0, 0));
		scene.set_ambientLight(new AmbientLight(new Color(0, 0, 100), 1));
		scene.set_camera(new Camera(new Point3D(0, 0, 0), new Vector(0, 0,1), new Vector(0, 1, 0)));
		scene.set_screenDistance(50);
		ArrayList<Geometry> list =new ArrayList<>();
		list.add(new Sphere(85,new Point3D(0, 100, 0)));
		list.add(new Triangle(new Point3D(0, 100, 400), new Point3D(200, 100, 200),new Point3D(-200, 100, 200)));        ////Sphere(50,new Point3D(-100, 0, 0)));   //,new Point3D(100, 0, 50),new Point3D(100, 50, 0)));
		scene.addGeometry(new Geometries(list));
		ImageWriter imageWriter=new ImageWriter("myImage", 500, 500, 500, 500);
		Renderer myRenderer=new Renderer(scene, imageWriter);
		myRenderer.renderImage();
		myRenderer.printImage(50);
		myRenderer.get_imageWriter().writeToimage();
	}

}
