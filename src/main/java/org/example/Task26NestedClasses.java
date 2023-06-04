package org.example;

import java.nio.channels.Channel;

public class Task26NestedClasses {
    public static void main(String[] args) {

        TV tv = new TV("Samsung GQ-Q70BAT");
        TV.RemoteController controller= new TV.RemoteController(tv);

        controller.setOn(true);
        controller.addChannel();
        controller.addChannel();
        controller.on(0);
        controller.setOn(false);

    }
}