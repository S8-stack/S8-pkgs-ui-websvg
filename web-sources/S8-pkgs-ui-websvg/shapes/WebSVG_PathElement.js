import { WebSVG_ViewPort } from "/S8-pkgs-ui-websvg/WebSVG.js";




export class WebSVG_PathElement {
	
	/**
	 * 
	 * @param {ByteInflow} inflow 
	 * @returns {WebSVG_PathElement}
	 */
	static parse = function(raw) {
		
		switch (raw.code) {
			case ClosePath.CODE: return new ClosePath(raw);
	
			case MoveTo_abs.CODE: return new MoveTo_abs(raw);
			case MoveTo_rel.CODE: return new MoveTo_rel(raw);
	
			case Line_abs.CODE: return new Line_abs(raw);
			case Line_rel.CODE: return new Line_rel(raw);
	
			case HorizontalLine_abs.CODE: return new HorizontalLine_abs(raw);
			case HorizontalLine_rel.CODE: return new HorizontalLine_rel(raw);
	
			case VerticalLine_abs.CODE: return new VerticalLine_abs(raw);
			case VerticalLine_rel.CODE: return new VerticalLine_rel(raw);
	
			case Arc_abs.CODE: return new Arc_abs(raw);
			case Arc_rel.CODE: return new Arc_rel(raw);
	
			default : throw "Path Element with code: " + raw.code + " is not supported";
		}
	}

}

class ClosePath extends WebSVG_PathElement {

	static CODE = 0x02;

	constructor(){
		super();
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
	}

	/**
	 * 
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {String}
	 */
	SVG_generate(viewPort) {
		return "Z";
	}
}


class MoveTo_abs extends WebSVG_PathElement {

	static CODE = 0x12;

	constructor(raw) {
		super();
		this.x = raw.x;
		this.y = raw.y;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x = this.x;
		vec.y = this.y;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* M x y */
		return "M " + viewPort.xTranform(this.x).toPrecision(6) +
		 " " + viewPort.yTranform(this.y).toPrecision(6);
	}
}


class MoveTo_rel extends WebSVG_PathElement {


	static CODE = 0x13;

	constructor(raw) {
		super();
		this.dx = raw.dx;
		this.dy = raw.dy;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x += this.dx;
		vec.y += this.dy;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* m dx dy */
		return "m " + 
		viewPort.dxTranform(this.dx).toPrecision(6) + 
		" " + viewPort.dyTranform(this.dy).toPrecision(6);
	}
}


class Line_abs extends WebSVG_PathElement {

	static CODE = 0x21;
	
	constructor(raw) {
		super();
		this.x = raw.x;
		this.y = raw.y;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x = this.x;
		vec.y = this.y;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* L x y */
		return "L " + viewPort.xTranform(this.x).toPrecision(6) + 
		" " + viewPort.yTranform(this.y).toPrecision(6);
	}
}

class Line_rel extends WebSVG_PathElement {

	static CODE = 0x22;

	constructor(raw) {
		super();
		this.dx = raw.dx;
		this.dy = raw.dy;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x += this.dx;
		vec.y += this.dy;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* l dx dy */
		return "l " + 
		viewPort.dxTranform(this.dx).toPrecision(6) + " " + 
		viewPort.dyTranform(this.dy).toPrecision(6);
	}
}



class HorizontalLine_abs extends WebSVG_PathElement {

	static CODE = 0x23;

	constructor(raw) {
		super();
		this.x = raw.x;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x = this.x;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* H x y */
		return "H " + viewPort.xTranform(this.x).toPrecision(6);
	}
}

class HorizontalLine_rel extends WebSVG_PathElement {

	static CODE = 0x24;

	constructor(raw) {
		super();
		this.dx = raw.dx;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x += this.dx;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* l dx dy */
		return "h " + viewPort.dxTranform(this.dx).toPrecision(6);
	}
}


class VerticalLine_abs extends WebSVG_PathElement {


	static CODE = 0x25;

	constructor(raw) {
		super();
		this.y = raw.y;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.y = this.y;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* V y */
		return "V " + viewPort.yTranform(this.y).toPrecision(6);
	}
}

class VerticalLine_rel extends WebSVG_PathElement {


	static CODE = 0x26;

	constructor(raw) {
		super();
		this.dy = raw.dy;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.y += this.dy;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* v dy */
		return "v " + viewPort.dyTranform(this.dy).toPrecision(6);
	}
}


/**
 * 
a rx ry x-axis-rotation large-arc-flag sweep-flag dx dy
 */




class Arc_abs extends WebSVG_PathElement {


	static CODE = 0x31;


	constructor(raw) {
		super();
		this.r = raw.r;
		this.isLargeArc = raw.isLargeArc;
		this.isPositiveSweep = raw.isPositiveSweep;
		this.x = raw.x;
		this.y = raw.y;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x = this.x;
		vec.y = this.y;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* A rx ry x-axis-rotation large-arc-flag sweep-flag x y */
		return "A " +
			viewPort.sTranform(this.r).toPrecision(6) + " " +
			viewPort.sTranform(this.r).toPrecision(6) + " " +
			" 0 " +
			(this.isLargeArc ? '1' : '0') + " " +
			(this.isPositiveSweep ? '1' : '0') + " " +
			viewPort.xTranform(this.x).toPrecision(6) + " " +
			viewPort.yTranform(this.y).toPrecision(6);
	}
}

class Arc_rel extends WebSVG_PathElement {

	static CODE = 0x32;

	constructor(raw) {
		super();
		this.r = raw.r;
		this.isLargeArc = raw.isLargeArc;
		this.isPositiveSweep = raw.isPositiveSweep;
		this.dx = raw.dx;
		this.dy = raw.dy;
	}

	/**
	 * 
	 * @param {SVG_Vec} vec 
	 */
	moveToNext(vec){
		vec.x += this.dx;
		vec.y += this.dy;
	}

	/**
	 * @param {WebSVG_ViewPort} viewPort 
	 * @returns {string}
	 */
	SVG_generate(viewPort) {
		/* a rx ry x-axis-rotation large-arc-flag sweep-flag dx dy */
		let r2 = viewPort.sTranform(this.r);
		return "a " +
			r2.toPrecision(6) + " " +
			r2.toPrecision(6) + " " +
			" 0 " +
			(this.isLargeArc ? '1' : '0') + " " +
			(this.isPositiveSweep ? '1' : '0') + " " +
			viewPort.dxTranform(this.dx).toPrecision(6) + " " +
			viewPort.dyTranform(this.dy).toPrecision(6);
	}
}




export class SVG_Vec {
	/** @type{number} x */
	x = 0.0;

	/** @type{number} y */
	y = 0.0;

	constructor(){
	}
}
