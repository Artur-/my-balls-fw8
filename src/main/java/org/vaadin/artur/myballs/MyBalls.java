package org.vaadin.artur.myballs;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.annotations.JavaScript;
import com.vaadin.shared.Registration;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.util.ReflectTools;

@JavaScript("vaadin://bower_components/webcomponentsjs/webcomponents-lite.min.js")
@HtmlImport("vaadin://bower_components/my-balls/my-balls.html")
@JavaScript("my-balls.js")
public class MyBalls extends AbstractJavaScriptComponent {

    public interface BallClickListener extends Serializable {
        public static final Method BUTTON_CLICK_METHOD = ReflectTools
                .findMethod(BallClickListener.class, "buttonClick",
                        BallClickEvent.class);

        public void buttonClick(BallClickEvent event);

    }

    public static class BallClickEvent extends ClickEvent {

        private final String color;

        public BallClickEvent(MyBalls source, String color) {
            super(source);
            this.color = color;
        }

        public String getColor() {
            return color;
        }

    }

    public MyBalls() {
        addFunction("onClick", arguments -> {
            String color = arguments.getString(0);
            fireEvent(new BallClickEvent(this, color));
        });

    }

    public Registration addClickListener(BallClickListener listener) {
        return addListener(BallClickEvent.class, listener,
                BallClickListener.BUTTON_CLICK_METHOD);
    }
}
