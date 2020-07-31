package cn.codewy.exception;

/**
 * 选课相关的异常
 *
 * @auther CodeWy
 * @date 2020/3/8
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
