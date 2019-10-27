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
 * �����е���
 * @author zhengxixian
 *
 */
//@Aspect  
//@Component 
//public class SystemLogAspect {

	//ע��Service���ڰ���־�������ݿ�  
//	@Resource  
//	private ConLogService conlogService;  
	//�����쳣��־��¼����  
//	private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);  

	//Service���е�    
//	@Pointcut("execution(@annotation(com.sys.annotation.SystemServiceLog))")  
/*	@Pointcut("execution(* com.sys.service.impl.*.*(..))")
		public  void serviceAspect() {    
	} */ 
	//Controller���е�    
/*	@Pointcut("execution(* com.sys.controller.*.*.*(..))")    
		public  void controllerAspect() {    
	} */

	
    /**  
     * ǰ��֪ͨ ��������Controller���¼�û��Ĳ���  
     *  
     * @param joinPoint �е�  
     * @throws Exception 
     */    
/*    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) throws Exception {   */ 
    
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//        HttpSession session = request.getSession();    
//        //��ȡsession�е��û�    
//        User user = (User) session.getAttribute("user");    
//        //�����IP    
//        String ip = request.getRemoteAddr();  
/*    	
    	User user = new User();
    	user.setId(1);
    	 user.setName("admin");
    	 String ip = "127.0.0.1";
         try {    
            //*========����̨���=========*/
           /* System.out.println("=====ǰ��֪ͨ��ʼ=====");    
            System.out.println("���󷽷�:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("��������:" + getControllerMethodDescription(joinPoint));    
            System.out.println("������:" + user.getName());    
            System.out.println("����IP:" + ip);    
            
			ConLog log = new ConLog();  
			log.setUserID(1);
			log.setIP("127.0.0.1");
			log.setIsSucceed(1);
			log.setLoginTime("1");
			log.setLogoutTime("1");
			log.setUserName("1");
			System.out.println(log.getIP());
            //�������ݿ�    
			conlogService.insert(log);   
			
            System.out.println("=====ǰ��֪ͨ����=====");    
        }  catch (Exception e) {    
            //��¼�����쳣��־    
            logger.error("==ǰ��֪ͨ�쳣==");    
            logger.error("�쳣��Ϣ:{}", e.getMessage());    
        }    
    } */   
	
    
    /**  
     * �쳣֪ͨ ��������service���¼�쳣��־  
     *  
     * @param joinPoint  
     * @param e  
     */    
/*    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {   */ 
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//        HttpSession session = request.getSession();    
//        //��ȡsession�е��û�    
//        User user = (User) session.getAttribute(WebConstants.CURRENT_USER);    
//        //��ȡ����ip    
//        String ip = request.getRemoteAddr();    
/*    	System.out.println("������־ joinPoint:"+joinPoint);
    	User user = new User();
    	user.setId(1);
    	 user.setName("admin");
    	 String ip = "127.0.0.1";*/
        //��ȡ�û����󷽷��Ĳ��������л�ΪJSON��ʽ�ַ���    
//        String params = "";    
//         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
//             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
//                params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";    
//            }    
//        }    
/*         try {    
              ========����̨���=========    
            System.out.println("=====�쳣֪ͨ��ʼ=====");    
            System.out.println("�쳣����:" + e.getClass().getName());    
            System.out.println("�쳣��Ϣ:" + e.getMessage());    
            System.out.println("�쳣����:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("��������:" + getServiceMthodDescription(joinPoint));    
            System.out.println("������:" + user.getName());    
            System.out.println("����IP:" + ip);   */ 
//            System.out.println("�������:" + params);    
               /*==========���ݿ���־=========*/    
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
            //�������ݿ�    
			conlogService.insert(log); 
            System.out.println("=====�쳣֪ͨ����=====");    
        }  catch (Exception ex) { */   
            //��¼�����쳣��־    
/*            logger.error("==�쳣֪ͨ�쳣==");    
            logger.error("�쳣��Ϣ:{}", ex.getMessage());    
        }    
         ==========��¼�����쳣��־==========    
        logger.error("�쳣����:{}�쳣����:{}�쳣��Ϣ:{}����:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage());    
    
    }   */ 
    
    
    /**  
     * ��ȡע���жԷ�����������Ϣ ����service��ע��  
     *  
     * @param joinPoint �е�  
     * @return ��������  
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
     * ��ȡע���жԷ�����������Ϣ ����Controller��ע��  
     *  
     * @param joinPoint �е�  
     * @return ��������  
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
//	 * ǰ��֪ͨ ��������Controller���¼�û��Ĳ��� 
//	 * @param joinPoint  �е�
//	 */
//	@Before("controllerAspect()")
//	public void doBefore(JoinPoint joinPoint) {
//		System.out.println("==========ִ��controllerǰ��֪ͨ===============");
//		if(logger.isInfoEnabled()){
//			logger.info("before " + joinPoint);
//		}
//	}
//	//����controller����֪ͨ,ʹ���ڷ���aspect()��ע��������
//	@Around("controllerAspect()")
//	public void around(JoinPoint joinPoint){
//		System.out.println("==========��ʼִ��controller����֪ͨ===============");
//		long start = System.currentTimeMillis();
//		try {
//			((ProceedingJoinPoint) joinPoint).proceed();
//			long end = System.currentTimeMillis();
//			if(logger.isInfoEnabled()){
//				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
//			}
//			System.out.println("==========����ִ��controller����֪ͨ===============");
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
//	 * ����֪ͨ ��������Controller���¼�û��Ĳ��� 
//	 * 
//	 * @param joinPoint �е� 
//	 */  
//	@After("controllerAspect()")  
//	public  void after(JoinPoint joinPoint) {  
//
//		/* HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
//	           HttpSession session = request.getSession();  */
//		//��ȡsession�е��û�  
//		// User user = (User) session.getAttribute("user");  
//		//�����IP  
//		//String ip = request.getRemoteAddr();
//		User user = new User();
//		user.setId(1);
//		user.setName("����");
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
//			//*========����̨���=========*//  
//			System.out.println("=====controller����֪ͨ��ʼ=====");  
//			System.out.println("���󷽷�:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
//			System.out.println("��������:" + operationName);  
//			System.out.println("������:" + user.getName());  
//			System.out.println("����IP:" + ip);  
//			//*========���ݿ���־=========*//  
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
//			//�������ݿ�  
//			conlogService.insert(log);  
//			System.out.println("=====controller����֪ͨ����=====");  
//		}  catch (Exception e) {  
//			//��¼�����쳣��־  
//			logger.error("==����֪ͨ�쳣==");  
//			logger.error("�쳣��Ϣ:{}", e.getMessage());  
//		}  
//	} 
//
//	//���ú��÷���֪ͨ,ʹ���ڷ���aspect()��ע��������
//	@AfterReturning("controllerAspect()")
//	public void afterReturn(JoinPoint joinPoint){
//		System.out.println("=====ִ��controller���÷���֪ͨ=====");  
//		if(logger.isInfoEnabled()){

//	}
//			logger.info("afterReturn " + joinPoint);
//		}
/*}*/
