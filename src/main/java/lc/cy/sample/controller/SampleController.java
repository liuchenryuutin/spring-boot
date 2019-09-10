package lc.cy.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lc.cy.sample.common.SampleValidator;
import lc.cy.sample.model.SimpleModel;

@RestController
public class SampleController {

	@Autowired
	SampleValidator validator;

	@RequestMapping("/sample")
	public String first(SimpleModel model) {
		return "Hello sample";
	}

	@InitBinder
	public void bindValidator(WebDataBinder dataBinder) {
		dataBinder.addValidators(validator);
	}
}
