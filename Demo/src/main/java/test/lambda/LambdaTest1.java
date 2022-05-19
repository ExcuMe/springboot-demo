package test.lambda;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda表达式测试
 * @author wuyj38634
 * @date 2022/5/16
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(StringUtils::getFilename);

        //无参数无返回
        NoReturnNoParam noReturnNoParam = () ->{
            System.out.println("无参数无返回");
            return;
        };
        noReturnNoParam.method();

        // 一参数无返回
        NoReturnOneParam noReturnOneParam = (a) ->{
            System.out.println("一参数无返回：" + a);
        };
        noReturnOneParam.method(2);

        // 多参数无返回
        NoReturnMultiParam noReturnMultiParam = (a, b) -> {
            System.out.println("多参数无返回：" + (a + b));
        };
        noReturnMultiParam.method(1 , 2);

        // 无参数有返回
        ReturnNoParam returnNoParam = () -> 0;
        System.out.println("无参数有返回:" + returnNoParam.method());

        ReturnOneParam returnOneParam = a -> a;
        System.out.println("一参数有返回:" + returnOneParam.method(1));

        ReturnMultiParam returnMultiParam = Integer::sum;
        System.out.println("多参数有返回" + returnMultiParam.method(1, 3));


    }
}
