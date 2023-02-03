package com.example.springrabbitmqdemo.controller;


import com.example.springrabbitmqdemo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenx
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/test")
@Slf4j
@Api(tags = "测试管理接口")
@RequiredArgsConstructor
public class TestController {

    private  final TestService testService;

    @ApiOperation(value = "test")
    @GetMapping(value = "/test")
    public String selectPage(@RequestParam String exChange,@RequestParam String routingKey,@RequestParam String msg) {
        testService.testSendMessage(exChange, routingKey, msg);
        return "成功";
    }

}
