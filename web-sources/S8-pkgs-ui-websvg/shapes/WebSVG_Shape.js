


import { S8WebFront } from "/S8-pkgs-ui-carbide/S8WebFront.js";

import { WebSVG, WebSVG_Viewport } from "/S8-pkgs-ui-websvg/WebSVG.js";
import { WebSVG_Element } from "/S8-pkgs-ui-websvg/WebSVG_Element.js";



S8WebFront.CSS_import("/S8-pkgs-ui-websvg/WebSVG.css");


/**
 * 
 */
export class WebSVG_Shape extends WebSVG_Element {



	/**
	 * @type{String} the css suffix for the solid style
	 */
	strokeSolidityStyle = WebSVG.STROKE_SOLIDITY_DEFAULT;


	/**
	 * @type{number}
	 * -1 : disabled
	 */
	strokeThickness = -1;

	strokeSolidity = "SOLID";


	constructor() {
		super();
	}



	setDefaultStroke() {
		this.SVG_node.classList.add("websvg-element");
		this.SVG_node.setAttribute("stroke", "black");
		this.SVG_node.setAttribute("stroke-width", "1");
	}


	/**
	 * 
	 * @param {WebSVG_Viewport} viewport 
	 */
	updateStroke(viewport) {
		let thickness = 0.08 * viewport.sTranform(this.strokeThickness);
		this.SVG_node.setAttribute("stroke-width", thickness);
	}



	/**
	 * 
	 * @returns 
	 */
	getEnvelope() {
		return this.SVG_node;
	}


	/**
	 * 
	 * @param solidity
	 */
	S8_set_strokeSolidity(code) {
		if(code != WebSVG.DISABLED_FEATURE_CODE){
			this.SVG_node.setAttribute("stroke-dasharray", WebSVG.getStrokeSolidityByCode(code));
		}
		else{
			this.SVG_node.removeAttribute("stroke-dasharray");
		}
	}


	/**
	 * 
	 * @param {number} value 
	 */
	S8_set_strokeThickness(code) {
		if(code != WebSVG.DISABLED_FEATURE_CODE){
			let thickness = WebSVG.getStrokeThicknessByCode(code);
			this.strokeThickness = thickness;
			this.SVG_node.setAttribute("stroke-width", thickness);
		}
		else{
			this.SVG_node.removeAttribute("stroke-width");
		}
	}


	/**
	 * 
	 * @param {number} color
	 */
	S8_set_strokeColor(code) {
		if(code != WebSVG.DISABLED_FEATURE_CODE){
			this.SVG_node.setAttribute("stroke", WebSVG.getStrokeColorByCode(code));
		}
		else{
			this.SVG_node.setAttribute("stroke", "none");
		}
	}


	/**
	 * 
	 * @param {number} color
	 */
	S8_set_fillColor(code) {
		if(code != WebSVG.DISABLED_FEATURE_CODE){
			this.SVG_node.setAttribute("fill", WebSVG.getFillColorByCode(code));
		}
		else{
			this.SVG_node.setAttribute("fill", "none");
		}
	}




	requestRedraw() {
		if (this.canvas != null) {
			// notify required redrawing
			this.canvas.isRedrawingRequired = true;
		}
	}


	S8_render() { /* no post-processing */ }

	S8_dispose() {  /* nothing to dispose */ }
}