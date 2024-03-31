package com.s8.pkgs.ui.websvg.devops;

import com.s8.build.js.JS_Generator;
import com.s8.pkgs.ui.websvg.style.FillColor;
import com.s8.pkgs.ui.websvg.style.StrokeColor;
import com.s8.pkgs.ui.websvg.style.StrokeSolidity;
import com.s8.pkgs.ui.websvg.style.StrokeThickness;

public class GenerateFunc {

	public static void main(String[] args) {
		
		JS_Generator gen = new JS_Generator();
		StrokeThickness.JS_generateFunction(gen);
		gen.skipLines(2);
		StrokeSolidity.JS_generateFunction(gen);
		gen.skipLines(2);
		StrokeColor.JS_generateFunction(gen);
		gen.skipLines(2);
		FillColor.JS_generateFunction(gen);
		System.out.print(gen.getCode());
	}

}
