# SpringBootDemo
## 功能
12. 添加sax解析xml demo。sax需要实现接口，sax解析回调实现类。sax不会把整个文档加载到内存，只会加载部分，dom需要加载整个文档  
11. FactoryBean demo
10. ProxyFactory demo
9. InitializingBean demo. bean属性设置完成，可以react 在初始化一次
8. FactoryBean Demo, Factory bean 是产生bean的bean. getBean()拿到的不是bean本身，是bean生成的bean
7. c3p0 demo
6. 拦截器demo
5. spring boot aop demo
4. web server localhost:8080 输出Greetings from Spring Boot
3. 加载配置文件使用@Value注解
2. 获取spring 封装的Environment对象，运行时环境，和加载的配置信息
1. 配置文件名、文件扩展名ConfigFileApplicationListener写死了，application，扩展名 xml, properties.因此gxf.properties的配置没有加载