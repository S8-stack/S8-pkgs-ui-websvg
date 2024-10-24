package com.s8.pkgs.ui.websvg.shapes.path;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.serial.S8Serializable;
import com.s8.pkgs.ui.websvg.transform.WebSVG_Vector;

public class MoveTo_absolute extends WebSVG_PathElement {

	public static WebSVG_PathElement deserialize(ByteInflow inflow) throws IOException {
		return new MoveTo_absolute(inflow.getFloat32(), inflow.getFloat32());
	}
	
	public static WebSVG_PathElement create(double x, double y) {
		return new MoveTo_absolute(x, y);
	}
	
	public static WebSVG_PathElement create(WebSVG_Vector position) {
		return new MoveTo_absolute(position.x, position.y);
	}

	public final static int CODE = 0x12;

	public final double x, y;

	public MoveTo_absolute(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public void serialize(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(CODE);
		outflow.putFloat32((float) x);
		outflow.putFloat32((float) y);
	}

	public @Override long computeFootprint() { return 2 * 4; }
	public @Override S8Serializable deepClone() { return new MoveTo_absolute(x, y); }
	public @Override int getCode() { return CODE; }
	
	@Override
	public boolean isEqualTo(WebSVG_PathElement element) { MoveTo_absolute right = (MoveTo_absolute) element;
		return this.x == right.x && this.y == right.y;
	}

	
}