package com.sys.annotation;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sys.entity.ConLog;
import com.sys.entity.User;
import com.sys.service.log.ConLogService;





/**
 * 创建切点类
 * @author zhengxixian
 *
 */
//@Aspect  
//@Component 
//public class SystemLogAspect {

	//注入Service用于把日志保存数据库  
//	@Resource  
//	private ConLogService conlogService;  
	//本地异常日志记录对象  
//	private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);  

	//Service层切点    
//	@Pointcut("execution(@annotation(com.sys.annotation.SystemServiceLog))")  
/*	@Pointcut("execution(* com.sys.service.impl.*.*(..))")
		public  void serviceAspect() {    
	} */ 
	//Controller层切点    
/*	@Pointcut("execution(* com.sys.controller.*.*.*(..))")    
		public  void controllerAspect() {    
	} */

	
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     * @throws Exception 
     */    
/*    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) throws Exception {   */ 
    
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//        HttpSession session = request.getSession();    
//        //读取session中的用户    
//        User user = (User) session.getAttribute("user");    
//        //请求的IP    
//        String ip = request.getRemoteAddr();  
/*    	
    	User user = new User();
    	user.setId(1);
    	 user.setName("admin");
    	 String ip = "127.0.0.1";
         try {    
            //*========控制台输出=========*/
           /* System.out.println("=====前置通知开始=====");    
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));    
            System.out.println("请求人:" + user.getName());    
            System.out.println("请求IP:" + ip);    
            
			ConLog log = new ConLog();  
			log.setUserID(1);
			log.setIP("127.0.0.1");
			log.setIsSucceed(1);
			log.setLoginTime("1");
			log.setLogoutTime("1");
			log.setUserName("1");
			System.out.println(log.getIP());
            //保存数据库    
			conlogService.insert(log);   
			
            System.out.println("=====前置通知结束=====");    
        }  catch (Exception e) {    
            //记录本地异常日志    
            logger.error("==前置通知异常==");    
            logger.error("异常信息:{}", e.getMessage());    
        }    
    } */   
	
    
    /**  
     * 异常通知 用于拦截service层记录异常日志  
     *  
     * @param joinPoint  
     * @param e  
     */    
/*    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {   */ 
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//        HttpSession session = request.getSession();    
//        //读取session中的用户    
//        User user = (User) session.getAttribute(WebConstants.CURRENT_USER);    
//        //获取请求ip    
//        String ip = request.getRemoteAddr();    
/*    	System.out.println("错误日志 joinPoint:"+joinPoint);
    	User user = new User();
    	user.setId(1);
    	 user.setName("admin");
    	 String ip = "127.0.0.1";*/
        //获取用户请求方法的参数并序列化为JSON格式字符串    
//        String params = "";    
//         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
//             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
//                params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";    
//            }    
//        }    
/*         try {    
              ========控制台输出=========    
            System.out.println("=====异常通知开始=====");    
            System.out.println("异常代码:" + e.getClass().getName());    
            System.out.println("异常信息:" + e.getMessage());    
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));    
            System.out.println("请求人:" + user.getName());    
            System.out.println("请求IP:" + ip);   */ 
//            System.out.println("请求参数:" + params);    
               /*==========数据库日志=========*/    
//            Log log = SpringContextHolder.getBean("logxx");    
//            log.setDescription(getServiceMthodDescription(joinPoint));    
//            log.setExceptionCode(e.getClass().getName());    
//            log.setType("1");    
//            log.setExceptionDetail(e.getMessage());    
//            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
//            log.setParams(params);    
//            log.setCreateBy(user);    
//            log.setCreateDate(DateUtil.getCurrentDate());    
//            log.setRequestIp(ip);    
/*            
			ConLog log = new ConLog();  
			log.setUserID(1);
			log.setIP("127.0.0.1");
			log.setIsSucceed(1);
			log.setLoginTime("1");
			log.setLogoutTime("1");
			log.setUserName("1");
            //保存数据库    
			conlogService.insert(log); 
            System.out.println("=====异常通知结束=====");    
        }  catch (Exception ex) { */   
            //记录本地异常日志    
