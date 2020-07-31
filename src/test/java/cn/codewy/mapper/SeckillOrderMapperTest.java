package cn.codewy.mapper;

import cn.codewy.entity.SeckillOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @auther CodeWy
 * @date 2020/3/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeckillOrderMapperTest {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Test
    public void insertOrder() {
        int i = seckillOrderMapper.insertOrder(1l, 12247047);
        System.out.println(i);
    }

    @Test
    public void findById() {
        SeckillOrder seckillOrder = seckillOrderMapper.findById(1l, 1278177);
        System.out.println(seckillOrder.getSeckillId() + ": " + seckillOrder.getSeckill().getTitle());
    }
}