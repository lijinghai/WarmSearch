## 前言：

🏫本人目前（2021年3月19日）是一名大二在校大学生从去年（2020年)5月开始准备自学java，从基础到框架，利用课余时间从JavaWeb开始，到SSM,到SpringBoot,再到前端Html5,CSS3,JS,Vue.js,最后到Node.js，学完之后开始着手开始做这个校园失物招领网站，目前该项目大概原型已经呈现出来，这是基于前后端分离项目，目前利用课余时间，不断完善改项目。小白开始，若有错误，还望大家多多指教。各部分源码将在Github上持续更新。

##### 这是我的邮箱lijinghailjh@163.com,欢迎大家来指正

##### 最新代码将在[GitHub](https://github.com/Dorian1015)上持续更新





## 说明

> 本项目前后端分离，前端(WarmSearch-PC）[参考锤子商城](https://www.smartisan.com/)

> 这是本项目的前台源码，后端源码请看[WarmSearch](https://github.com/Dorian1015/WarmSearch),本项目包括后台管理系统([WarmSearch-Web](https://github.com/Dorian1015/WarmSearch-Web))，前台系统（[WarmSearch-PC](https://github.com/Dorian1015/WarmSearch-PC))，微信小程序部分（[WarmSearch-uniapp](https://github.com/Dorian1015/WarmSearch-uniapp))

> #### 如果您觉得这项目还不错，可以在右上角`Star`支持一下，万分感谢！！！

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/0E503FDA.gif)

## 项目简介

- 本项目前后端分离，前端基于`Vue`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`，参考锤子商城实现。后端基于SpringBoot(框架) + JSON WEB TOKEN(令牌机制) + MybatisPlus + Mysql实现。

- 总体架构![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/clip_image002.jpg)

  系统设计秉承“前后端分离/SOA”的总体思想，前端使用Vue/ElementUI作为主要框架技术、Nginx作为HTTP服务器，用来提供静态页面访问服务和反向代理作用；后端则以Springboot主流框架技术为主、采用MySQL开源数据库，前后端使用Restful规范交换数据。

  系统采用JWT令牌鉴权方式，降低服务器运行消耗，提升系统的伸缩性和扩展性。

- 总体架构

  总体设计按“前后端分离”方式，当浏览器请求页面或静态资源时，HTTP Server直接响应；当浏览器请求数据时，该请求仍然先发给HTTP Server，经由该Server转发至Web APP Server。Web APP Server业务处理后将结果数据返回给HTTP Server，最终返回浏览器。在此过程中，Web APP Server返回的仅仅是数据（json格式），没有任何与显示（视图）相关的信息，做到了完全的前后端分离，前端负责页面与展示，后端负责业务处理与数据。

## 技术栈

- 前台页面展示系统（WarmSearch-PC)：`Vue`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`
- 后台管理系统：基于Vue-admin-ui脚手架
- 微信小程序：uni-app + Vue.js
- 后端：Springboot + Java Web Token +MybatisPlus + Swagger 框架
- 数据库：MySql

## 功能模块



## 运行项目

#### 1.前台页面展示（WarmSearch-PC)

- ###### WarmSearch-PC首页部分展示

![image-20210327001243579](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327001243579.png)

- ###### 寻失物部分页面展示

  ![image-20210327001638024](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327001638024.png)

- ###### 寻失主部分页面展示

  ![image-20210327001747782](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327001747782.png)

- ###### 捐赠部分页面展示

  ![image-20210327001838330](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327001838330.png)



#### 2.微信小程序页面(WarmSearch-uniapp)

- #### 首页部分页面展示

  ![image-20210327002845431](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327002845431.png)

- #### 寻物页面部分展示

  ![image-20210327003137254](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327003137254.png)

#### 3.后台管理系统(WarmSearch-web)

- #### 部分页面展示

  ![image-20210327003533589](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327003533589.png)

  ![image-20210327003428898](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327003428898.png)

  ![image-20210327003455879](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/image-20210327003455879.png)



## 后期打算

### 如果你觉得我的项目，还不错，可以给我一下赞赏，本人现是一名大二学生，打算不断完善这个项目，所以我打算购买服务器，并部署上去；开源不易，如果你喜欢我的项目，可以给我投资一下我的服务器基金，苦逼大学生，![img](warmsearch.assets/039D3F96.jpg)，万分感谢您！！！！

![zhifubao](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/zhifubao.jpg)

![weixing](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/warmsearch.assets/weixing.png)