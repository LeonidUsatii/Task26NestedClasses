package org.example;

import java.util.Random;

public class TV {
    private final String name;

    private Channel channel;
    private final Channel[] channels;
    private Boolean isOn;
    private int count;

    public TV(String name) {
        if (name != null && !name.equals("")) {
            this.name = name;
        } else {
            this.name = "NO NUMBER";
        }
        this.channels = new Channel[65];
        this.isOn = false;
    }

    public void setIsOn(Boolean on) {
        if (on) {
            System.out.println("Я телевизор " + name + " включён ");
        } else {
            System.out.println("Я телевизор " + name + " выключен ");
        }
    }

    public void addChannel() {
        if (count < channels.length) {
            this.channels[count] = new Channel();
            this.count++;
        } else {
            System.err.println("Все каналы заняты");
        }
    }

    public void on(int channelNumber) {
        Random random = new Random();
        Channel channel = null;
        if (channelNumber >= 0 && channelNumber < channels.length) {
            channel = channels[channelNumber];
        } else {
            System.out.println("Такого канала нет");
        }
        if (channelNumber < count) {

            Channel.Program program = channels[channelNumber].
                    programs[random.nextInt(1, channel.programs.length)];

            System.out.println("Я телевизор " + name + " показываю программу " +
                    program.name + " на канале " + channelNumber);
        } else {
            System.out.println("Такого канала нет");
        }

    }

    public static class RemoteController {
        private final TV tv;

        public RemoteController(TV tv) {

            this.tv = tv;
        }
        public void setOn(Boolean on) {
            tv.setIsOn(on);
        }
        public void addChannel() {
            tv.addChannel();
        }
        public void on(int channelNumber) {
            tv.on(channelNumber);
        }
    }

    public static class Channel {
        private final Program[] programs;

        public Channel() {
            this.programs = setPrograms();
        }

        public Program[] setPrograms() {
            Program[] programs = new Program[15];
            for (int i = 0; i < 15; i++) {
                programs[i] = new Program("Program " + (i + 1));
            }
            return programs;
        }

        public static class Program {
            private final String name;

            public Program(String name) {
                if (name != null && !name.equals("")) {
                    this.name = name;
                } else {
                    this.name = "NO NUMBER";
                }
            }
        }
    }
}
