### 电商基础版 第一版

src
├─main
      ├─java
       |    ├─alipay.demo.trade
       |    |      ├─DemoHbRunner
       |    |      └─Main
       |    ├─mmall
       |          ├─common
       |          |      ├─Const.java
       |          |      ├─ResponseCode.java
       |          |      ├─ServerResponse.java
       |          |      └─TokenCache.java
       |          ├─controller
       |          |      ├─backend
       |          |      |      ├─CategoryManageController.java
       |          |      |      ├─OrderManageController.java
       |          |      |      ├─ProductManageController.java
       |          |      |      └─UserManageController.java
       |          |      └─portal
       |          |            ├─CartController.java
       |          |            ├─OrderController.java
       |          |            ├─ProductController.java
       |          |            ├─ShippingController.java
       |          |            └─UserController.java
       |          ├─dao
       |          |    ├─CartMapper.java
       |          |    ├─CategoryMapper.java
       |          |    ├─OrderItemMapper.java
       |          |    ├─OrderMapper.java
       |          |    ├─PayInfoMapper.java
       |          |    ├─ProductMapper.java
       |          |    ├─ShippingMapper.java
       |          |    └─UserMapper.java
       |          ├─pojo
       |          |    ├─Cart.java
       |          |    ├─Category.java
       |          |    ├─Order.java
       |          |    ├─OrderItem.java
       |          |    ├─PayInfo.java
       |          |    ├─Product.java
       |          |    ├─Shipping.java
       |          |    └─User.java
       |          ├─service
       |          |      └─impl
       |          |      |    ├─CartServiceImpl.java
       |          |      |    ├─CategoryServiceImpl.java
       |          |      |    ├─FileServiceImpl.java
       |          |      |    ├─OrderServiceImpl.java
       |          |      |    ├─ProductServiceImpl.java
       |          |      |    ├─ShippingServiceImpl.java
       |          |      |    └─UserServiceImpl.java
       |          |      |
       |          |      ├─ICartService.java
       |          |      ├─ICategoryService.java
       |          |      ├─IFileService.java
       |          |      ├─IOrderService.java
       |          |      ├─IProductService.java
       |          |      ├─IShippingService.java
       |          |      └─IUserService.java
       |          |
       |          ├─util
       |          |     ├─BigDecimalUtil.java
       |          |     ├─DateTimeUtil.java
       |          |     ├─FTPUtil.java
       |          |     ├─MD5Util.java
       |          |     └─PropertiesUtil.java
       |          └─vo
       |              ├─CartProductVo.java
       |              ├─CartVo.java
       |              ├─OrderItemVo.java
       |              ├─OrderProductVo.java
       |              ├─OrderVo.java
       |              ├─ProductDetailVo.java
       |              ├─ProductListVo.java
       |              └─ShippingVo.java
       |
      ├─resources
      └─webapp
├─test