/*            logger.error("==异常通知异常==");    
            logger.error("异常信息:{}", ex.getMessage());    
        }    
         ==========记录本地异常日志==========    
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage());    
    
    }   */ 
    
    
    /**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
/*     public  static String getServiceMthodDescription(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemServiceLog. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    
    
    *//**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     *//*    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemControllerLog.class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    } */   
	
	
//	
//	/**
//	 * 前置通知 用于拦截Controller层记录用户的操作 
//	 * @param joinPoint  切点
//	 */
//	@Before("controllerAspect()")
//	public void doBefore(JoinPoint joinPoint) {
//		System.out.println("==========执行controller前置通知===============");
//		if(logger.isInfoEnabled()){
//			logger.info("before " + joinPoint);
//		}
//	}
//	//配置controller环绕通知,使用在方法aspect()上注册的切入点
//	@Around("controllerAspect()")
//	public void around(JoinPoint joinPoint){
//		System.out.println("==========开始执行controller环绕通知===============");
//		long start = System.currentTimeMillis();
//		try {
//			((ProceedingJoinPoint) joinPoint).proceed();
//			long end = System.currentTimeMillis();
//			if(logger.isInfoEnabled()){
//				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
//			}
//			System.out.println("==========结束执行controller环绕通知===============");
//		} catch (Throwable e) {
//			long end = System.currentTimeMillis();
//			if(logger.isInfoEnabled()){
//				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
//			}
//		}
//	}
//
//
//	/** 
//	 * 后置通知 用于拦截Controller层记录用户的操作 
//	 * 
//	 * @param joinPoint 切点 
//	 */  
//	@After("controllerAspect()")  
//	public  void after(JoinPoint joinPoint) {  
//
//		/* HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
//	           HttpSession session = request.getSession();  */
//		//读取session中的用户  
//		// User user = (User) session.getAttribute("user");  
//		//请求的IP  
//		//String ip = request.getRemoteAddr();
//		User user = new User();
//		user.setId(1);
//		user.setName("张三");
//		String ip = "127.0.0.1";
//		try {  
//
//			String targetName = joinPoint.getTarget().getClass().getName();  
//			String methodName = joinPoint.getSignature().getName();  
//			Object[] arguments = joinPoint.getArgs();  
//			Class targetClass = Class.forName(targetName);  
//			Method[] methods = targetClass.getMethods();
//			String operationType = "";
//			String operationName = "";
//			for (Method method : methods) {  
//				if (method.getName().equals(methodName)) {  
//					Class[] clazzs = method.getParameterTypes();  
//					if (clazzs.length == arguments.length) {  
////						operationType = method.getAnnotation(Log.class).operationType();
//						operationType = method.getAnnotation()
//						operationName = method.getAnnotation(Log.class).operationName();
//						break;  
//					}  
//				}  
//			}
//			//*========控制台输出=========*//  
//			System.out.println("=====controller后置通知开始=====");  
//			System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
//			System.out.println("方法描述:" + operationName);  
//			System.out.println("请求人:" + user.getName());  
//			System.out.println("请求IP:" + ip);  
//			//*========数据库日志=========*//  
//			ConLog log = new ConLog();  
//			log.setUserID(1);
//			log.setIP("127.0.0.1");
//			log.setIsSucceed("1");
//			log.setLoginTime("1");
//			log.setLogoutTime("1");
//			log.setUserName("1");
////			log.setDescription(operationName);  
////			log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
////			log.setLogType((long)0);  
////			log.setRequestIp(ip);  
////			log.setExceptioncode( null);  
////			log.setExceptionDetail( null);  
////			log.setParams( null);  
////			log.setCreateBy(user.getName());  
////			log.setCreateDate(new Date());  
//			//保存数据库  
//			conlogService.insert(log);  
//			System.out.println("=====controller后置通知结束=====");  
//		}  catch (Exception e) {  
//			//记录本地异常日志  
//			logger.error("==后置通知异常==");  
//			logger.error("异常信息:{}", e.getMessage());  
//		}  
//	} 
//
//	//配置后置返回通知,使用在方法aspect()上注册的切入点
//	@AfterReturning("controllerAspect()")
//	public void afterReturn(JoinPoint joinPoint){
//		System.out.println("=====执行controller后置返回通知=====");  
//		if(logger.isInfoEnabled()){

//	}
//			logger.info("afterReturn " + joinPoint);
//		}
/*}*/
