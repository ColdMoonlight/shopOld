# ShopTemplate

## 工作进度

pc 端进入开发测试阶段，暂不上测试服务器

注：发布到服务器时，注意修改 '/java/com/atguigu/controller/indexController.java'代码如下：

```
@RequestMapping("/isMobileOrPc")
	public static String  isMobileOrPc(HttpServletResponse reponse,HttpServletRequest request){
		String requestHeader = request.getHeader("user-agent");
		if(isMobileDevice(requestHeader)){
			System.out.println("使用手机浏览器");
			return "mfront/index";
		}else{
			System.out.println("使用web浏览器");
-			return "front/index";//真实PC首页
+			return "front/index2";//首页维修中图片
		}
	}
```
首页的大轮播图片 5张，在这个文件夹里
ShopTemplate\src\main\webapp\static\pcImg
