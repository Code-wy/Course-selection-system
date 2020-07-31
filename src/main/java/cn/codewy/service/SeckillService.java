package cn.codewy.service;

import cn.codewy.dto.Exposer;
import cn.codewy.dto.SeckillExecution;
import cn.codewy.entity.Seckill;
import cn.codewy.exception.RepeatKillException;
import cn.codewy.exception.SeckillCloseException;
import cn.codewy.exception.SeckillException;

import java.math.BigDecimal;
import java.util.List;

/**
 * 业务接口：应该站在"使用者"的角度设计，比如：
 * 1.定义方法的颗粒度要细
 * 2.方法的参数要明确且简练，不建议用类似Map这种让使用者封装一堆参数传递过来
 * 3.方法的return类型，除了要明确返回值类型，还应该指定该方法可能抛出的异常
 *
 * @auther CodeWy
 * @date 2020/3/6
 */
public interface SeckillService {

    /**
     * 获取所有的课程列表
     *
     * @return
     */
    List<Seckill> findAll();

    /**
     * 获取某一条课程的信息
     *
     * @param seckillId
     * @return
     */
    Seckill findById(long seckillId);

    /**
     * 选课开始时输出暴露选课的地址
     * 否者输出系统时间和选课时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行选课的操作
     *
     * @param seckillId
     * @param userSno
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userSno, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;


}
