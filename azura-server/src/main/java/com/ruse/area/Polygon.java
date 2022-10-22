package com.ruse.area;


import com.ruse.model.Position;

public class Polygon extends Shape {

	private int sides;
	private int[][] points;

	public Polygon(Position... points) {
		sides(points.length).areas(points).type(ShapeType.POLYGON);
		points(new int[sides][2]);
		for (int i = 0; i < sides; i++) {
			points()[i][0] = points[i].getX();
			points()[i][1] = points[i].getY();
		}

	}

	@Override
	public boolean inside(Position Position) {
		boolean inside = false;
		int y = Position.getY(), x = Position.getX();

		for (int i = 0, j = sides() - 1; i < sides(); j = i++) {
			if (points()[i][1] < y && points()[j][1] >= y || points()[j][1] < y && points()[i][1] >= y) {
				if (points()[i][0] + (y - points()[i][1]) / (points()[j][1] - points()[i][1])
						* (points()[j][0] - points()[i][0]) < x) {
					inside = !inside;
				}
			}
		}

		return inside;
	}

	public int sides() {
		return sides;
	}

	public Shape sides(int sides) {
		this.sides = sides;
		return this;
	}

	public int[][] points() {
		return points;
	}

	public Shape points(int[][] points) {
		this.points = points;
		return this;
	}

}
