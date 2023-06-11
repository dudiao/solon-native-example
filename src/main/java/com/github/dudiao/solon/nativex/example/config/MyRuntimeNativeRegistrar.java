package com.github.dudiao.solon.nativex.example.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;
import com.baomidou.mybatisplus.core.conditions.interfaces.Func;
import com.baomidou.mybatisplus.core.conditions.interfaces.Join;
import com.baomidou.mybatisplus.core.conditions.interfaces.Nested;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.aot.hint.ExecutableMode;
import org.noear.solon.aot.hint.MemberCategory;
import org.noear.solon.core.AopContext;
import org.noear.solon.core.util.ReflectUtil;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

/**
 * @author songyinyin
 * @since 2023/6/10 17:06
 */
@Component
public class MyRuntimeNativeRegistrar implements RuntimeNativeRegistrar {
  @Override
  public void register(AopContext context, RuntimeNativeMetadata metadata) {
    // mybatis plus
    metadata.registerDefaultConstructor(MybatisXMLLanguageDriver.class);
    metadata.registerReflection(MybatisConfiguration.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);
    registerAllDeclaredMethod(metadata, MybatisConfiguration.class, ExecutableMode.INVOKE);

    metadata.registerReflection(AbstractLambdaWrapper.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);

    metadata.registerJdkProxy(AbstractWrapper.DoSomething.class);
    metadata.registerReflection(AbstractWrapper.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);
    registerAllDeclaredMethod(metadata, AbstractWrapper.class, ExecutableMode.INVOKE);

    metadata.registerReflection(ISqlSegment.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);
    metadata.registerReflection(Wrapper.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);

    registerAllDeclaredMethod(metadata, Wrapper.class, ExecutableMode.INVOKE);

    metadata.registerReflection(Compare.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);
    metadata.registerReflection(Func.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);
    metadata.registerReflection(Join.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);
    metadata.registerReflection(Nested.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);

    metadata.registerReflection(LambdaQueryWrapper.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_METHODS,
      MemberCategory.INTROSPECT_PUBLIC_METHODS, MemberCategory.INTROSPECT_DECLARED_CONSTRUCTORS);
    registerAllDeclaredMethod(metadata, LambdaQueryWrapper.class, ExecutableMode.INVOKE);

    metadata.registerReflection(Query.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_PUBLIC_CONSTRUCTORS);

    registerAllDeclaredMethod(metadata, BaseMapper.class, ExecutableMode.INVOKE);

    metadata.registerSerialization(SerializedLambda.class);
    metadata.registerSerialization(SFunction.class);

    // mybatis
    metadata.registerJdkProxy(Executor.class);
    metadata.registerReflection(Executor.class, MemberCategory.INTROSPECT_PUBLIC_METHODS);
    registerAllDeclaredMethod(metadata, Executor.class, ExecutableMode.INVOKE);

    metadata.registerJdkProxy(StatementHandler.class);
    metadata.registerReflection(StatementHandler.class, MemberCategory.INTROSPECT_PUBLIC_METHODS);
    registerAllDeclaredMethod(metadata, StatementHandler.class, ExecutableMode.INVOKE);

    metadata.registerReflection(BoundSql.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INTROSPECT_DECLARED_METHODS, MemberCategory.INTROSPECT_DECLARED_CONSTRUCTORS);
    registerAllDeclaredMethod(metadata, BoundSql.class, ExecutableMode.INVOKE);

    metadata.registerReflection(Configuration.class, MemberCategory.DECLARED_FIELDS);
    registerAllDeclaredMethod(metadata, Configuration.class, ExecutableMode.INVOKE);
  }

  public void registerAllDeclaredMethod(RuntimeNativeMetadata metadata, Class<?> clazz, ExecutableMode mode) {
    Method[] declaredMethods = ReflectUtil.getDeclaredMethods(clazz);
    for (Method declaredMethod : declaredMethods) {
      metadata.registerMethod(declaredMethod, mode);
    }
  }
}
