# zipkinDemo
springboot+rabbitmq+zipkin+elasticsearch
# zipkinDemo
springboot+rabbitmq+zipkin+elasticsearch
Sleuth进行消息追踪，SpringCloud Stream消息驱动使用rabbitmq进行消息发送，zipkin进行消息收集并展示。
Spring Cloud Sleuth可以追踪以下类型的组件：async，hystrix，messaging，websocket，rxjava，scheduling，web（SpringWebMvc，Spring WebFlux, Servlet），webclient（Spring RestTemplate），feign，zuul。通过spring-cloud-sleuth-core的jar包结构，可以很明显的看出，sleuth支持链路追踪的组件（web下面包括http、client和feign）：

    web
    webflux通过注册TraceWebFilter， webmvc通过实现HandlerInterceptorAdapter，Servlet通过定义AOP切面对@RestController、@Controller、Callable对请求进行trace拦截，完成span的新建、传递和销毁。可以设置spring.sleuth.web.enabled为false禁用所有web请求的sleuth跟踪。
    async
    通过TraceAsyncAspect对@Async注解进行拦截，通过 TraceRunnable 和 TraceCallable来对runnable和callable进行包装和利用LazyTraceExecutor来代替java的Executor。Spring Cloud Sleuth利用以上方式进行span的新建和销毁。
    如果需要禁用的话，可以设置spring.sleuth.async.enabled为false。如果禁用，与异步相关的机制就不会发生。
    hystrix
    原理是使用HystrixPlugins添加trace相关的plugin，自定义了一个HystrixConcurrencyStrategy子类SleuthHystrixConcurrencyStrategy 。若需要禁用可以设置spring.sleuth.hystrix.strategy.enable为false。
    messaging
    Spring Cloud Sleuth提供了TracingChannelInterceptor，是基于Spring message的ChannelInterceptorAdapter/ExecutorChannelInterceptor，它发布/订阅事件都是会进行span的新建和销毁的。可以设置spring.sleuth.integration.enabled为false禁用该机制。
    websocket
    将TracingChannelInterceptor拦截类注册到ChannelRegistration中进行trace拦截。
    rxjava
    通过自定义RxJavaSchedulersHook的子类SleuthRxJavaSchedulersHook,它使用TraceAction来包装实例中Action0。这个钩子对象，会根据之前调度的Action是否已经开始跟踪，来决定是创建还是延续使用span。可以通过设置spring.sleuth.rxjava.schedulers.hook.enabled为false来关闭这个对象的使用。可以定义一组正则表达式来对线程名进行过滤，来选择哪些线程不需要跟踪。
    scheduling
    原理是建立TraceSchedulingAspect 切面对Scheduled注解进行trace拦截，对span进行创建和销毁。可以通过设置spring.sleuth.scheduled.enabled为false来使该切面无效。
    feign
    Spring Cloud Sleuth默认通过TraceFeignClientAutoConfiguration提供feign的集成，可以设置spring.sleuth.feign.enabled为false来使其无效。
    zuul
    注册Zuul过滤器TracePostZuulFilter来传递tracing信息(请求头使用tracing数据填满)，可以设置spring.sleuth.zuul.enabled为false来关闭Zuul服务。
