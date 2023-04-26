
# solon graalvm native

本项目是一个 将`solon`打包成 native 可执行程序 的示例

## 1、环境要求
`graalvm 17` & `native-image`


### graalvm 17
官方安装文档：https://www.graalvm.org/latest/docs/getting-started/#install-graalvm

下载地址：https://github.com/graalvm/graalvm-ce-builds/releases

下载对应的版本，建议使用 sdkman ( 安装地址：[https://sdkman.io/](https://sdkman.io/) ) 来管理不同的jdk版本
```shell
# 最新版本为：22.3.1.r17-grl，可以在下载地址中查看最新版本
sdk install java 22.3.1.r17-grl

# 使用22.3.1.r17-grl版本
sdk use java 22.3.1.r17-grl
```

### native-image
官方安装文档：https://www.graalvm.org/latest/reference-manual/native-image/#install-native-image

```shell
gu install native-image
```

## 2、打包成 jar

```shell
mvn clean package
```

## 3、打包成 native 可执行程序

1. 引入依赖（本项目已经引入）

```xml
<!--solon native start-->
<!--aot 注册native元信息-->
<dependency>
    <groupId>org.noear</groupId>
    <artifactId>solon.aot</artifactId>
</dependency>
<!--solon native end-->
```

2. 激活 native 的 profile，执行`mvn`命令

```shell
sdk use java 22.3.1.r17-grl

# 打包成native可执行程序
mvn clean native:compile -P native

# 运行可执行成
./target/solon-native-example
```

## 4、测试

```http request
GET http://localhost:8080/hello?name=solon
GET http://localhost:8080/hello/tml?name=solon
GET http://localhost:8080/jquery.min.js
GET http://localhost:8080/htm/hello.htm
```

### remote

```http request
GET http://localhost:8080/rpc/v1/user/getById?userId=11
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
