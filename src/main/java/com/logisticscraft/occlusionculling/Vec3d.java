package com.logisticscraft.occlusionculling;

public class Vec3d {
	public static final Vec3d ZERO = new Vec3d(0.0, 0.0, 0.0);
	public final double x;
	public final double y;
	public final double z;

	public Vec3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vec3d reverseSubtract(Vec3d vec) {
		return new Vec3d(vec.x - this.x, vec.y - this.y, vec.z - this.z);
	}

	public double dotProduct(Vec3d vec) {
		return this.x * vec.x + this.y * vec.y + this.z * vec.z;
	}

	public Vec3d crossProduct(Vec3d vec) {
		return new Vec3d(this.y * vec.z - this.z * vec.y, this.z * vec.x - this.x * vec.z,
				this.x * vec.y - this.y * vec.x);
	}

	public Vec3d subtract(Vec3d vec) {
		return this.subtract(vec.x, vec.y, vec.z);
	}

	public Vec3d subtract(double x, double y, double z) {
		return this.add(-x, -y, -z);
	}

	public Vec3d add(Vec3d vec) {
		return this.add(vec.x, vec.y, vec.z);
	}

	public Vec3d add(double x, double y, double z) {
		return new Vec3d(this.x + x, this.y + y, this.z + z);
	}

	public double squaredDistanceTo(Vec3d vec) {
		double d = vec.x - this.x;
		double e = vec.y - this.y;
		double f = vec.z - this.z;
		return d * d + e * e + f * f;
	}

	public double squaredDistanceTo(double x, double y, double z) {
		double d = x - this.x;
		double e = y - this.y;
		double f = z - this.z;
		return d * d + e * e + f * f;
	}

	public Vec3d multiply(double mult) {
		return this.multiply(mult, mult, mult);
	}

	public Vec3d multiply(Vec3d mult) {
		return this.multiply(mult.x, mult.y, mult.z);
	}

	public Vec3d multiply(double multX, double multY, double multZ) {
		return new Vec3d(this.x * multX, this.y * multY, this.z * multZ);
	}

	public double lengthSquared() {
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Vec3d)) {
			return false;
		}
		Vec3d vec3d = (Vec3d) o;
		if (Double.compare(vec3d.x, this.x) != 0) {
			return false;
		}
		if (Double.compare(vec3d.y, this.y) != 0) {
			return false;
		}
		return Double.compare(vec3d.z, this.z) == 0;
	}

	public int hashCode() {
		long l = Double.doubleToLongBits(this.x);
		int i = (int) (l ^ l >>> 32);
		l = Double.doubleToLongBits(this.y);
		i = 31 * i + (int) (l ^ l >>> 32);
		l = Double.doubleToLongBits(this.z);
		i = 31 * i + (int) (l ^ l >>> 32);
		return i;
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}

	public final double getX() {
		return this.x;
	}

	public final double getY() {
		return this.y;
	}

	public final double getZ() {
		return this.z;
	}
}