package cn.codewy.enums;

/**
 * @auther CodeWy
 * @date 2020/3/8
 */
public enum SeckillStatEnum {
    SUCCESS(1, "选课成功"),
    END(0, "选课结束"),
    REPEAT_KILL(-1,"重复选课"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据串改");

    private int state;
    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateOf(int index){
        for (SeckillStatEnum state : values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
