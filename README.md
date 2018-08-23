## Spring Boot几大特点：
* 自动配置（依赖于Spring4.0条件化配置实现，比如ConditionalOnMissingBean等，根据classpath中是否存在类文件自动声明bean）
* 起始依赖（不用过于关注需要哪些依赖包及版本兼容性，相当于依赖包组）
* 命令行界面（Spring Boot CLI - 无需传统的项目构建，只需写代码就能完成完整的应用程序）
* Actuator（窥视应用程序的内部情况，包括Spring应用上下文里配置的Bean、Spring Boot自动配置策略、内存用量、垃圾回收等）

## Spring Boot属性读取优先级

1. 命令行参数
2. java:comp/env里的JNDI属性
3. JVM系统属性
4. 操作系统环境变量
5. 随机生成的带random.*前缀的属性（在设置其他属性时，可以引用它们，比如${random.long}）
6. 应用程序以外的 application.properties 或 application.yml 文件
7. 打包在应用程序内的 application.properties 或 application.yml 文件
8. 通过@PropertySource标注的属性源
9. 默认属性

优先级依次递减，高优先级可以覆盖低优先级的相同属性。

## application.properties/application.yml存放位置

1. 外置，在相对于应用程序运行目录的/config子目录里
2. 外置，在应用程序运行的目录里
3. 内置，在ClassPath中的config文件夹里
4. 内置，在ClassPath根目录

优先级依次递减，高优先级可以覆盖低优先级的相同属性；在同一优先级位置同时有application.properties和application.yml，那么application.yml里的属性会覆盖application.properties里的属性。
