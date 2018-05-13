//submit by avreimi cheshin 203220876 and elchay shoval *****8975

import primitives.*;

public class Program {

	public static void main(String[] args) {
		try {
			Coordinate c1 = new Coordinate(5);
			System.out.println("Coordinate: " + c1);

			Coordinate c2 = new Coordinate(6);

			if (c1.equals(c2))
				System.out.println("Test failed: 5 == 6");
			else
				System.out.println("Test successful: 5 != 6");

			Coordinate c3 = new Coordinate(5.0000000001);
			if (c1.equals(c3))
				System.out.println("Test successful: 5 == 5");
			else
				System.out.println("Test failed: 5 != 5");
			c1.add(c2);
			System.out.println(c1.add(c2));

			
			
			Point3D myPoint = new Point3D(1, 2, 3);
			Point3D myPoint2 = new Point3D(0,0,1);
			Point3D myPoint3d = new Point3D(4, 4, 4);
			System.out.println("subtract between "+myPoint+" and "+myPoint2+"is: "+myPoint.subtract(myPoint2));
			System.out.println("dictance between "+myPoint+" and "+myPoint2+"is: "+myPoint.distance(myPoint2));
			
			try {
				Vector v1=new Vector(myPoint2);
			} catch (Exception e) {
				//System.out.println(e.);
			}
			System.out.println("000");
			//geometries.Triangle ttt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

}
