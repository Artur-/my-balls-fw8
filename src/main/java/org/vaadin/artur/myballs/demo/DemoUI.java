package org.vaadin.artur.myballs.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.artur.myballs.MyBalls;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
        final MyBalls balls = new MyBalls();
        balls.addClickListener(e -> {
            Notification.show("You clicked on the " + e.getColor() + " button");
        });

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.addComponent(balls);
        layout.setComponentAlignment(balls, Alignment.MIDDLE_CENTER);
        setContent(layout);
    }
}
