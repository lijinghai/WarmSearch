<h1 align="center"> 校园失物招领网站 | Dorian </h1>

<p align="center">
 	<a href="https://github.com/Dorian1015/WarmSearch">
		<img src="https://img.shields.io/github/issues/Dorian1015/WarmSearch"
			 alt="Version">
	</a>
 	<a href="https://github.com/Dorian1015/WarmSearch">
		<img src="https://img.shields.io/github/forks/Dorian1015/WarmSearch"
			 alt="Status">
	</a>
    <a href="https://github.com/Dorian1015/WarmSearch">
		<img src="https://img.shields.io/github/stars/Dorian1015/WarmSearch"
			 alt="Status">
	</a>
</p>

<p align="center">
     <a href="https://github.com/Dorian1015/WarmSearch">
		<img src="https://img.shields.io/badge/Dorian-%E6%B5%B7-blue"
			 alt="Status">
	</a>
</p>

### 项目介绍 :book:

👉基于Springboot+vue+uni-app的校园失物招领平台. 含平台主体PC端、微信小程序和web后台数据管理平台.

* 失物招领信息一览
* 信息发布(支持图片上传)


### 项目技术栈 :star:

- PC端:Vue+Element-iu

* 小程序: Uni-app/微信小程序
* 后端: Java/SpringBoot/MySQL/Swagger/MybatisPlus/Json Web Tokens

#### 项目地址 :link:

项目采用前后端分离开发模式，PC端使用:Vue + Element-ui, 小程序使用Uni-app开发，后端数据API采用Java、Spring-Boot开发.

PC端Code地址：https://github.com/Dorian1015/WarmSearch-PC

小程序端code地址：https://github.com/Dorian1015/WarmSearch-uniapp

后端code地址：https://github.com/Dorian1015/WarmSearch

web管理端code地址: https://github.com/Dorian1015/WarmSearch-Web

#### 体验地址

由于项目还在不断完善中所有，目前还未上线；

主要还是因为穷，买不起服务器

演示视频：[在线演示视频]()

## 前言：

🏫本人目前（2021年5月8日）是一名大二在校大学生从去年（2020年)5月开始准备自学java，从基础到框架，利用课余时间从JavaWeb开始，到SSM,到SpringBoot,再到前端Html5,CSS3,JS,Vue.js,最后到Node.js，学完之后开始着手开始做这个校园失物招领网站，目前该项目大概原型已经呈现出来，这是基于前后端分离项目，目前利用课余时间，不断完善改项目。小白开始，若有错误，还望大家多多指教。各部分源码将在Github上持续更新。

##### 这是我的邮箱lijinghailjh@163.com,欢迎大家来指正

##### 最新代码将在[GitHub](https://github.com/Dorian1015)上持续更新

##### 在读大二学生（2021年5月8日）





## 说明

> 本项目前后端分离，前端(WarmSearch-PC）[参考锤子商城](https://www.smartisan.com/)

> 这是本项目的前台源码，后端源码请看[WarmSearch](https://github.com/Dorian1015/WarmSearch),本项目包括后台管理系统([WarmSearch-Web](https://github.com/Dorian1015/WarmSearch-Web))，前台系统（[WarmSearch-PC](https://github.com/Dorian1015/WarmSearch-PC))，微信小程序部分（[WarmSearch-uniapp](https://github.com/Dorian1015/WarmSearch-uniapp))

> #### 如果您觉得这项目还不错，可以在右上角`Star`支持一下，万分感谢！！！

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/0E503FDA.gif)

## 项目简介

- 本项目前后端分离，前端基于`Vue`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`，参考锤子商城实现。后端基于SpringBoot(框架) + JSON WEB TOKEN(令牌机制) + MybatisPlus + Mysql实现。

- 总体架构![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/clip_image002.jpg)

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

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/pc首页.png)

- 物品详情页

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/物品详情页.png)

- ###### 寻失物部分页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/寻物.png)

- #####  认领页面
![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/物品详情页2.png)

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/认领页.png)

- ##### 信息发布页面

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/信息发布页.png)

- ###### 寻失主部分页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/image-20210327001747782.png)

- ###### 捐赠部分页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/image-20210327001838330.png)



#### 2.微信小程序页面(WarmSearch-uniapp)

- #### 首页部分页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/image-20210327002845431.png)

- #### 寻物页面部分展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/image-20210327003137254.png)

#### 3.后台管理系统(WarmSearch-web)

- #### 部分页面展示

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/image-20210327003533589.png)

![img](https://cdn.jsdelivr.net/gh/Dorian1015/cdn/img/失物招领.assets/后端页面.png)



## 后期打算

### 如果你觉得我的项目，还不错，可以给我一下赞赏，本人现是一名大二学生，打算不断完善这个项目，所以我打算购买服务器，并部署上去；开源不易，如果你喜欢我的项目，可以给我投资一下我的服务器基金，苦逼大学生，万分感谢您！！！！






### 如果你能看到这里说明你肯定对我的项目感兴趣，那么请访问我的博客吧，里面会更新更详细的关于我这个项目的信息 [博客](https://dorian1015.github.io/)

### 或者你也可以通过Github首页的邮箱来联系我 lijinghailjh@163.com







