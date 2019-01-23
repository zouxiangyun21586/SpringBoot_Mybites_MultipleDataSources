package com.yr.controller;

//@Aspect
//@Component // 将它作为一个bean注入
public class WebLogAspect {
//	private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
//
//	@Pointcut("execution(public * com.yr.controller..*.*(..))")
//	public void webLog() {
//	}
//
//	@Before("webLog()")
//	public void doBefore(JoinPoint joinPoint) throws Throwable {
//		// 接收到请求，记录请求内容
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		// 记录下请求内容
//		logger.info("URL : " + request.getRequestURL().toString());
//		logger.info("HTTP_METHOD : " + request.getMethod());
//		logger.info("IP : " + request.getRemoteAddr());
//		Enumeration<String> enu = request.getParameterNames();
//		while (enu.hasMoreElements()) {
//			String name = (String) enu.nextElement();
//			logger.info("name:{},value:{}", name, request.getParameter(name));
//		}
//	}
//
//	@AfterReturning(returning = "ret", pointcut = "webLog()")
//	public void doAfterReturning(Object ret) throws Throwable {
//		// 处理完请求，返回内容
//		logger.info("RESPONSE : " + ret);
//	}

//	// 后置异常通知
//	@AfterThrowing("webLog()")
//	public void throwss(JoinPoint jp) {
//		System.out.println("方法异常时执行.....");
//	}
//
//	// 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//	@After("webLog()")
//	public void after(JoinPoint jp) {
//		System.out.println("方法最后执行.....");
//	}
//
//	// 环绕通知,环绕增强，相当于MethodInterceptor
//	@Around("webLog()")
//	public Object arround(ProceedingJoinPoint pjp) {
//		System.out.println("方法环绕start.....");
//		try {
//			Object o = pjp.proceed();
//			System.out.println("方法环绕proceed，结果是 :" + o);
//			return o;
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}