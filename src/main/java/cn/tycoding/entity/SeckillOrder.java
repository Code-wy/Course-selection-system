package cn.tycoding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 选课清单表（秒杀订单表和其他订单表不同，属于独立的模块）
 *
 * @auther CodeWy
 * @date 2020/3/6
 */
public class SeckillOrder implements Serializable {

    private long seckillId; //课程ID
    private long userSno; //选课学生学号

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime; //创建时间

    private boolean status; //订单状态， -1:无效 0:成功 1:已付款

    private Seckill seckill; //选课的课程，和清单是一对多的关系

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }


    public long getUserSno() {
        return userSno;
    }

    public void setUserSno(long userSno) {
        this.userSno = userSno;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SeckillOrder{" +
                "seckillId=" + seckillId +
                ", createTime=" + createTime +
                ", status=" + status +
                ", seckill=" + seckill +
                '}';
    }
}
