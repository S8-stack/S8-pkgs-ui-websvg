package com.s8.pkgs.ui.websvg.shapes.path;

import java.io.IOException;

import com.s8.api.bytes.ByteInflow;
import com.s8.api.bytes.ByteOutflow;
import com.s8.api.serial.S8Serializable;

public class ClosePath extends WebSVG_PathElement {
	
	public static WebSVG_PathElement create() {
		return new ClosePath();
	}
	
	public static WebSVG_PathElement deserialize(ByteInflow inflow) {
		return new ClosePath();
	}

	public final static int CODE = 0x02;

	public ClosePath() {
		super();
	}

	@Override
	public void serialize(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(CODE);
	}


	public @Override long computeFootprint() { return 0; }
	public @Override S8Serializable deepClone() { return new ClosePath(); }
	public @Override int getCode() { return CODE; }

	@Override
	public boolean isEqualTo(WebSVG_PathElement element) {
		return true;
	}

	
}