package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import nso.Controller;
import nso.SplashScr;
import nso.RMS;
import nso.Res;
import nso.SelectServerScr;
import nso.Service;
import nso.Session_ME;

public class GameMidlet extends MIDlet {

    public static byte CLIENT_TYPE = 1;

    public static byte indexClient = 0;

    public static int PORT = 14444;

    public static String IP = "";

    public static byte userProvider = 0;

    public static String clientAgent;

    private static GameCanvas gameCanvas;

    public static GameMidlet instance;

    public static byte serverLogin = 0;

    public static boolean isWorldver = false;

    public static String latitude = "";

    public static String longitude = "";

    private static String smartPhone = "Tekkan(New):nj9.teamobi.com:14445:0:0,Fukiya:nj5.teamobi.com:14444:3:0,Sensha:27.0.14.122:14444:0:0,Tone:nj5.teamobi.com:14444:0:0,Bokken:nj1.teamobi.com:14444:0:0,Shuriken:nj2.teamobi.com:14444:0:0,Tessen:nj2.teamobi.com:14444:1:0,Kunai:nj4.teamobi.com:14444:0:0,Katana:nj3.teamobi.com:14444:0:0,Sanzu:nj5.teamobi.com:14444:1:0,Hirosaki:nj6.teamobi.com:14444:0:1,Haruna (NEW):nj8.teamobi.com:14444:0:1";

    private static String java = "Tone:nj5.teamobi.com:14444:0:0,Bokken:nj1.teamobi.com:14444:0:0,Shuriken:nj2.teamobi.com:14444:0:0,Tessen:nj2.teamobi.com:14444:1:0,Kunai:nj4.teamobi.com:14444:0:0,Katana:nj3.teamobi.com:14444:0:0,Global-1:nj6.teamobi.com:14444:0:1";

    public static String[] nameServer;

    public static String[] ipList;

    public static short[] portList;

    public static byte[] serverLoginList;

    public static byte[] language;

    public static byte[] serverST;

    public GameMidlet() {
        MotherCanvas.instance = new MotherCanvas();
        Session_ME.gI().setHandler(Controller.gI());
        instance = this;
        (main.GameMidlet.gameCanvas = new GameCanvas()).startGameLoop();
        clientAgent = this.readFileText("agent.txt");
        main.GameMidlet.userProvider = Byte.parseByte(this.readFileText("provider.txt"));
        System.out.println("AGENT: " + clientAgent + ", PROVIDER: " + main.GameMidlet.userProvider);
        SplashScr.splashScrStat = 0;
        GameCanvas.currentScreen = new SplashScr();
    }

    protected void destroyApp(boolean flag) {
    }

    protected void pauseApp() {
    }

    protected void startApp() {
        Display.getDisplay(this).setCurrent(MotherCanvas.instance);
    }

    public final void exit() {
        GameCanvas.bRun = false;
        System.gc();
        this.notifyDestroyed();
    }

    public static void openUrlAndExit(String text) {
        if (!text.equals("")) {
            try {
                instance.platformRequest(text);
                instance.notifyDestroyed();
            } catch (ConnectionNotFoundException connectionNotFoundException) {
                connectionNotFoundException.printStackTrace();
            }
        }
    }

