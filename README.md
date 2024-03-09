
# solon graalvm native

本项目是一个 将`solon`打包成 native 可执行程序 的示例

## 1、环境要求
`graalvm 17` & `native-image`

### graalvm 17
官方安装文档：https://www.graalvm.org/latest/docs/getting-started/#install-graalvm

下载地址：https://github.com/graalvm/graalvm-ce-builds/releases

下载对应的版本，建议使用 sdkman ( 安装地址：[https://sdkman.io/](https://sdkman.io/) ) 来管理不同的jdk版本
```shell
# 最新版本为：17.0.8-graalce，可以在下载地址中查看最新版本
sdk install java 17.0.8-graalce

# 使用 17.0.8-graalce 版本
sdk use java 17.0.8-graalce
```

### native-image
官方安装文档：https://www.graalvm.org/latest/reference-manual/native-image/#install-native-image

```shell
gu install native-image
```

## 2、打包成 jar

```shell
mvn clean package -DskipTests
```

## 3、打包成 native 可执行程序

1. 引入依赖（本项目已经引入）

```xml
<!--solon aot start（用于 aot 时注册 native 元信息）-->
<dependency>
    <groupId>org.noear</groupId>
    <artifactId>solon.aot</artifactId>
</dependency>
<!--solon aot end-->
```

2. 激活 native 的 profile，执行`mvn`命令

```shell
sdk use java 17.0.7-graal

# 打包成native可执行程序
mvn clean native:compile -P native -DskipTests

# 运行可执行成
./target/solon-native-example
```

## 4、测试

```http request
GET http://localhost:8080/hello?name=solon

GET http://localhost:8080/hello/tml?name=solon

GET http://localhost:8080/htm/hello.htm
```

### remote

```http request
GET http://localhost:8080/rpc/v1/user/getById?userId=11
GET http://localhost:8080/rpc/v1/user/addOrder?orderId=12
```
响应：
```json
{
  "@type": "com.github.dudiao.solon.demo.User",
  "user_name": "dudiao",
  "wxid": "11"
}
```

### service 带缓存
    
```http request
GET http://localhost:8080/cache/say?msg=你好
```
响应：`I want say: 你好, now: 2023-04-15 17:01:09`

参数`msg`不变，响应不变，说明缓存生效

### Mybatis native

```http request
GET http://localhost:8080/user/1
```

## 5、关于 graalvm native 的一些说明

当使用一个新的第三方包时，不知道第三方包中哪些地方使用了反射等 graalvm 不支持的特性，可以使用`agentlib:native-image-agent`来生成配置文件，然后在`native-image`命令中引入配置文件，这样就可以解决第三方包中的问题了

```
-agentlib:native-image-agent=config-output-dir=/Users/xxx/study/solon-native-example/target/tracing-agent
```

## 6、三方包的一些不支持项

spring-boot 已经踩了很多坑了，可以作为参考：https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-with-GraalVM