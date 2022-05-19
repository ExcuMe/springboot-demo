package test.lambda;

/**
 * 多参数无返回接口
 * @author wuyj38634
 * @date 2022/5/16
 */
@FunctionalInterface
public interface NoReturnMultiParam {
    void method(int a, int b);
}
