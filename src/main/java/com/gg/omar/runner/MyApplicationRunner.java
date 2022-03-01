package com.gg.omar.runner;

import com.gg.omar.oshi.HardwareInformation;
import com.gg.omar.udp.UDPClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String memoryUsage = HardwareInformation.getMemoryUsage();
                String cpuUsage = null;
                try {
                    cpuUsage = HardwareInformation.getCPUUsage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(cpuUsage + "," + memoryUsage);
                UDPClient.send(cpuUsage + "," + memoryUsage);
            }
        }, 1000, 2000);


    }

}
