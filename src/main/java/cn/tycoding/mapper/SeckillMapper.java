package cn.tycoding.mapper;

import cn.tycoding.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @auther CodeWy
 * @date 2020/3/6
 */
@Mapper
public interface SeckillMapper {

    /**
     * 查询所有课程的记录信息
     *
     * @return
     */
    List<Seckill> findAll();

    /**
     * 根据主键查询当前课程的数据
     *
     * @param id
     * @return
     */
    Seckill findById(long id);

    /**
     * 减库存。
     * 对于Mapper映射接口方法中存在多个参数的要加@Param()注解标识字段名称，不然Mybatis不能识别出来哪个字段相互对应
     *
     * @param seckillId 课程ID
     * @param killTime  选课时间
     * @return 返回此SQL更新的记录数，如果>=1表示更新成功
     */
    int reduceStock(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
}
