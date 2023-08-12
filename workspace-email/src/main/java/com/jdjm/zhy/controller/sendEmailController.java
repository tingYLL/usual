package com.jdjm.zhy.controller;


//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.RequiredArgsConstructor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;



@RestController("/jdjm")
@Slf4j
@RequiredArgsConstructor
@Api(tags="发送邮件")
public class sendEmailController {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String account;



    @PostMapping("sendOrdinaryEmail")
    @ApiOperation("发送简单邮件")
    public String sendPuTongYouJian(@ApiParam("邮件地址")  @RequestParam(name="address") String address,
                                  @RequestParam(name="subject") String subject,
                                  @RequestParam(name="body") String body){
        System.out.println("account:"+account);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(account);
        simpleMailMessage.setTo(address);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
        return "发送成功!";
    }

    @PostMapping("sendAttachMentEmail")
    @ApiOperation("")
    public String sendAttachMentEmail(@ApiParam("邮件地址")  @RequestParam(name="address") String address,
                                      @ApiParam("邮件标题") @RequestParam(name="subject") String subject,
                                      @ApiParam("邮件正文") @RequestParam(name="body") String body,
                                      @ApiParam("附件") MultipartFile attachment) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(account);
        mimeMessageHelper.setTo(address);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        byte[] bytes = attachment.getBytes();
        String name = attachment.getName()+".png";
        log.info("name:{}",name);
        mimeMessageHelper.addAttachment(name,new ByteArrayResource(bytes));
        javaMailSender.send(mimeMessage);
        return "发送成功";

    }
}
