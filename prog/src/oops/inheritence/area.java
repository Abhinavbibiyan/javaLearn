package oops.inheritence;

import java.io.*;

class rect {
	int l, b;

	public rect(int l, int b) {
		this.l = l;
		this.b = b;
	}

	public int area() {
		return l * b;
	}
}

class squar {
	int side;

	squar(int side) {
		this.side = side;
	}

	public int area() {
		return side * side;
	}
}

 