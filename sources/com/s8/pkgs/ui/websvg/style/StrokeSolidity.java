package com.s8.pkgs.ui.websvg.style;

import com.s8.build.js.JS_Enum;
import com.s8.build.js.JS_Generator;

public enum StrokeSolidity implements JS_Enum {

	SOLID(0x00, "solid", "1"),

	SMALL_DASH(0x03, "small-dash", "2 2"),

	LONG_DASH(0x04, "long-dash", "4 1");



	public final int code;

	public final String name;
	
	public final String jsValue;


	private StrokeSolidity(int code, String name, String jsValue) {
		this.code = code;
		this.name = name;
		this.jsValue = jsValue;
	}
	
	
	public static void JS_generateFunction(JS_Generator gen) {
		gen.appendEnumByCodeFunc(
				"Normalized solidity", 
				"WebSVG.getStrokeSolidityByCode", 
				StrokeSolidity.values());
	}
	
	

	@Override
	public boolean isDefault() {
		return code == SOLID.code;
	}
	

	@Override
	public int getKey() {
		return code;
	}


	@Override
	public String getValue() {
		return jsValue;
	}



	@Override
	public String getComment() {
		return name() + " - " + name;
	}


	

}
