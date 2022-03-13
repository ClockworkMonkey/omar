package com.gg.omar.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {

    public static void send(String message) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.0.177", 8001);
        byte[] messageBytes = message.getBytes();
        try (DatagramSocket datagramSocket = new DatagramSocket(8000)) {
            DatagramPacket datagramPacket = new DatagramPacket(messageBytes, messageBytes.length, inetSocketAddress);
            datagramSocket.send(datagramPacket);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
}
