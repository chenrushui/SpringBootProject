package com.demo.www.springbootdemo;


import com.demo.www.springbootdemo.module.design.template.BusTravel;
import com.demo.www.springbootdemo.module.design.template.TrainTravel;
import com.demo.www.springbootdemo.module.design.template.TravelTemplate;
import com.demo.www.springbootdemo.mapper.RedisDao;
import com.demo.www.springbootdemo.mapper.TitleMapper;
import com.demo.www.springbootdemo.pojo.Person;
import com.demo.www.springbootdemo.pojo.Title;
import com.demo.www.springbootdemo.pojo.User;
import com.demo.www.springbootdemo.service.IUserService;
import com.demo.www.springbootdemo.module.spring.SpringBeanCircle;
import com.demo.www.springbootdemo.validate.UserValidator;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

    @Autowired
    private Person person;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    IUserService iUserService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    SqlSession sqlSession1;

    @Autowired
    SpringBeanCircle springBeanCircle;

    /**
     * 测试bean生命周期
     */
    @Test
    public void testSpringBeanCircle() {
        springBeanCircle.run();
        //classPathXmlApplicationContext.close();
    }

    @Test
    public void testMybatisCache2() {
        TitleMapper mapper = sqlSession.getMapper(TitleMapper.class);
        Title title = mapper.selectById(1);
        System.out.println("1----->" + title);
        TitleMapper mapper1 = sqlSession1.getMapper(TitleMapper.class);
        //mapper1.deleteTitleById(29);
        Title title1 = mapper.selectById(1);
        System.out.println("2----->" + title1);
    }

    @Test
    public void testMybatisCache1() {
//        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //获得TitleMapper对象,todo:如何获取当前接口的动态代理对象？
        TitleMapper mapper = sqlSession.getMapper(TitleMapper.class);
        Title title = mapper.selectById(1);
        System.out.println(title);
        //再次查询id为1的Title对象，因为是同一个SqlSession,所以会从之前的一级缓存中查找数据
        Title title1 = mapper.selectById(1);
        System.out.println(title1);
        //sqlSession.close();
    }

    @Test
    public void TestHelloService() {
        boolean b = ioc.containsBean("helloService");
        System.out.print("输出结果" + b);
    }

    /**
     * 测试方法
     */
    @Test
    public void contextLoads() {
        //查看person有没有拿到配置文件的值
        System.out.print(person.toString());

    }


    /**
     * 测试RedisTemplate
     */
    @Test
    public void TestRedisDao() {
        redisDao.setKey("v1", "chenrushui");
        String result = redisDao.getKey("v1");
        logger.info(result);
    }

    /**
     * 测试模板设计模式
     * 模板类：模板方法。
     */
    @Test
    public void testTemplate() {
        TravelTemplate busTravel = new BusTravel();
        busTravel.travel();
        System.out.println("--------------------");
        TravelTemplate trainTravel = new TrainTravel();
        trainTravel.travel();
    }



    /**
     * 测试面向切面编程
     */
    @Test
    public void TestSpringAop() {
//        User user = new User();
//        user.setName("crs");
//        user.setPassword("123456");
//        iUserService.printUser(user);
    }

    @Test
    public void TestSpringAOP() {
        User user = null;
        UserValidator userValidator = (UserValidator) iUserService;
        if (!userValidator.validator(user)) {
            iUserService.printUser(user);
        } else {
            System.out.println("对象为空");
        }
    }

    @Test
    public void TestRabbit() {
        rabbitTemplate.convertAndSend("springboot", "springboot-rabbitmq");
    }
}
