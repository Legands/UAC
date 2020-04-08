# User Access Control Service
统一权限控制服务是一个单点登录与权限控制应用，可单独部署并基于token验证来提供认证与权限控制服务，项目采用SpringBoot+Spring Security+Mybatis框架，采用JWT进行token验证。
## 接入流程：
### 1.调用登录接口拿到token，
### 2.使用token调用UAC提供的用户注册、删除、修改、退出登录及列表分页查询等。

## 在线接口文档地址：
http://yapi.demo.qunar.com/project/32142/interface/api
#### 需要权限。