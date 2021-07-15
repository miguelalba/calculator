package com.github.miguelalba.calculator;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {

    private static final Logger log = LoggerFactory.getLogger(MainView.class);

    public MainView(@Autowired RestClientService service) {

        FormLayout operationLayout = new FormLayout();

        NumberField firstOperandField = new NumberField("A");
        firstOperandField.setHasControls(true);

        Select<String> operatorSelect = new Select<>("+", "-");
        operatorSelect.setLabel("Operator");

        NumberField secondOperandField = new NumberField("B");
        secondOperandField.setHasControls(true);

        operationLayout.add(firstOperandField, operatorSelect, secondOperandField);

        Button calculateButton = new Button("Calculate!");

        // Result layout
        HorizontalLayout resultLayout = new HorizontalLayout();
        Label resultLabel = new Label("Result");
        Label actualResult = new Label("<>");
        resultLayout.add(resultLabel, actualResult);

        calculateButton.addClickListener((event) -> {

            // Leave if a form is empty.
            if (operatorSelect.isEmpty() || firstOperandField.isEmpty() || secondOperandField.isEmpty())
                return;

            String operator = operatorSelect.getValue();
            int a = firstOperandField.getValue().intValue();
            int b = secondOperandField.getValue().intValue();
            int newResult = service.calculateOperation(operator, a, b);

            actualResult.setText(Integer.toString(newResult));
        });

        add(new H1("Calculator demo"),
                operationLayout,
                calculateButton,
                resultLayout);
    }
}
