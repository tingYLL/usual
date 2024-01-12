package com.jdjm.zhy.testShortUrl;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

import java.util.concurrent.atomic.AtomicInteger;

import static javax.management.Query.TIMES;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MyShortUrl {

    private final AtomicInteger TIMES = new AtomicInteger(0);

    @GetMapping("/{shortKey}")
    public RedirectView redirec(@PathVariable("shortKey") String shortKey, HttpServletRequest httpServletRequest){
        String userAgentStr = httpServletRequest.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        if("123why".equals(shortKey)){
            log.info("短链:{}被访问第{}次,访问浏览器为:{},客户操作系统为:{}",
                    shortKey,TIMES.incrementAndGet(),userAgent.getBrowser().toString(),userAgent.getOperatingSystem().toString());
            if(TIMES.get() <= 1){
                return new RedirectView("https://activity.juejin.cn/rank/2023/writer/3702810893364350?utm_campaign=annual_2023&utm_medium=self_web_share&utm_source=why%E6%8A%80%E6%9C%AF");
            }
            if(TIMES.get() == 2){
                return new RedirectView("https://www.jianshu.com/p/57763c3f8db2");
            }
            return new RedirectView("/cheat");
        }
        return new RedirectView("notFound");
    }

    @GetMapping("cheat")
    public String cheat(){
        return "朋友,你想要兼职吗？日薪500,来下个APP吧~";
    }
}
