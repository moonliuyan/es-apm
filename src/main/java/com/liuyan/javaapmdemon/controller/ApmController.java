package com.liuyan.javaapmdemon.controller;

import com.liuyan.javaapmdemon.ResponseEntity;
import com.liuyan.javaapmdemon.service.ApmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @user:liuyan
 * @date:2020/7/31 0031 20:47
 * @desc: ┏┛ ┻━━━━━┛ ┻┓
 * ┃　　　　　　 ┃
 * ┃　　　━　　　┃
 * ┃　┳┛　  ┗┳　┃
 * ┃　　　　　　 ┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　 ┃
 * ┗━┓　　　┏━━━┛
 * ┃　　　┃   Code is far away from bug with the animal protecting
 * ┃　　　┃
 * ┃　　　┗━━━━━━━━━┓
 * ┃　　　　　　　    ┣┓
 * ┃　　　　         ┏┛
 * ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * ┃ ┫ ┫   ┃ ┫ ┫
 * ┗━┻━┛   ┗━┻━┛
 */
@RestController
@RequestMapping("/apm")
public class ApmController {
    @Autowired
    ApmService apmService;


    @RequestMapping("api1")
    public ResponseEntity<String> Api1() {
        ResponseEntity<String> resultEntity=new ResponseEntity<String>(200,"ok","Hello Api 111111111");

        apmService.Method0_1000();
        return resultEntity;
    }

    @RequestMapping("api2")
    public ResponseEntity<String>  Api2() throws InterruptedException {
        ResponseEntity<String> resultEntity=new ResponseEntity<String>(200,"ok","Hello Api 2222222222");

        apmService.Method0_2000();
        return resultEntity;
    }

    @RequestMapping("api3")
    public ResponseEntity<String>  Api3() throws InterruptedException {
        ResponseEntity<String> resultEntity=new ResponseEntity<String>(200,"ok","Hello Api 33333333");

        apmService.Method0_3000();
        return resultEntity;
    }

    @RequestMapping("api4")
    public ResponseEntity<String>  Api4() throws InterruptedException {
        ResponseEntity<String> resultEntity=new ResponseEntity<String>(200,"ok","Hello Api 44444444444");

        apmService.Method0_4000();
        return resultEntity;
    }

    @RequestMapping("api5")
    public ResponseEntity<String>  Api5() throws InterruptedException {
        ResponseEntity<String> resultEntity=new ResponseEntity<String>(200,"ok","Hello Api 555555555");

        apmService.Method0_5000();
        return resultEntity;
    }

}