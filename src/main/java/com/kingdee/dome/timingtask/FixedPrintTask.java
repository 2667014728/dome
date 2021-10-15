package com.kingdee.dome.timingtask;

import com.kingdee.dome.webapi.sdktest.CommonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FixedPrintTask {

    private int i;
    @Autowired
    private CommonTest commonTest;


    @Scheduled(cron = "*/15 * * * * ?")
    public void execute() {
        try {
            List<Map<String,Object>> mapList = new ArrayList<>();

            commonTest.assetsCardSaveCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
