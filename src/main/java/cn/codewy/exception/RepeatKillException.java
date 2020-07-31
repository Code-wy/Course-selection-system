package cn.codewy.exception;

/**
 * 重复执行选课操作的异常（运行期异常）
 *
 * @auther CodeWy
 * @date 2020/3/8
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
