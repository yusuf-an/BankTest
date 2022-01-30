package com.challange.temperatureCalculator.controller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.Document;

import com.challange.temperatureCalculator.Model.CalculatorPojo;

@Controller
public class TempratureController {

	@PostMapping("/calculator")
	public String convertTemp(@ModelAttribute CalculatorPojo calculatorPojo, Model model) {
		if (calculatorPojo.getFrom().equals(calculatorPojo.getTo())) {
			calculatorPojo.setCalculated(calculatorPojo.getValue());
			model.addAttribute("calculator", calculatorPojo);
			return "calculator";
		}
		String fooResourceUrl = "https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property="
				+ calculatorPojo.getFrom() + "&val=" + calculatorPojo.getValue();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fooResourceUrl);
			doc.getDocumentElement().normalize();
			double calculated = Double
					.parseDouble(doc.getElementsByTagName(calculatorPojo.getTo()).item(0).getTextContent());
			calculatorPojo.setCalculated(calculated);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("calculator", calculatorPojo);
		return "calculator";
	}

	@GetMapping("/calculator")
	public String calulator(@ModelAttribute CalculatorPojo calculatorPojo, Model model) {
		model.addAttribute("calculator", calculatorPojo);
		return "calculator";
	}	

}