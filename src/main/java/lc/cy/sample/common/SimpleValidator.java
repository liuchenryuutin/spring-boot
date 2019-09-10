package lc.cy.sample.common;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lc.cy.sample.model.SimpleModel;

@Component
public class SimpleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SimpleModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SimpleModel model = (SimpleModel) target;
		if ("test".equals(model.getName())) {
			errors.rejectValue("name", "9", "name is null");
		}

	}

}
