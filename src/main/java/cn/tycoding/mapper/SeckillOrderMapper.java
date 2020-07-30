package cn.tycoding.mapper;

import cn.tycoding.entity.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @auther CodeWy
 * @date 2020/3/8
 */
@Mapper
public interface SeckillOrderMapper {

    /**
     * 插入选课清单明细
     *
     * @param seckillId 选课课程ID
     * @param userSno 学生
     * @return 返回该SQL更新的记录数，如果>=1则更新成功
     */
    int insertOrder(@Param("seckillId") long seckillId, @Param("userSno") long userSno);

    /**
     * 根据课程ID查询清单明细数据并得到对应选课课程的数据，因为我们再SeckillOrder中已经定义了一个Seckill的属性
     *
     * @param seckillId
     * @param userSno
     * @return
     */
    SeckillOrder findById(@Param("seckillId") long seckillId, @Param("userSno") long userSno);
}
