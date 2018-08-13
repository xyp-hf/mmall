### 电商基础版 第一版

│  .gitignore
│  LICENSE
│  list.md
│  mmall.iml
│  mmall.sql
│  pom.xml
│  README.md
│  
├─out
│  └─artifacts
│      └─mmall_war_exploded
│          ├─META-INF
│          │      MANIFEST.MF
│          │      
│          └─WEB-INF
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      ├─alipay
│  │  │      │  └─demo
│  │  │      │      └─trade
│  │  │      │              DemoHbRunner.java
│  │  │      │              Main.java
│  │  │      │              
│  │  │      └─mmall
│  │  │          ├─common
│  │  │          │      Const.java
│  │  │          │      ResponseCode.java
│  │  │          │      ServerResponse.java
│  │  │          │      TokenCache.java
│  │  │          │      
│  │  │          ├─controller
│  │  │          │  ├─backend
│  │  │          │  │      CategoryManageController.java
│  │  │          │  │      OrderManageController.java
│  │  │          │  │      ProductManageController.java
│  │  │          │  │      UserManageController.java
│  │  │          │  │      
│  │  │          │  └─portal
│  │  │          │          CartController.java
│  │  │          │          OrderController.java
│  │  │          │          ProductController.java
│  │  │          │          ShippingController.java
│  │  │          │          UserController.java
│  │  │          │          
│  │  │          ├─dao
│  │  │          │      CartMapper.java
│  │  │          │      CategoryMapper.java
│  │  │          │      OrderItemMapper.java
│  │  │          │      OrderMapper.java
│  │  │          │      PayInfoMapper.java
│  │  │          │      ProductMapper.java
│  │  │          │      ShippingMapper.java
│  │  │          │      UserMapper.java
│  │  │          │      
│  │  │          ├─pojo
│  │  │          │      Cart.java
│  │  │          │      Category.java
│  │  │          │      Order.java
│  │  │          │      OrderItem.java
│  │  │          │      PayInfo.java
│  │  │          │      Product.java
│  │  │          │      Shipping.java
│  │  │          │      User.java
│  │  │          │      
│  │  │          ├─service
│  │  │          │  │  ICartService.java
│  │  │          │  │  ICategoryService.java
│  │  │          │  │  IFileService.java
│  │  │          │  │  IOrderService.java
│  │  │          │  │  IProductService.java
│  │  │          │  │  IShippingService.java
│  │  │          │  │  IUserService.java
│  │  │          │  │  
│  │  │          │  └─impl
│  │  │          │          CartServiceImpl.java
│  │  │          │          CategoryServiceImpl.java
│  │  │          │          FileServiceImpl.java
│  │  │          │          OrderServiceImpl.java
│  │  │          │          ProductServiceImpl.java
│  │  │          │          ShippingServiceImpl.java
│  │  │          │          UserServiceImpl.java
│  │  │          │          
│  │  │          ├─util
│  │  │          │      BigDecimalUtil.java
│  │  │          │      DateTimeUtil.java
│  │  │          │      FTPUtil.java
│  │  │          │      MD5Util.java
│  │  │          │      PropertiesUtil.java
│  │  │          │      
│  │  │          └─vo
│  │  │                  CartProductVo.java
│  │  │                  CartVo.java
│  │  │                  OrderItemVo.java
│  │  │                  OrderProductVo.java
│  │  │                  OrderVo.java
│  │  │                  ProductDetailVo.java
│  │  │                  ProductListVo.java
│  │  │                  ShippingVo.java
│  │  │                  
│  │  ├─resources
│  │  │  │  applicationContext-datasource.xml
│  │  │  │  applicationContext.xml
│  │  │  │  datasource.properties
│  │  │  │  generatorConfig.xml
│  │  │  │  logback.xml
│  │  │  │  mmall.properties
│  │  │  │  zfbinfo.properties
│  │  │  │  
│  │  │  └─mappers
│  │  │          CartMapper.xml
│  │  │          CategoryMapper.xml
│  │  │          OrderItemMapper.xml
│  │  │          OrderMapper.xml
│  │  │          PayInfoMapper.xml
│  │  │          ProductMapper.xml
│  │  │          ShippingMapper.xml
│  │  │          UserMapper.xml
│  │  │          
│  │  └─webapp
│  │      │  index.jsp
│  │      │  
│  │      └─WEB-INF
│  │          │  dispatcher-servlet.xml
│  │          │  web.xml
│  │          │  
│  │          └─lib
│  │                  alipay-sdk-java20161213173952-source.jar
│  │                  alipay-sdk-java20161213173952.jar
│  │                  alipay-trade-sdk-20161215-source.jar
│  │                  alipay-trade-sdk-20161215.jar
│  │                  
│  └─test
│      └─java
├─target
│  ├─classes
│  │  │  applicationContext-datasource.xml
│  │  │  applicationContext.xml
│  │  │  datasource.properties
│  │  │  generatorConfig.xml
│  │  │  logback.xml
│  │  │  mmall.properties
│  │  │  zfbinfo.properties
│  │  │  
│  │  ├─com
│  │  │  ├─alipay
│  │  │  │  └─demo
│  │  │  │      └─trade
│  │  │  │              DemoHbRunner.class
│  │  │  │              Main$1.class
│  │  │  │              Main.class
│  │  │  │              
│  │  │  └─mmall
│  │  │      ├─common
│  │  │      │      Const$AlipayCallback.class
│  │  │      │      Const$Cart.class
│  │  │      │      Const$OrderStatusEnum.class
│  │  │      │      Const$PaymentTypeEnum.class
│  │  │      │      Const$PayPlatformEnum.class
│  │  │      │      Const$ProductListOrderBy.class
│  │  │      │      Const$ProductStatusEnum.class
│  │  │      │      Const$Role.class
│  │  │      │      Const.class
│  │  │      │      ResponseCode.class
│  │  │      │      ServerResponse.class
│  │  │      │      TokenCache$1.class
│  │  │      │      TokenCache.class
│  │  │      │      
│  │  │      ├─controller
│  │  │      │  ├─backend
│  │  │      │  │      CategoryManageController.class
│  │  │      │  │      OrderManageController.class
│  │  │      │  │      ProductManageController.class
│  │  │      │  │      UserManageController.class
│  │  │      │  │      
│  │  │      │  └─portal
│  │  │      │          CartController.class
│  │  │      │          OrderController.class
│  │  │      │          ProductController.class
│  │  │      │          ShippingController.class
│  │  │      │          UserController.class
│  │  │      │          
│  │  │      ├─dao
│  │  │      │      CartMapper.class
│  │  │      │      CategoryMapper.class
│  │  │      │      OrderItemMapper.class
│  │  │      │      OrderMapper.class
│  │  │      │      PayInfoMapper.class
│  │  │      │      ProductMapper.class
│  │  │      │      ShippingMapper.class
│  │  │      │      UserMapper.class
│  │  │      │      
│  │  │      ├─pojo
│  │  │      │      Cart.class
│  │  │      │      Category.class
│  │  │      │      Order.class
│  │  │      │      OrderItem.class
│  │  │      │      PayInfo.class
│  │  │      │      Product.class
│  │  │      │      Shipping.class
│  │  │      │      User.class
│  │  │      │      
│  │  │      ├─service
│  │  │      │  │  ICartService.class
│  │  │      │  │  ICategoryService.class
│  │  │      │  │  IFileService.class
│  │  │      │  │  IOrderService.class
│  │  │      │  │  IProductService.class
│  │  │      │  │  IShippingService.class
│  │  │      │  │  IUserService.class
│  │  │      │  │  
│  │  │      │  └─impl
│  │  │      │          CartServiceImpl.class
│  │  │      │          CategoryServiceImpl.class
│  │  │      │          FileServiceImpl.class
│  │  │      │          OrderServiceImpl$1.class
│  │  │      │          OrderServiceImpl.class
│  │  │      │          ProductServiceImpl.class
│  │  │      │          ShippingServiceImpl.class
│  │  │      │          UserServiceImpl.class
│  │  │      │          
│  │  │      ├─util
│  │  │      │      BigDecimalUtil.class
│  │  │      │      DateTimeUtil.class
│  │  │      │      FTPUtil.class
│  │  │      │      MD5Util.class
│  │  │      │      PropertiesUtil.class
│  │  │      │      
│  │  │      └─vo
│  │  │              CartProductVo.class
│  │  │              CartVo.class
│  │  │              OrderItemVo.class
│  │  │              OrderProductVo.class
│  │  │              OrderVo.class
│  │  │              ProductDetailVo.class
│  │  │              ProductListVo.class
│  │  │              ShippingVo.class
│  │  │              
│  │  └─mappers
│  │          CartMapper.xml
│  │          CategoryMapper.xml
│  │          OrderItemMapper.xml
│  │          OrderMapper.xml
│  │          PayInfoMapper.xml
│  │          ProductMapper.xml
│  │          ShippingMapper.xml
│  │          UserMapper.xml
│  │          
│  ├─generated-sources
│  │  └─annotations
│  └─mmall
│      │  index.jsp
│      │  
│      ├─META-INF
│      │      MANIFEST.MF
│      │      
│      ├─upload
│      │      qr-1491753014256.png
│      │      qr-1492091102371.png
│      │      qr-1492091141269.png
│      │      
│      └─WEB-INF
│          │  dispatcher-servlet.xml
│          │  web.xml
│          │  
│          ├─classes
│          │  │  applicationContext-datasource.xml
│          │  │  applicationContext.xml
│          │  │  datasource.properties
│          │  │  generatorConfig.xml
│          │  │  logback.xml
│          │  │  mmall.properties
│          │  │  zfbinfo.properties
│          │  │  
│          │  ├─com
│          │  │  ├─alipay
│          │  │  │  └─demo
│          │  │  │      └─trade
│          │  │  │              DemoHbRunner.class
│          │  │  │              Main$1.class
│          │  │  │              Main.class
│          │  │  │              
│          │  │  └─mmall
│          │  │      ├─common
│          │  │      │      Const$AlipayCallback.class
│          │  │      │      Const$Cart.class
│          │  │      │      Const$OrderStatusEnum.class
│          │  │      │      Const$PaymentTypeEnum.class
│          │  │      │      Const$PayPlatformEnum.class
│          │  │      │      Const$ProductListOrderBy.class
│          │  │      │      Const$ProductStatusEnum.class
│          │  │      │      Const$Role.class
│          │  │      │      Const.class
│          │  │      │      ResponseCode.class
│          │  │      │      ServerResponse.class
│          │  │      │      TokenCache$1.class
│          │  │      │      TokenCache.class
│          │  │      │      
│          │  │      ├─controller
│          │  │      │  ├─backend
│          │  │      │  │      CategoryManageController.class
│          │  │      │  │      OrderManageController.class
│          │  │      │  │      ProductManageController.class
│          │  │      │  │      UserManageController.class
│          │  │      │  │      
│          │  │      │  └─portal
│          │  │      │          CartController.class
│          │  │      │          OrderController.class
│          │  │      │          ProductController.class
│          │  │      │          ShippingController.class
│          │  │      │          UserController.class
│          │  │      │          
│          │  │      ├─dao
│          │  │      │      CartMapper.class
│          │  │      │      CategoryMapper.class
│          │  │      │      OrderItemMapper.class
│          │  │      │      OrderMapper.class
│          │  │      │      PayInfoMapper.class
│          │  │      │      ProductMapper.class
│          │  │      │      ShippingMapper.class
│          │  │      │      UserMapper.class
│          │  │      │      
│          │  │      ├─pojo
│          │  │      │      Cart.class
│          │  │      │      Category.class
│          │  │      │      Order.class
│          │  │      │      OrderItem.class
│          │  │      │      PayInfo.class
│          │  │      │      Product.class
│          │  │      │      Shipping.class
│          │  │      │      User.class
│          │  │      │      
│          │  │      ├─service
│          │  │      │  │  ICartService.class
│          │  │      │  │  ICategoryService.class
│          │  │      │  │  IFileService.class
│          │  │      │  │  IOrderService.class
│          │  │      │  │  IProductService.class
│          │  │      │  │  IShippingService.class
│          │  │      │  │  IUserService.class
│          │  │      │  │  
│          │  │      │  └─impl
│          │  │      │          CartServiceImpl.class
│          │  │      │          CategoryServiceImpl.class
│          │  │      │          FileServiceImpl.class
│          │  │      │          OrderServiceImpl$1.class
│          │  │      │          OrderServiceImpl.class
│          │  │      │          ProductServiceImpl.class
│          │  │      │          ShippingServiceImpl.class
│          │  │      │          UserServiceImpl.class
│          │  │      │          
│          │  │      ├─util
│          │  │      │      BigDecimalUtil.class
│          │  │      │      DateTimeUtil.class
│          │  │      │      FTPUtil.class
│          │  │      │      MD5Util.class
│          │  │      │      PropertiesUtil.class
│          │  │      │      
│          │  │      └─vo
│          │  │              CartProductVo.class
│          │  │              CartVo.class
│          │  │              OrderItemVo.class
│          │  │              OrderProductVo.class
│          │  │              OrderVo.class
│          │  │              ProductDetailVo.class
│          │  │              ProductListVo.class
│          │  │              ShippingVo.class
│          │  │              
│          │  └─mappers
│          │          CartMapper.xml
│          │          CategoryMapper.xml
│          │          OrderItemMapper.xml
│          │          OrderMapper.xml
│          │          PayInfoMapper.xml
│          │          ProductMapper.xml
│          │          ShippingMapper.xml
│          │          UserMapper.xml
│          │          
│          └─lib
│                  alipay-sdk-java20161213173952-source.jar
│                  alipay-sdk-java20161213173952.jar
│                  alipay-trade-sdk-20161215-source.jar
│                  alipay-trade-sdk-20161215.jar
│                  aopalliance-1.0.jar
│                  aspectjrt-1.6.11.jar
│                  aspectjweaver-1.7.3.jar
│                  commons-codec-1.10.jar
│                  commons-collections-3.2.1.jar
│                  commons-configuration-1.10.jar
│                  commons-dbcp-1.4.jar
│                  commons-fileupload-1.2.2.jar
│                  commons-io-2.0.1.jar
│                  commons-lang-2.6.jar
│                  commons-lang3-3.5.jar
│                  commons-logging-1.1.1.jar
│                  commons-net-3.1.jar
│                  commons-pool-1.5.4.jar
│                  commons-pool2-2.4.2.jar
│                  core-2.1.jar
│                  gson-2.3.1.jar
│                  guava-20.0.jar
│                  hamcrest-core-1.3.jar
│                  hashids-1.0.1.jar
│                  jackson-core-asl-1.9.12.jar
│                  jackson-mapper-asl-1.9.12.jar
│                  jedis-2.9.0.jar
│                  joda-time-2.3.jar
│                  jsqlparser-0.9.4.jar
│                  junit-4.12.jar
│                  logback-classic-1.1.2.jar
│                  logback-core-1.1.2.jar
│                  mybatis-3.4.1.jar
│                  mybatis-paginator-1.2.17.jar
│                  mybatis-spring-1.3.0.jar
│                  mysql-connector-java-5.1.6.jar
│                  pagehelper-4.1.0.jar
│                  slf4j-api-1.7.6.jar
│                  spring-aop-4.0.0.RELEASE.jar
│                  spring-beans-4.0.0.RELEASE.jar
│                  spring-context-4.0.0.RELEASE.jar
│                  spring-core-4.0.0.RELEASE.jar
│                  spring-expression-4.0.0.RELEASE.jar
│                  spring-jdbc-4.0.0.RELEASE.jar
│                  spring-oxm-4.0.0.RELEASE.jar
│                  spring-test-4.0.0.RELEASE.jar
│                  spring-tx-4.0.0.RELEASE.jar
│                  spring-web-4.0.0.RELEASE.jar
│                  spring-webmvc-4.0.0.RELEASE.jar
│                  tomcat-servlet-api-7.0.64.jar
│                  
└─web
    │  index.jsp
    │  
    └─WEB-INF
            web.xml
            
