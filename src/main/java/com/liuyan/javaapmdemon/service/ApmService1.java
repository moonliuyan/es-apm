package com.liuyan.javaapmdemon.service;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Span;
import co.elastic.apm.api.Transaction;
import com.liuyan.javaapmdemon.annotation.Esspan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApmService1 {

    @Autowired
    ApmService2 apmService2;

    @Esspan
    public void Method0_5001() {
        try {

            Thread.sleep(222);
        } catch (Exception e) {
            e.printStackTrace();
        }
        apmService2.Method0_5002();
    }

}
