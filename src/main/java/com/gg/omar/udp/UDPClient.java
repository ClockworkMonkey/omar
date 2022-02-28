package com.gg.omar.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {

    public void send(String message) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("10.134.229.68", 8010);
        byte[] messageBytes = message.getBytes();
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            DatagramPacket datagramPacket = new DatagramPacket(messageBytes, messageBytes.length, inetSocketAddress);
            datagramSocket.send(datagramPacket);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
}
