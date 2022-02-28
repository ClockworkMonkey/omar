package com.gg.omar.runner;

import com.gg.omar.oshi.HardwareInformation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String memoryUsage = HardwareInformation.getMemoryUsage();
        String cpuUsage = HardwareInformation.getCPUUsage();
        System.out.println(memoryUsage);
        System.out.println(cpuUsage);
    }

}
