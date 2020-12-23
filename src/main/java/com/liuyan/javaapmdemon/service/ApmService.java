package com.liuyan.javaapmdemon.service;

import co.elastic.apm.api.ElasticApm;
import co.elastic.apm.api.Span;
import co.elastic.apm.api.Transaction;
import com.liuyan.javaapmdemon.annotation.Esspan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApmService {

    @Autowired
    ApmService1 apmService1;


   public  void Method0_1000() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Method0_2000() {
        try {
            Method0_1000();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Method0_3000() {
        try {
            Method0_1000();
            Method0_2000();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Esspan
    public void Method0_4000() {
        int i=1/0;
    }
    @Esspan
    public void Method0_5000() {
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        apmService1.Method0_5001();
    }
    public void Method0_5001() {
        Span parent = ElasticApm.currentSpan();
        Span span=parent.startSpan();
        try {
            span.setName("Method0_5001");
            // do your thing...

            Thread.sleep(222);
        } catch (Exception e) {
            span.captureException(e);
        } finally {
            span.end();
        }
        Method0_5002();
    }
    public void Method0_5002() {
        Span parent = ElasticApm.currentSpan();
        Span span=parent.startSpan();
        try {
            span.setName("Method0_5002");
            // do your thing...

            Thread.sleep(333);
        } catch (Exception e) {
            span.captureException(e);
        } finally {
            span.end();
        }
        Method0_5003();
    }
    public void Method0_5003() {
        Span parent = ElasticApm.currentSpan();
        Span span=parent.startSpan();
        try {
            span.setName("Method0_5003");
            // do your thing...
            Thread.sleep(444);
        } catch (Exception e) {
            span.captureException(e);
        } finally {
            span.end();
        }
    }

    public void Method0_6000() {
        Transaction transaction = ElasticApm.startTransaction();
        try {
            transaction.setName("ApmController#Method0_6000");
            transaction.setType(Transaction.TYPE_REQUEST);
            // do your thing...

            Thread.sleep(1111);
        } catch (Exception e) {
            transaction.captureException(e);
        } finally {
            transaction.end();
        }
        Method0_6001();

    }
    void Method0_6001() {
        Span parent = ElasticApm.currentSpan();
        Span span=parent.startSpan();
        try {
            span.setName("Method0_6001");
            // do your thing...
            Thread.sleep(2222);
        } catch (Exception e) {
            span.captureException(e);
        } finally {
            span.end();
        }

    }
}
