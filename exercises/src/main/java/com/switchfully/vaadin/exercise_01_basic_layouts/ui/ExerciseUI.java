package com.switchfully.vaadin.exercise_01_basic_layouts.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class ExerciseUI extends UI {

    @Autowired
    public ExerciseUI() {
    }

    @Override
    protected void init(VaadinRequest request) {
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button star = new Button("*");
        Button zero = new Button("0");
        Button pound = new Button("#");

        /*
         * WITH VERTICAL/HORIZONTAL LAYOUT
         * */

//        VerticalLayout content = new VerticalLayout();
//        content.setWidth("100px");
//        setContent(content);
//
//        HorizontalLayout topRow = new HorizontalLayout();
//        topRow.setWidth("100%");
//        content.addComponent(topRow);
//        topRow.addComponent(one);
//        topRow.addComponent(two);
//        topRow.addComponent(three);
//
//        HorizontalLayout secondRow = new HorizontalLayout();
//        secondRow.setWidth("100%");
//        content.addComponent(secondRow);
//        secondRow.addComponent(four);
//        secondRow.addComponent(five);
//        secondRow.addComponent(six);
//
//        HorizontalLayout thirdRow = new HorizontalLayout();
//        thirdRow.setWidth("100%");
//        content.addComponent(thirdRow);
//        thirdRow.addComponent(seven);
//        thirdRow.addComponent(eight);
//        thirdRow.addComponent(nine);
//
//        HorizontalLayout bottomRow = new HorizontalLayout();
//        bottomRow.setWidth("100%");
//        content.addComponent(bottomRow);
//        bottomRow.addComponent(star);
//        bottomRow.addComponent(zero);
//        bottomRow.addComponent(pound);


        /*
        * WITH GRID LAYOUT
        * */

        GridLayout gridContent = new GridLayout(3, 4, one, two, three, four, five, six, seven, eight, nine, star, zero, pound);
        gridContent.setWidth("100px");
        setContent(gridContent);

    }

}