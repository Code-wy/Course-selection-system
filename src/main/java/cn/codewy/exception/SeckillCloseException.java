package cn.codewy.exception;

/**
 * 选课关闭异常
 * @auther CodeWy
 * @date 2020/3/8
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