    private String readFileText(String fileName) {
        String text;
        InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            text = new String(data, "UTF-8");
        } catch (Exception exception) {
            text = "";
        }
        return text;
    }

    public final void sendGPS() {
        Service.gI().sendGPS();
    }

    private static void saveIP() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(main.GameMidlet.nameServer.length);
            for (int index = 0; index < main.GameMidlet.nameServer.length; index++) {
                dataOutputStream.writeUTF(main.GameMidlet.nameServer[index]);
                dataOutputStream.writeUTF(main.GameMidlet.ipList[index]);
                dataOutputStream.writeShort(portList[index]);
                dataOutputStream.writeByte(main.GameMidlet.serverLoginList[index]);
                dataOutputStream.writeByte(main.GameMidlet.language[index]);
                dataOutputStream.writeByte(main.GameMidlet.serverST[index]);
            }
            RMS.saveRMS("NJlink", byteArrayOutputStream.toByteArray());
            dataOutputStream.close();
            SelectServerScr.loadIP();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void getStrSv() {
        String text = null;
        if (CLIENT_TYPE == 1) {
            text = connectHTTP("http://teamobi.com/srvips/NJVI.txt");
        } else {
            text = connectHTTP("http://teamobi.com/srvips/NJEN.txt");
        }
        text = (String) text;
        try {
            if (text.equals("")) {
                if (CLIENT_TYPE == 1) {
                    text = smartPhone;
                } else {
                    text = java;
                }
            }
            String[] textLines;
            main.GameMidlet.nameServer = new String[(textLines = Res.split(text.trim(), ",", 0)).length];
            main.GameMidlet.ipList = new String[textLines.length];
            portList = new short[textLines.length];
            main.GameMidlet.serverLoginList = new byte[textLines.length];
            main.GameMidlet.language = new byte[textLines.length];
            main.GameMidlet.serverST = new byte[textLines.length];
            byte byteValue = 0;
            byte byteValue1 = 0;
            for (int index = 0; index < textLines.length; index++) {
                String[] textLines2 = Res.split(textLines[index].trim(), ":", 0);
                main.GameMidlet.nameServer[index] = textLines2[0];
                main.GameMidlet.ipList[index] = textLines2[1];
                portList[index] = Short.parseShort(textLines2[2]);
                main.GameMidlet.serverLoginList[index] = Byte.parseByte(textLines2[3]);
                main.GameMidlet.language[index] = Byte.parseByte(textLines2[4]);
                if (main.GameMidlet.language[index] == 0) {
                    main.GameMidlet.serverST[index] = byteValue++;
                } else if (main.GameMidlet.language[index] == 1) {
                    main.GameMidlet.serverST[index] = byteValue1++;
                }
            }
            saveIP();
        } catch (Exception exception) {
            main.GameMidlet.nameServer = new String[] { "Sensha (New)", "Sanzu", "Tone", "Bokken", "Shuriken", "Tessen", "Kunai", "Katana", "Hirosaki", "Haruna (NEW)" };
            main.GameMidlet.ipList = new String[] { "27.0.12.11", "112.213.84.83", "112.213.94.205", "112.213.84.18", "27.0.14.73", "27.0.14.73", "112.213.94.135", "112.213.94.161", "52.221.222.194", "54.255.61.194", "54.151.133.77" };
            portList = new short[] { 14444, 14444, 14444, 14444, 14444, 14444, 14444, 14444, 14444, 14444 };
            main.GameMidlet.serverLoginList = new byte[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 };
            main.GameMidlet.language = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 };
            main.GameMidlet.serverST = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 0, 1 };
            saveIP();
        }
    }

    public static void loadLinkRMS() {
        byte[] data;
        if ((data = RMS.loadRMS("NJlink")) == null) {
            getStrSv();
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            try {
                byte byteValue;
                main.GameMidlet.nameServer = new String[byteValue = dataInputStream.readByte()];
                main.GameMidlet.ipList = new String[byteValue];
                portList = new short[byteValue];
                main.GameMidlet.serverLoginList = new byte[byteValue];
                main.GameMidlet.language = new byte[byteValue];
                main.GameMidlet.serverST = new byte[byteValue];
                for (int index = 0; index < byteValue; index++) {
                    main.GameMidlet.nameServer[index] = dataInputStream.readUTF();
                    main.GameMidlet.ipList[index] = dataInputStream.readUTF();
                    portList[index] = dataInputStream.readShort();
                    main.GameMidlet.serverLoginList[index] = dataInputStream.readByte();
                    main.GameMidlet.language[index] = dataInputStream.readByte();
                    main.GameMidlet.serverST[index] = dataInputStream.readByte();
                }
                dataInputStream.close();
                SelectServerScr.loadIP();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static int GetWorldIndex() {
        byte byteValue = 0;
        if (main.GameMidlet.isWorldver) {
            byteValue = 1;
        }
        for (int index = 0; index <= main.GameMidlet.language.length - 1; index++) {
            if (main.GameMidlet.language[index] == byteValue) {
                return index;
            }
        }
        return 0;
    }

    public static int GetLastIndex() {
        for (int index = 0; index <= main.GameMidlet.language.length - 1; index++) {
            if (main.GameMidlet.language[index] == 1) {
                return index - 1;
            }
        }
        return 0;
    }

    private static String connectHTTP(String link) {
        int value;
        HttpConnection httpConnection = null;
        httpConnection = null;
        String text = "";
        try {
            if ((httpConnection = (HttpConnection) Connector.open(link)).getResponseCode() != 200) {
                throw new IOException(httpConnection.getResponseMessage());
            }
            InputStream inputStream = httpConnection.openInputStream();
            new InputStreamReader(inputStream, "utf-8");
            while ((value = inputStream.read()) != -1) {
                text = text + (char) value;
            }
        } catch (Exception exception) {
            text = null;
        }
        return text;
    }
}
