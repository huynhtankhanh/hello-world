package com.khanh.hello_world;

public class ParkingSystem {
	private int big;
	private int medium;
	private int small;

	public ParkingSystem(int big, int medium, int small) {
		this.big = big;
		this.medium = medium;
		this.small = small;
	}

	// big 1, medium 2, small 3
	public boolean addCar(int carType) {
		switch (carType) {
		case 1:
			if (this.big > 0) {
				this.big--;
				return true;
			}
			return false;
		case 2:
			if (this.medium > 0) {
				this.medium--;
				return true;
			}
			return false;
		case 3:
			if (this.small > 0) {
				this.small--;
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	public int getBig() {
		return big;
	}

	public void setBig(int big) {
		this.big = big;
	}

	public int getMedium() {
		return medium;
	}

	public void setMedium(int medium) {
		this.medium = medium;
	}

	public int getSmall() {
		return small;
	}

	public void setSmall(int small) {
		this.small = small;
	}
}
