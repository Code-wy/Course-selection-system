package cn.tycoding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于做页面映射跳转的控制层
 *
 * @auther CodeWy
 * @date 2020/3/8
 */
@Controller
public class BaseController {

    /**
     * 跳转到课程列表页
     *
     * @return
     */
    @RequestMapping("/seckill")
    public String seckillGoods() {
        return "redirect:/seckill/list";
    }

}
