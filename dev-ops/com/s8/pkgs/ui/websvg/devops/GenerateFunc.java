package com.s8.pkgs.ui.websvg.devops;

import com.s8.build.js.JS_Generator;
import com.s8.pkgs.io.svg.styles.FillColor;
import com.s8.pkgs.io.svg.styles.SVG_StrokeColor;
import com.s8.pkgs.io.svg.styles.SVG_StrokeSolidity;
import com.s8.pkgs.io.svg.styles.SVG_StrokeThickness;

public class GenerateFunc {

	public static void main(String[] args) {
		
		JS_Generator gen = new JS_Generator();
		SVG_StrokeThickness.JS_generateFunction(gen);
		gen.skipLines(2);
		SVG_StrokeSolidity.JS_generateFunction(gen);
		gen.skipLines(2);
		SVG_StrokeColor.JS_generateFunction(gen);
		gen.skipLines(2);
		FillColor.JS_generateFunction(gen);
		System.out.print(gen.getCode());
	}

}
