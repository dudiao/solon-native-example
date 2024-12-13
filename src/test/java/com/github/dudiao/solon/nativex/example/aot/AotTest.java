package com.github.dudiao.solon.nativex.example.aot;

import com.github.dudiao.solon.nativex.example.App;
import com.github.dudiao.solon.nativex.example.controller.TestController;
import org.junit.jupiter.api.Test;
import org.noear.solon.test.SolonTest;
import org.noear.solon.test.aot.RuntimeNativeMetadataAssert;

/**
 * native 编译时的测试用例
 *
 * @author songyinyin
 * @since 2024/12/13 上午9:31
 */
@SolonTest(isAot = true, classes = App.class)
public class AotTest {

    @Test
    public void test() {
        RuntimeNativeMetadataAssert.hasLambdaSerializationType(TestController.class);
    }
}
