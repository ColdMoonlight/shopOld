package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MlbackAddCartViewDetail;
import com.atguigu.bean.MlbackAddCheakoutViewDetail;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlfrontCart;
import com.atguigu.bean.MlfrontCartItem;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.Msg;
import com.atguigu.bean.PageTimeVo;
import com.atguigu.service.MlbackAddCartViewDetailService;
import com.atguigu.service.MlbackAddCheakoutViewDetailService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlfrontCartItemService;
import com.atguigu.service.MlfrontCartService;
import com.atguigu.service.MlfrontOrderItemService;
import com.atguigu.service.MlfrontOrderService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.IfMobileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/MlbackCart")
public class MlfrontCartController {
	
	@Autowired
	MlfrontCartService mlfrontCartService;
	
	@Autowired
	MlfrontOrderService mlfrontOrderService;
	
	@Autowired
	MlfrontOrderItemService mlfrontOrderItemService;
	
	@Autowired
	MlfrontCartItemService mlfrontCartItemService;
	
	@Autowired
	MlbackProductService mlbackProductService;
	
	@Autowired
	MlbackAddCartViewDetailService mlbackProductViewDetailService;
	
	@Autowired
	MlbackAddCheakoutViewDetailService mlbackAddCheakoutViewDetailService;
	/**
	 * 1.0	useOn	0505
	 * 前台移动端解算页面mfront/cheakOut
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toCheakOut")
	public String toCheakOut(HttpServletResponse rep,HttpServletRequest res,HttpSession session) throws Exception{
		String ifMobile = IfMobileUtils.isMobileOrPc(rep, res);
		//1手机0PC
		if(ifMobile.equals("1")){
//			System.out.println("操作说明:进入wap-CheakOut页面");
			return "mfront/cheakOut";
		}else{
//			System.out.println("操作说明:进入PC-CheakOut页面");
			return "front/pccheakOut";
		}
	}
	
	/**
	 * 2.0	useOn	0530
	 * 添加产品项进购物车toAddToCart
	 * @param Msg
	 * @return 
	 * */
	@RequestMapping(value="/toAddToCart",method=RequestMethod.POST)
	@ResponseBody
	public Msg toAddToCart(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody MlfrontCartItem mlfrontCartItem) throws Exception{
		
		insertAddCartView(mlfrontCartItem,session);
		
		//放回响应域中
		session.setAttribute("mlfrontCartItem", mlfrontCartItem);
		
		String sessionId = session.getId();
		String Userip =sessionId;
		session.setAttribute("Userip", Userip);
		String nowTime = DateUtil.strTime14s();
		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		//判断session中是否有登录信息 ,if 有，新增进入cart中，没有新增进入
		if(loginUser==null){
			//获取ip信息，去cart中用ip查询，是否有该ip的购物车
			MlfrontCart MlfrontCartReq = new MlfrontCart();
			MlfrontCartReq.setCartIp(Userip);
			MlfrontCartReq.setCartStatus(0);
			List<MlfrontCart> MlfrontCartResList = mlfrontCartService.selectMlfrontCartByIp(MlfrontCartReq);
			Integer ifHave = 1;
			if(MlfrontCartResList.size()>0){
				String cartitemIdstrUser = MlfrontCartResList.get(0).getCartitemIdstr();
				if(cartitemIdstrUser.length()>0){
					ifHave = 1;
				}else{
					//名下有购物车,但是为空
					Integer cartId = MlfrontCartResList.get(0).getCartId();
					MlfrontCart MlfrontCartdelRep = new MlfrontCart();
					MlfrontCartdelRep.setCartId(cartId);
					mlfrontCartService.deleteByPrimaryKey(cartId);
					ifHave = 0;
					//此时要删掉这个为空的购物车
				}
			}else{
				//如果名下没购物车
				ifHave = 0;
			}
			if(ifHave==1){
				//如果有，获取该购物车的itemStr,
				MlfrontCart mlfrontCartUser = MlfrontCartResList.get(0);
				String cartitemIdstrUser = mlfrontCartUser.getCartitemIdstr();
				Integer cartId = mlfrontCartUser.getCartId();
				Integer cartUid = mlfrontCartUser.getCartUid();
				//判断是否有本次添加的产品，如果没有itemStr中加入本次的productId,
				Integer pid = mlfrontCartItem.getCartitemProductId();
				String skuIdstr = mlfrontCartItem.getCartitemProductskuIdstr();
				String skuIdnamestr = mlfrontCartItem.getCartitemProductskuIdnamestr();
				String skuNamestr =mlfrontCartItem.getCartitemProductskuNamestr();
				int proNumberNew =mlfrontCartItem.getCartitemProductNumber();
			//	String pidStr = pid+"";
				String[] aa = cartitemIdstrUser.split(",");
				int number = 0;
				for(int i=0;i<aa.length;i++){
					number++;
					String CartItemId = aa[i];
					Integer CartItemIdInt =Integer.parseInt(CartItemId);
					MlfrontCartItem mlfrontCartItemFor = new MlfrontCartItem();
					mlfrontCartItemFor.setCartitemId(CartItemIdInt);
					mlfrontCartItemFor.setCartitemProductId(pid);
					mlfrontCartItemFor.setCartitemProductskuIdstr(skuIdstr);
					mlfrontCartItemFor.setCartitemProductskuIdnamestr(skuIdnamestr);
					mlfrontCartItemFor.setCartitemProductskuNamestr(skuNamestr);
					//查看该id+该pid+skuIdstr+skuIdnamestr+skuNamestr时候已经有了
					List<MlfrontCartItem> mlfrontCartItemListFor= mlfrontCartItemService.selectMlfrontCartItemOne(mlfrontCartItemFor);
					if(mlfrontCartItemListFor.size()>0){
						//如果存在
						MlfrontCartItem mlfrontCartItemOne = mlfrontCartItemListFor.get(0);
						int ProductNumber = mlfrontCartItemOne.getCartitemProductNumber();
						//该sku的Cartitem的number+1,
						ProductNumber= ProductNumber+proNumberNew;
						mlfrontCartItemOne.setCartitemId(CartItemIdInt);
						mlfrontCartItemOne.setCartitemProductNumber(ProductNumber);
						mlfrontCartItemOne.setCartitemCreatetime(nowTime);
						mlfrontCartItemOne.setCartitemMotifytime(nowTime);
						//更新
						mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemOne);
						break;
					}else{
						if(number <aa.length){
							continue;
						}else{
							//没有该sku的Cartitem	新增该条Cartitem sku
							//将该id写入cart对象的cartItemStr中
							System.out.println("操作说明：当前客户添加购物车,此前购物车中不包含本次添加的产品"); 
							//将本id加入原来的idstr中
							//更新一下该user的购物车中的cartitemIdstr字段
							mlfrontCartItem.setCartitemStatus(0);
							mlfrontCartItem.setCartitemCreatetime(nowTime);
							mlfrontCartItem.setCartitemMotifytime(nowTime);
							Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
							mlfrontCartItem.setCartitemProductActoff(accoff*10);
							mlfrontCartItemService.insertSelective(mlfrontCartItem);
							
//							List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
//							Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
							Integer cartItemId = mlfrontCartItem.getCartitemId();

							String cartItemIdStrnew = cartItemId+"";
							cartitemIdstrUser=cartitemIdstrUser+","+cartItemIdStrnew;
							MlfrontCart mlfrontCartAfter = new MlfrontCart();
							mlfrontCartAfter.setCartId(cartId);
							mlfrontCartAfter.setCartUid(cartUid);
							mlfrontCartAfter.setCartitemIdstr(cartitemIdstrUser);
							mlfrontCartAfter.setCartMotifytime(nowTime);
							mlfrontCartService.updateByPrimaryKeySelective(mlfrontCartAfter);
							//将本mlfrontCartItem插入mlfrontCartItem表中
							//更新本条cartitem,
							mlfrontCartItem.setCartitemId(cartItemId);
							mlfrontCartItem.setCartitemCartId(cartId);
							mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
							break;
						}
					}
				}
			}else{
				//这个ip没来过，直接新增一条即可mlfrontCartItem，将主键放入cart对象中，之后在新增该对象cart
				mlfrontCartItem.setCartitemCreatetime(nowTime);
				mlfrontCartItem.setCartitemMotifytime(nowTime);
				mlfrontCartItem.setCartitemStatus(0);
				mlfrontCartItemService.insertSelective(mlfrontCartItem);
				
//				List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
//				Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
				
				Integer cartItemId = mlfrontCartItem.getCartitemId();

				//拿回来主键ID		mlfrontCartItem
				MlfrontCart MlfrontCartItemReturn = new MlfrontCart();
				String cartItemIdStr = cartItemId+"";
				MlfrontCartItemReturn.setCartitemIdstr(cartItemIdStr);
				MlfrontCartItemReturn.setCartIp(Userip);
				MlfrontCartItemReturn.setCartStatus(0);
				MlfrontCartItemReturn.setCartCreatetime(nowTime);
				MlfrontCartItemReturn.setCartMotifytime(nowTime);
				//折扣*10
				Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
				mlfrontCartItem.setCartitemProductActoff(accoff*10);
				mlfrontCartService.insertSelective(MlfrontCartItemReturn);
//				List<MlfrontCart> mlfrontCartInsertAfterList= mlfrontCartService.selectMlfrontCartGetAll();
//				Integer cartAfterId = mlfrontCartInsertAfterList.get(0).getCartId();
				
				Integer cartAfterId = MlfrontCartItemReturn.getCartId();

				mlfrontCartItem.setCartitemId(cartItemId);
				mlfrontCartItem.setCartitemCartId(cartAfterId);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
			}
		}else{
			//获取uid信息，去cart中用uid查询，是否有该uid的购物车
			MlfrontCart MlfrontCartReq = new MlfrontCart();
			Integer uid =loginUser.getUserId();
			MlfrontCartReq.setCartUid(uid);
			MlfrontCartReq.setCartStatus(0);
			List<MlfrontCart> MlfrontCartResList = mlfrontCartService.selectMlfrontCartByUidAndStatus(MlfrontCartReq);
			Integer ifHave = 1;
			if(MlfrontCartResList.size()>0){
				String cartitemIdstrUser = MlfrontCartResList.get(0).getCartitemIdstr();
				if(cartitemIdstrUser.length()>0){
					ifHave = 1;
				}else{
					//名下有购物车,但是为空
					Integer cartId = MlfrontCartResList.get(0).getCartId();
					MlfrontCart MlfrontCartdelRep = new MlfrontCart();
					MlfrontCartdelRep.setCartId(cartId);
					mlfrontCartService.deleteByPrimaryKey(cartId);
					ifHave = 0;
					//此时要删掉这个为空的购物车
				}
			}else{
				//如果名下没购物车
				ifHave = 0;
			}
			if(ifHave==1){
				//如果有，获取该购物车的itemStr,
				MlfrontCart mlfrontCartUser = MlfrontCartResList.get(0);
				String cartitemIdstrUser = mlfrontCartUser.getCartitemIdstr();
				Integer cartId = mlfrontCartUser.getCartId();
				Integer cartUid = mlfrontCartUser.getCartUid();
				//判断是否有本次添加的产品，如果没有itemStr中加入本次的productId,
				Integer pid = mlfrontCartItem.getCartitemProductId();
				String skuIdstr = mlfrontCartItem.getCartitemProductskuIdstr();
				String skuIdnamestr = mlfrontCartItem.getCartitemProductskuIdnamestr();
				String skuNamestr =mlfrontCartItem.getCartitemProductskuNamestr();
				int proNumberNew =mlfrontCartItem.getCartitemProductNumber();
				//String pidStr = pid+"";
				String[] aa = cartitemIdstrUser.split(",");
				int number = 0;
				for(int i=0;i<aa.length;i++){
					number++;
					String CartItemId = aa[i];
					Integer CartItemIdInt =Integer.parseInt(CartItemId);
					MlfrontCartItem mlfrontCartItemFor = new MlfrontCartItem();
					mlfrontCartItemFor.setCartitemId(CartItemIdInt);
					mlfrontCartItemFor.setCartitemProductId(pid);
					mlfrontCartItemFor.setCartitemProductskuIdstr(skuIdstr);
					mlfrontCartItemFor.setCartitemProductskuIdnamestr(skuIdnamestr);
					mlfrontCartItemFor.setCartitemProductskuNamestr(skuNamestr);
					//查看该id+该pid+skuIdstr+skuIdnamestr+skuNamestr时候已经有了
					List<MlfrontCartItem> mlfrontCartItemListFor= mlfrontCartItemService.selectMlfrontCartItemOne(mlfrontCartItemFor);
					if(mlfrontCartItemListFor.size()>0){
						//如果存在
						MlfrontCartItem mlfrontCartItemOne = mlfrontCartItemListFor.get(0);
						int ProductNumber = mlfrontCartItemOne.getCartitemProductNumber();
						//该sku的Cartitem的number+1,
						ProductNumber= ProductNumber+proNumberNew;
						mlfrontCartItemOne.setCartitemId(CartItemIdInt);
						mlfrontCartItemOne.setCartitemProductNumber(ProductNumber);
						mlfrontCartItemOne.setCartitemCreatetime(nowTime);
						mlfrontCartItemOne.setCartitemMotifytime(nowTime);
						//更新
						mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemOne);
						break;
					}else{
						if(number <aa.length){
							continue;
						}else{
							//没有该sku的Cartitem
							//新增该条Cartitem sku
							//将该id写入cart对象的cartItemStr中
							System.out.println("操作说明：当前客户添加购物车,此前购物车中不包含本次添加的产品"); 
							//将本id加入原来的idstr中
							//更新一下该user的购物车中的cartitemIdstr字段
							mlfrontCartItem.setCartitemStatus(0);
							mlfrontCartItem.setCartitemCreatetime(nowTime);
							mlfrontCartItem.setCartitemMotifytime(nowTime);
							//折扣*10
							Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
							mlfrontCartItem.setCartitemProductActoff(accoff*10);
							mlfrontCartItemService.insertSelective(mlfrontCartItem);
							
//							List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
//							Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
							
							Integer cartItemId = mlfrontCartItem.getCartitemId();

							String cartItemIdStrnew = cartItemId+"";
							cartitemIdstrUser=cartitemIdstrUser+","+cartItemIdStrnew;
							MlfrontCart mlfrontCartAfter = new MlfrontCart();
							mlfrontCartAfter.setCartId(cartId);
							mlfrontCartAfter.setCartUid(cartUid);
							mlfrontCartAfter.setCartitemIdstr(cartitemIdstrUser);
							mlfrontCartAfter.setCartMotifytime(nowTime);
							mlfrontCartService.updateByPrimaryKeySelective(mlfrontCartAfter);
							//将本mlfrontCartItem插入mlfrontCartItem表中
							//更新本条cartitem,
							mlfrontCartItem.setCartitemId(cartItemId);
							mlfrontCartItem.setCartitemCartId(cartId);
							mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
							break;
						}
					}
				}
			}else{
				//这个ip没来过，直接新增一条即可mlfrontCartItem，将主键放入cart对象中，之后在新增该对象cart
				mlfrontCartItem.setCartitemCreatetime(nowTime);
				mlfrontCartItem.setCartitemMotifytime(nowTime);
				mlfrontCartItem.setCartitemStatus(0);
				//折扣*10
				Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
				mlfrontCartItem.setCartitemProductActoff(accoff*10);
				mlfrontCartItemService.insertSelective(mlfrontCartItem);
				
//				List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
//				Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
				
				Integer cartItemId = mlfrontCartItem.getCartitemId();

				//拿回来主键ID		mlfrontCartItem
				MlfrontCart MlfrontCartItemReturn = new MlfrontCart();
				String cartItemIdStr = cartItemId+"";
				MlfrontCartItemReturn.setCartitemIdstr(cartItemIdStr);
				MlfrontCartItemReturn.setCartUid(uid);
				MlfrontCartItemReturn.setCartStatus(0);
				MlfrontCartItemReturn.setCartCreatetime(nowTime);
				MlfrontCartItemReturn.setCartMotifytime(nowTime);
				mlfrontCartService.insertSelective(MlfrontCartItemReturn);
				
//				List<MlfrontCart> mlfrontCartInsertAfterList= mlfrontCartService.selectMlfrontCartGetAll();
//				Integer cartAfterId = mlfrontCartInsertAfterList.get(0).getCartId();
				
				Integer cartAfterId = MlfrontCartItemReturn.getCartId();

				mlfrontCartItem.setCartitemId(cartItemId);
				mlfrontCartItem.setCartitemCartId(cartAfterId);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
			}
		}
		return Msg.success().add("resMsg", "添加成功");
	}	
	
	
	//记录加购数量
	private void insertAddCartView(MlfrontCartItem mlfrontCartItem, HttpSession session) {
		String nowViewTime = DateUtil.strTime14s();
		//获取该产品id
		Integer productId = mlfrontCartItem.getCartitemProductId();
		//通过pid查回该产品
		MlbackProduct mlbackProductrep = new MlbackProduct();
		mlbackProductrep.setProductId(productId);
		List<MlbackProduct> mlbackProductresList = mlbackProductService.selectMlbackProduct(mlbackProductrep);
		MlbackProduct mlbackProductres = mlbackProductresList.get(0);
		//拿到seo名字+产品名
		String addcartviewdetailSeoname = mlbackProductres.getProductSeo();
		String addcartviewdetailProname = mlbackProductres.getProductName();
		System.out.println("操作说明:nowViewTime,"+nowViewTime+",toAddToCart	:"+addcartviewdetailSeoname);
		//准备参数信息
		MlbackAddCartViewDetail mlbackAddCartViewDetailreq = new MlbackAddCartViewDetail();
		//浏览对象
		mlbackAddCartViewDetailreq.setAddcartviewdetailSeoname(addcartviewdetailSeoname);
		mlbackAddCartViewDetailreq.setAddcartviewdetailProname(addcartviewdetailProname);
		//sessionID
		String sessionId =  session.getId();
		mlbackAddCartViewDetailreq.setAddcartviewdetailSessionid(sessionId);
		//时间信息
		String nowTime = DateUtil.strTime14s();
		mlbackAddCartViewDetailreq.setAddcartviewdetailCreatetime(nowTime);
		mlbackAddCartViewDetailreq.setAddcartviewdetailMotifytime(nowTime);
		mlbackAddCartViewDetailreq.setAddcartviewdetailActNum(0); //计数用户行为，0纯加购	，1点buyNow附带的加购
		mlbackProductViewDetailService.insertSelective(mlbackAddCartViewDetailreq);
	}
	
	/**3.0	useOn	0505
	 * getCartProductNumber	POST
	 * @param 
	 */
	@RequestMapping(value="/getCartProductNumber",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCartProductNumber(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		String sessionId = session.getId();
		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		//判断session中是否有登录信息 ,if 有，新增进入cart中，没有新增进入
		int number = 0;
		String Userip =sessionId;
		MlfrontCart MlfrontCartReq = new MlfrontCart();
		MlfrontCartReq.setCartStatus(0);
		if(loginUser==null){
			MlfrontCartReq.setCartIp(Userip);
			//查询是否有生效中的购物车
			List<MlfrontCart> mlfrontCartResList = mlfrontCartService.selectMlfrontCartByIp(MlfrontCartReq);
			if(mlfrontCartResList.size()>0){
				String cartitemIdStr = mlfrontCartResList.get(0).getCartitemIdstr();
				if(cartitemIdStr.length()>0){
					String[] aa = cartitemIdStr.split(",");
					number=aa.length;
				}
				//System.out.println(number);
			}else{
				number = 0;
			}
		}else{
			Integer uid = loginUser.getUserId();
			MlfrontCartReq.setCartUid(uid);
			//查询是否有生效中的购物车
			List<MlfrontCart> mlfrontCartResList = mlfrontCartService.selectMlfrontCartByUidAndStatus(MlfrontCartReq);
			if(mlfrontCartResList.size()>0){
				String cartitemIdStr = mlfrontCartResList.get(0).getCartitemIdstr();
				if(cartitemIdStr.length()>0){
					String[] aa = cartitemIdStr.split(",");
					number=aa.length;
				}
				//System.out.println(number);
			}else{
				number = 0;
			}
		}
		return Msg.success().add("resMsg", "更新成功").add("number", number);
	}
	
	/**
	 * 4.0	useOn	0505
	 * 前台购物车列表页面CartList
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toCartList")
	public String toCartList(HttpServletResponse rep,HttpServletRequest res,HttpSession session) throws Exception{
		
		//判断来源的设备
		String ifMobile = IfMobileUtils.isMobileOrPc(rep, res);
		if(ifMobile.equals("1")){
			  return "mfront/cartList";
		  }else{
			  return "front/pccartList";
		  }
	}
	
	/**5.0	useOn	0505
	 * getCartitemIdDetails	get
	 * @param
	 */
//	@SuppressWarnings("unused")
	@RequestMapping(value="/getCartitemIdDetails",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCartitemIdDetails(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		String sessionId = session.getId();
		String Userip =sessionId;
		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		MlfrontCart MlfrontCartReq = new MlfrontCart();
		MlfrontCartReq.setCartStatus(0);
		List<MlfrontCart> mlfrontCartResList = new ArrayList<MlfrontCart>();
		if(loginUser==null){
			MlfrontCartReq.setCartIp(Userip);
			mlfrontCartResList = mlfrontCartService.selectMlfrontCartByIp(MlfrontCartReq);
		}else{
			Integer Uid = loginUser.getUserId();
			MlfrontCartReq.setCartUid(Uid);
			mlfrontCartResList = mlfrontCartService.selectMlfrontCartByUidAndStatus(MlfrontCartReq);
		}
		String cartitemIdStr = mlfrontCartResList.get(0).getCartitemIdstr();
		String[] aa = cartitemIdStr.split(",");
		List<MlfrontCartItem> mlfrontCartItemListRes = new ArrayList<MlfrontCartItem>();
		for(int i=0;i<aa.length;i++){
			String CartItemId = aa[i];
			Integer CartItemIdInt =Integer.parseInt(CartItemId);
			MlfrontCartItem mlfrontCartItemFor = new MlfrontCartItem();
			mlfrontCartItemFor.setCartitemId(CartItemIdInt);
			//查看该id+该pid时候已经有了
			List<MlfrontCartItem> mlfrontCartItemListFor= mlfrontCartItemService.selectMlfrontCartItemById(mlfrontCartItemFor);
			if(mlfrontCartItemListFor.size()>0){
				mlfrontCartItemListRes.add(mlfrontCartItemListFor.get(0));
			}
		}
		return Msg.success().add("resMsg", "更新成功").add("mlfrontCartItemListRes", mlfrontCartItemListRes);
	}
	
	/**
	 * 6.0	0530
	 * 选择购物车中的产品项，提交生成订单cartToOrder
	 * 1接住传入的List《cartItem》，遍历 insert订单orderItem。插入order表，返回orderId
	 * 2遍历，更新orderItem中的orderId归属字段；
	 * 3从cart中，把cartItemIdstr字段，更新。  这一步骤，不该出现在这，要放在生成订单那里。就没事了
	 * @param Msg
	 * @return 
	 * */
	@RequestMapping(value="/cartToOrder",method=RequestMethod.POST)
	@ResponseBody
	public Msg cartToOrder(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody List<MlfrontCartItem> mlfrontCartItemList) throws Exception{
		//计算cart到boynow的加购次数
		calcFormCartListToCheakoutPage(mlfrontCartItemList,session);
		//接收传递进来的参数
		//System.out.println("mlfrontCartItemList:"+mlfrontCartItemList.size());
		//从其中一个中获取cartId
		Integer cartId = 0;
		String sessionId = session.getId();
		Integer orderIdFinally = 0;
		//获取ip地址
		String Userip =sessionId;
		session.setAttribute("Userip", Userip);
		String nowTime = DateUtil.strTime14s();
		List<String> cartItemIdStr = new ArrayList<String>();
		List<String> orderItemIdList = new ArrayList<String>();
		String orderItemIdStr = "";
		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		MlfrontCartItem mlfrontCartItemGet = new MlfrontCartItem();
		if(loginUser==null){
			//loginUser为null
			MlfrontOrderItem mlfrontOrderItemNew = new MlfrontOrderItem();
			for(MlfrontCartItem mlfrontCartItem:mlfrontCartItemList){
				System.out.println(mlfrontCartItem);
				//取出本条cartItem
				Integer cartitemIdInt = mlfrontCartItem.getCartitemId();
				//cartId = mlfrontCartItem.getCartitemCartId();
				mlfrontCartItemGet.setCartitemId(cartitemIdInt);
				List<MlfrontCartItem> mlfrontCartItemGetRes =mlfrontCartItemService.selectMlfrontCartItemById(mlfrontCartItemGet);
				//将该购物项，改成已用
				mlfrontCartItemGet.setCartitemStatus(1);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemGet);
				MlfrontCartItem mlfrontCartItemreturn = mlfrontCartItemGetRes.get(0);
				cartId = mlfrontCartItemreturn.getCartitemCartId();
				String cartitemIdIntStrOne = cartitemIdInt+"";
				cartItemIdStr.add(cartitemIdIntStrOne);
				//封装mlfrontOrderItem对象，准备insert进入mlfrontOrderItem表
				mlfrontOrderItemNew.setOrderCartItemId(cartitemIdInt);
				mlfrontOrderItemNew.setOrderitemPid(mlfrontCartItem.getCartitemProductId());
				mlfrontOrderItemNew.setOrderitemPname(mlfrontCartItemreturn.getCartitemProductName());
				mlfrontOrderItemNew.setOrderitemProductMainimgurl(mlfrontCartItemreturn.getCartitemProductMainimgurl());
				mlfrontOrderItemNew.setOrderitemProductOriginalprice(mlfrontCartItemreturn.getCartitemProductOriginalprice());
				mlfrontOrderItemNew.setOrderitemProductAccoff(mlfrontCartItemreturn.getCartitemProductActoff());
				mlfrontOrderItemNew.setOrderitemPskuIdstr(mlfrontCartItemreturn.getCartitemProductskuIdstr());
				mlfrontOrderItemNew.setOrderitemPskuIdnamestr(mlfrontCartItemreturn.getCartitemProductskuIdnamestr());
				mlfrontOrderItemNew.setOrderitemPskuNamestr(mlfrontCartItemreturn.getCartitemProductskuNamestr());
				mlfrontOrderItemNew.setOrderitemPskuMoneystr(mlfrontCartItemreturn.getCartitemProductskuMoneystr());
				//mlfrontOrderItemNew.setOrderitemPskuReamoney("这个值是需要计算的");
				mlfrontOrderItemNew.setOrderitemPskuNumber(mlfrontCartItem.getCartitemProductNumber());
				mlfrontOrderItemNew.setOrderitemCreatetime(nowTime);
				mlfrontOrderItemNew.setOrderitemMotifytime(nowTime);
				mlfrontOrderItemService.insertSelective(mlfrontOrderItemNew);
				//获取新生成的id
				MlfrontOrderItem MlfrontOrderItemReallOne =mlfrontOrderItemService.selectMlfrontOrderItemAll().get(0);
				Integer orderItemNewId = MlfrontOrderItemReallOne.getOrderitemId();
				String orderItemNewIdStr = orderItemNewId+"";
				//存档便于以后用
				orderItemIdList.add(orderItemNewIdStr);
				orderItemIdStr=orderItemIdStr+","+orderItemNewIdStr;
			}
			//插入订单对象
			orderItemIdStr = orderItemIdStr.substring(1);
			MlfrontOrder mlfrontOrderNew  = new MlfrontOrder();
			mlfrontOrderNew.setOrderOrderitemidstr(orderItemIdStr);
			mlfrontOrderNew.setOrderIp(Userip);
			mlfrontOrderNew.setOrderStatus(0);//cart To Order
			mlfrontOrderNew.setOrderCreatetime(nowTime);
			mlfrontOrderNew.setOrderMotifytime(nowTime);
			mlfrontOrderService.insertSelective(mlfrontOrderNew);
			//获取新生成的id
			MlfrontOrder mlfrontOrdergetAllOne = mlfrontOrderService.selectMlfrontOrderAll().get(0);
			//后更新每个orderItem对象
			Integer orderId = mlfrontOrdergetAllOne.getOrderId();
			orderIdFinally = orderId;
			MlfrontOrderItem mlfrontOrderItemOldone = new MlfrontOrderItem();
			for(String orderItemIdOld:orderItemIdList){
				Integer orderItemIdOldInt =  Integer.parseInt(orderItemIdOld);
				mlfrontOrderItemOldone.setOrderitemId(orderItemIdOldInt);
				mlfrontOrderItemOldone.setOrderId(orderId);
				mlfrontOrderItemService.updateByPrimaryKeySelective(mlfrontOrderItemOldone);
			}
		}else{
			//loginUser不为null
			Integer Uid = loginUser.getUserId();
			MlfrontOrderItem mlfrontOrderItemNew = new MlfrontOrderItem();
			for(MlfrontCartItem mlfrontCartItem:mlfrontCartItemList){
				System.out.println(mlfrontCartItem);
				//取出本条cartItem
				Integer cartitemIdInt = mlfrontCartItem.getCartitemId();
				//cartId = mlfrontCartItem.getCartitemCartId();
				mlfrontCartItemGet.setCartitemId(cartitemIdInt);
				List<MlfrontCartItem> mlfrontCartItemGetRes =mlfrontCartItemService.selectMlfrontCartItemById(mlfrontCartItemGet);
				//将该购物项，改成已用
				mlfrontCartItemGet.setCartitemStatus(1);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemGet);
				MlfrontCartItem mlfrontCartItemreturn = mlfrontCartItemGetRes.get(0);
				cartId = mlfrontCartItemreturn.getCartitemCartId();
				String cartitemIdIntStrOne = cartitemIdInt+"";
				cartItemIdStr.add(cartitemIdIntStrOne);
				//封装mlfrontOrderItem对象，准备insert进入mlfrontOrderItem表
				mlfrontOrderItemNew.setOrderCartItemId(cartitemIdInt);
				mlfrontOrderItemNew.setOrderitemPid(mlfrontCartItem.getCartitemProductId());
				mlfrontOrderItemNew.setOrderitemPname(mlfrontCartItemreturn.getCartitemProductName());
				mlfrontOrderItemNew.setOrderitemProductMainimgurl(mlfrontCartItemreturn.getCartitemProductMainimgurl());
				mlfrontOrderItemNew.setOrderitemProductOriginalprice(mlfrontCartItemreturn.getCartitemProductOriginalprice());
				mlfrontOrderItemNew.setOrderitemProductAccoff(mlfrontCartItemreturn.getCartitemProductActoff());
				mlfrontOrderItemNew.setOrderitemPskuIdstr(mlfrontCartItemreturn.getCartitemProductskuIdstr());
				mlfrontOrderItemNew.setOrderitemPskuIdnamestr(mlfrontCartItemreturn.getCartitemProductskuIdnamestr());
				mlfrontOrderItemNew.setOrderitemPskuNamestr(mlfrontCartItemreturn.getCartitemProductskuNamestr());
				mlfrontOrderItemNew.setOrderitemPskuMoneystr(mlfrontCartItemreturn.getCartitemProductskuMoneystr());
				//mlfrontOrderItemNew.setOrderitemPskuReamoney("这个值是需要计算的");
				mlfrontOrderItemNew.setOrderitemPskuNumber(mlfrontCartItem.getCartitemProductNumber());
				mlfrontOrderItemNew.setOrderitemCreatetime(nowTime);
				mlfrontOrderItemNew.setOrderitemMotifytime(nowTime);
				mlfrontOrderItemService.insertSelective(mlfrontOrderItemNew);
				//获取新生成的id
				MlfrontOrderItem MlfrontOrderItemReallOne =mlfrontOrderItemService.selectMlfrontOrderItemAll().get(0);
				Integer orderItemNewId = MlfrontOrderItemReallOne.getOrderitemId();
				String orderItemNewIdStr = orderItemNewId+"";
				//存档便于以后用
				orderItemIdList.add(orderItemNewIdStr);
				orderItemIdStr=orderItemIdStr+","+orderItemNewIdStr;
			}
			
			//插入订单对象
			orderItemIdStr = orderItemIdStr.substring(1);
			MlfrontOrder mlfrontOrderNew  = new MlfrontOrder();
			mlfrontOrderNew.setOrderOrderitemidstr(orderItemIdStr);
			mlfrontOrderNew.setOrderUid(Uid);//这是登录用户，存错登录状态
			mlfrontOrderNew.setOrderStatus(0);//cart To Order
			mlfrontOrderNew.setOrderCreatetime(nowTime);
			mlfrontOrderNew.setOrderMotifytime(nowTime);
			mlfrontOrderService.insertSelective(mlfrontOrderNew);
			//获取新生成的id
			MlfrontOrder mlfrontOrdergetAllOne = mlfrontOrderService.selectMlfrontOrderAll().get(0);
			//后更新每个orderItem对象
			Integer orderId = mlfrontOrdergetAllOne.getOrderId();
			orderIdFinally = orderId;
			MlfrontOrderItem mlfrontOrderItemOldone = new MlfrontOrderItem();
			for(String orderItemIdOld:orderItemIdList){
				Integer orderItemIdOldInt =  Integer.parseInt(orderItemIdOld);
				mlfrontOrderItemOldone.setOrderitemId(orderItemIdOldInt);
				mlfrontOrderItemOldone.setOrderId(orderId);
				mlfrontOrderItemService.updateByPrimaryKeySelective(mlfrontOrderItemOldone);
			}
		}
		session.setAttribute("orderId", orderIdFinally);
		//返回视图
		return Msg.success().add("resMsg", "订单提交成功");
	}
	
	/**
	 * 7.0	zsh 0615
	 * 删除购物车中的项delCartItem
	 * @param Msg
	 * @return 
	 * */
	@RequestMapping(value="/delCartItem",method=RequestMethod.POST)
	@ResponseBody
	public Msg delCartItem(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody MlfrontCartItem mlfrontCartItem) throws Exception{
		//接收传递进来的参数
		Integer cartItemIdOriginal = mlfrontCartItem.getCartitemId();
		int isDelSuccess = 0;
		if(cartItemIdOriginal==null){
			return Msg.success().add("resMsg", "删除失败，主建为null，请联系管理员").add("isDelSuccess", isDelSuccess);//isDelSuccess0删除失败，alert	resMsg/1,删除成功
		}else{
			//通过cartitem的之间查回该条信息，从中取出cartId
			MlfrontCartItem mlfrontCartItemReqq  =new MlfrontCartItem();
			mlfrontCartItemReqq.setCartitemId(cartItemIdOriginal);
			List<MlfrontCartItem> mlfrontCartItemRessList = mlfrontCartItemService.selectMlfrontCartItemById(mlfrontCartItemReqq);
			if(mlfrontCartItemRessList.size()>0){
				Integer cartId = mlfrontCartItemRessList.get(0).getCartitemCartId();
				String cartItemIdOriginalStr = cartItemIdOriginal+"";
				String nowTime = DateUtil.strTime14s();
				MlfrontCart MlfrontCartReq = new MlfrontCart();
				MlfrontCartReq.setCartId(cartId);
				MlfrontCart mlfrontCartRes  = mlfrontCartService.selectMlfrontCartByCartId(cartId);
				//1根据cart该购物车中的本条cartItemStr中的字段
				String cartitemIdstr = mlfrontCartRes.getCartitemIdstr();
				String cartItemArr[] =cartitemIdstr.split(",");
				String cartitemStrEnd = "";
				if(cartItemArr.length>1){
					//1.1如果有多个删除字段中的该项
					for(int i =0;i<cartItemArr.length;i++){
						String tem = cartItemArr[i];
						if(tem.equals(cartItemIdOriginalStr)){
							continue;
						}else{
							cartitemStrEnd=cartitemStrEnd+tem+",";
						}
					}
					int lastIN = cartitemStrEnd.length();
					cartitemStrEnd = cartitemStrEnd.substring(0, (lastIN-1));
					//更新cart中的cartitemStr字段
					MlfrontCart mlfrontCartreqE = new MlfrontCart();
					mlfrontCartreqE.setCartId(cartId);
					mlfrontCartreqE.setCartitemIdstr(cartitemStrEnd);
					mlfrontCartreqE.setCartMotifytime(nowTime);
					mlfrontCartService.updateByPrimaryKeySelective(mlfrontCartreqE);
				}else{
					//1.2如果只有一个，删掉购物车
					Integer result = mlfrontCartService.deleteByPrimaryKey(cartId);
				}
				//2删除该条CartItem信息
				mlfrontCartItemService.deleteByPrimaryKey(cartItemIdOriginal);
				isDelSuccess = 1;
				return Msg.success().add("resMsg", "删除成功").add("isDelSuccess", isDelSuccess);//isDelSuccess0删除失败，alert	resMsg/1,删除成功
			}else{
				return Msg.success().add("resMsg", "删除失败，该cartitem项不存在，请联系管理员").add("isDelSuccess", isDelSuccess);//isDelSuccess0删除失败，alert	resMsg/1,删除成功
			}
		}			
	}
	
	/**
	 * 8.0	zsh 0624
	 * 添加产品项进购物车updateCartItemSkuNum
	 * @param
	 * @return Msg
	 * */
	@RequestMapping(value="/updateCartItemSkuNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateCartItemSkuNum(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody MlfrontCartItem mlfrontCartItem) throws Exception{
		//接收传递进来的参数
		Integer cartItemIdOriginal = mlfrontCartItem.getCartitemId();
		Integer number = mlfrontCartItem.getCartitemProductNumber();
		
		MlfrontCartItem MlfrontCartItemUpdate = new MlfrontCartItem();
		MlfrontCartItemUpdate.setCartitemId(cartItemIdOriginal);
		MlfrontCartItemUpdate.setCartitemProductNumber(number);
		String nowTime = DateUtil.strTime14s();
		MlfrontCartItemUpdate.setCartitemMotifytime(nowTime);
		//2删除该条CartItem信息
		mlfrontCartItemService.updateByPrimaryKeySelective(MlfrontCartItemUpdate);
		
		return Msg.success().add("resMsg", "mlfrontCartItemUpdate successful");
	}
	
	
	/**
	 * 9.0	UseNow	0505
	 * to	MlfrontOrder列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getMlfrontCartByDate",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlfrontCartByDate(HttpServletResponse rep,HttpServletRequest res,HttpSession session ,@RequestBody PageTimeVo pageTime){
	
		Integer pn = pageTime.getPn();
		if(pn==null){
			pn=1;
		}
		String beginTime = pageTime.getBeginTime();
		String endTime = pageTime.getEndTime();
		
		MlfrontCart mlfrontCartReq = new MlfrontCart();
		mlfrontCartReq.setCartCreatetime(beginTime);
		mlfrontCartReq.setCartMotifytime(endTime);
		
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlfrontCart> mlfrontCartReqList = mlfrontCartService.selectMlfrontCartByDate(mlfrontCartReq);
			Integer countNumber =mlfrontCartReqList.size();
			PageInfo page = new PageInfo(mlfrontCartReqList, PagNum);
			return Msg.success().add("pageInfo", page).add("countNumber", countNumber).add("resMsg", "加购数查询成功");
	}
	
	/**
	 * 10.0	useOn	0505
	 * 查看单条类目的详情细节
	 * @param mlfrontOrderOne
	 * @return 
	 */
	@RequestMapping(value="/getOneMlfrontCartDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlfrontCartDetail(@RequestParam(value = "cartId") Integer cartId){
		
		//接受categoryId
		MlfrontCart mlfrontCartReq = new MlfrontCart();
		mlfrontCartReq.setCartId(cartId);
		//查询本条
		MlfrontCart mlfrontOrderResList =mlfrontCartService.selectMlfrontCartByCartId(cartId);
		MlfrontCart mlfrontCartOne = new MlfrontCart();
		if(mlfrontOrderResList!=null){
			mlfrontCartOne =mlfrontOrderResList;
		}
		return Msg.success().add("resMsg", "查看单条mlfrontOrderOne的详情细节完毕")
					.add("mlfrontCartOne", mlfrontCartOne);
	}
	
	/**
	 * 11.0	UseNow	0505
	 * to	MlfrontCartItem列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getMlfrontCartItemByPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlfrontCartItemByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
		int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
			PageInfo page = new PageInfo(mlfrontCartItemList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**
	 * 12.0	useOn	0505
	 * to	MlfrontCart列表页面
	 * @param jsp
	 * @return  
	 * */
	@RequestMapping("/toMlbackCartPage")
	public String toMlfrontCartPage() throws Exception{
	
		return "back/mlbackCartPage";
	}
	
	
	/**
	 * 13.0	UseNow	0505
	 * to	MlfrontCart列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getMlfrontCartByPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlfrontCartByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
		int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlfrontCart> mlfrontCartList = mlfrontCartService.selectMlfrontCartGetAll();
			PageInfo page = new PageInfo(mlfrontCartList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}	
	
	
	/**
	 * 14.0	useOn	0530
	 * 加购+提交订单，全部一步生成to	BuyNow
	 * @param Msg
	 * @return 
	 * */
	@RequestMapping(value="/toBuyNow",method=RequestMethod.POST)
	@ResponseBody
	public Msg toBuyNow(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody MlfrontCartItem mlfrontCartItem) throws Exception{
		
		//String nowViewTime = DateUtil.strTime14s();
		//System.out.println("nowViewTime:"+nowViewTime);
		//记录加购数量
		insertAddCartViewBuyNow(mlfrontCartItem,session);
		
		insertAddCheckOutViewBuyNow(mlfrontCartItem,session);
		
		//放回响应域中
		session.setAttribute("mlfrontCartItem", mlfrontCartItem);
		String sessionId = session.getId();
		//获取ip地址
		String Userip =sessionId;
		session.setAttribute("Userip", Userip);
		String nowTime = DateUtil.strTime14s();
		List<MlfrontCartItem> mlfrontCartItemListBuyNow = new ArrayList<MlfrontCartItem>();
		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		//判断session中是否有登录信息 ,if 有，新增进入cart中，没有新增进入
		if(loginUser==null){
			//获取ip信息，去cart中用ip查询，是否有该ip的购物车
			MlfrontCart MlfrontCartReq = new MlfrontCart();
			MlfrontCartReq.setCartIp(Userip);
			MlfrontCartReq.setCartStatus(0);
			List<MlfrontCart> MlfrontCartResList = mlfrontCartService.selectMlfrontCartByIp(MlfrontCartReq);
			Integer ifHave = 1;
			if(MlfrontCartResList.size()>0){
				String cartitemIdstrUser = MlfrontCartResList.get(0).getCartitemIdstr();
				if(cartitemIdstrUser.length()>0){
					ifHave = 1;
				}else{
					//名下有购物车,但是为空
					Integer cartId = MlfrontCartResList.get(0).getCartId();
					MlfrontCart MlfrontCartdelRep = new MlfrontCart();
					MlfrontCartdelRep.setCartId(cartId);
					mlfrontCartService.deleteByPrimaryKey(cartId);
					ifHave = 0;
					//此时要删掉这个为空的购物车
				}
			}else{
				//如果名下没购物车
				ifHave = 0;
			}
			if(ifHave==1){
//			if(MlfrontCartResList.size()>0){
				//如果有，获取该购物车的itemStr,
				MlfrontCart mlfrontCartUser = MlfrontCartResList.get(0);
				String cartitemIdstrUser = mlfrontCartUser.getCartitemIdstr();
				Integer cartId = mlfrontCartUser.getCartId();
				Integer cartUid = mlfrontCartUser.getCartUid();
				//判断是否有本次添加的产品，如果没有itemStr中加入本次的productId,
				Integer pid = mlfrontCartItem.getCartitemProductId();
				String skuIdstr = mlfrontCartItem.getCartitemProductskuIdstr();
				String skuIdnamestr = mlfrontCartItem.getCartitemProductskuIdnamestr();
				String skuNamestr =mlfrontCartItem.getCartitemProductskuNamestr();
				int proNumberNew =mlfrontCartItem.getCartitemProductNumber();
				//String pidStr = pid+"";
				String[] aa = cartitemIdstrUser.split(",");
				int number = 0;
				for(int i=0;i<aa.length;i++){
					number++;
					String CartItemId = aa[i];
					Integer CartItemIdInt =Integer.parseInt(CartItemId);
					MlfrontCartItem mlfrontCartItemFor = new MlfrontCartItem();
					mlfrontCartItemFor.setCartitemId(CartItemIdInt);
					mlfrontCartItemFor.setCartitemProductId(pid);
					mlfrontCartItemFor.setCartitemProductskuIdstr(skuIdstr);
					mlfrontCartItemFor.setCartitemProductskuIdnamestr(skuIdnamestr);
					mlfrontCartItemFor.setCartitemProductskuNamestr(skuNamestr);
					//查看该id+该pid+skuIdstr+skuIdnamestr+skuNamestr时候已经有了
					List<MlfrontCartItem> mlfrontCartItemListFor= mlfrontCartItemService.selectMlfrontCartItemOne(mlfrontCartItemFor);
					if(mlfrontCartItemListFor.size()>0){
						//如果存在
						MlfrontCartItem mlfrontCartItemOne = mlfrontCartItemListFor.get(0);
						int ProductNumber = mlfrontCartItemOne.getCartitemProductNumber();
						//该sku的Cartitem的number+1,
						ProductNumber= ProductNumber+proNumberNew;
						mlfrontCartItemOne.setCartitemId(CartItemIdInt);
						mlfrontCartItemOne.setCartitemProductNumber(ProductNumber);
						mlfrontCartItemOne.setCartitemCreatetime(nowTime);
						mlfrontCartItemOne.setCartitemMotifytime(nowTime);
						//更新
						mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemOne);
						mlfrontCartItem.setCartitemId(CartItemIdInt);
						mlfrontCartItemListBuyNow.add(mlfrontCartItem);
						break;
					}else{
						if(number <aa.length){
							continue;
						}else{
							//没有该sku的Cartitem	新增该条Cartitem sku
							//将该id写入cart对象的cartItemStr中
							System.out.println("操作说明：当前客户添加购物车,此前购物车中不包含本次添加的产品");  
							//将本id加入原来的idstr中
							//更新一下该user的购物车中的cartitemIdstr字段
							mlfrontCartItem.setCartitemStatus(0);
							mlfrontCartItem.setCartitemCreatetime(nowTime);
							mlfrontCartItem.setCartitemMotifytime(nowTime);
							Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
							mlfrontCartItem.setCartitemProductActoff(accoff*10);
							mlfrontCartItemService.insertSelective(mlfrontCartItem);
							List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
							Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
							String cartItemIdStrnew = cartItemId+"";
							cartitemIdstrUser=cartitemIdstrUser+","+cartItemIdStrnew;
							MlfrontCart mlfrontCartAfter = new MlfrontCart();
							mlfrontCartAfter.setCartId(cartId);
							mlfrontCartAfter.setCartUid(cartUid);
							mlfrontCartAfter.setCartitemIdstr(cartitemIdstrUser);
							mlfrontCartAfter.setCartMotifytime(nowTime);
							mlfrontCartService.updateByPrimaryKeySelective(mlfrontCartAfter);
							//将本mlfrontCartItem插入mlfrontCartItem表中
							//更新本条cartitem,
							mlfrontCartItem.setCartitemId(cartItemId);
							mlfrontCartItem.setCartitemCartId(cartId);
							mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
							mlfrontCartItemListBuyNow.add(mlfrontCartItem);
							break;
						}
					}
				}
			}else{
				//这个ip没来过，直接新增一条即可mlfrontCartItem，将主键放入cart对象中，之后在新增该对象cart
				mlfrontCartItem.setCartitemCreatetime(nowTime);
				mlfrontCartItem.setCartitemMotifytime(nowTime);
				mlfrontCartItem.setCartitemStatus(0);
				mlfrontCartItemService.insertSelective(mlfrontCartItem);
				List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
				Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
				//拿回来主键ID		mlfrontCartItem
				MlfrontCart MlfrontCartItemReturn = new MlfrontCart();
				String cartItemIdStr = cartItemId+"";
				MlfrontCartItemReturn.setCartitemIdstr(cartItemIdStr);
				MlfrontCartItemReturn.setCartIp(Userip);
				MlfrontCartItemReturn.setCartStatus(0);
				MlfrontCartItemReturn.setCartCreatetime(nowTime);
				MlfrontCartItemReturn.setCartMotifytime(nowTime);
				//折扣*10
				Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
				mlfrontCartItem.setCartitemProductActoff(accoff*10);
				mlfrontCartService.insertSelective(MlfrontCartItemReturn);
				List<MlfrontCart> mlfrontCartInsertAfterList= mlfrontCartService.selectMlfrontCartGetAll();
				Integer cartAfterId = mlfrontCartInsertAfterList.get(0).getCartId();
				mlfrontCartItem.setCartitemId(cartItemId);
				mlfrontCartItem.setCartitemCartId(cartAfterId);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
				System.out.println(mlfrontCartItem);
				mlfrontCartItemListBuyNow.add(mlfrontCartItem);
			}
			//游客加购已完毕,准备生成订单
			BuyNowAndcartToOrder(rep,res,session, mlfrontCartItemListBuyNow);
		}else{
			//获取uid信息，去cart中用uid查询，是否有该uid的购物车
			MlfrontCart MlfrontCartReq = new MlfrontCart();
			Integer uid =loginUser.getUserId();
			MlfrontCartReq.setCartUid(uid);
			MlfrontCartReq.setCartStatus(0);
			List<MlfrontCart> MlfrontCartResList = mlfrontCartService.selectMlfrontCartByUidAndStatus(MlfrontCartReq);
			Integer ifHave = 1;
			if(MlfrontCartResList.size()>0){
				String cartitemIdstrUser = MlfrontCartResList.get(0).getCartitemIdstr();
				if(cartitemIdstrUser.length()>0){
					ifHave = 1;
				}else{
					//名下有购物车,但是为空
					Integer cartId = MlfrontCartResList.get(0).getCartId();
					MlfrontCart MlfrontCartdelRep = new MlfrontCart();
					MlfrontCartdelRep.setCartId(cartId);
					mlfrontCartService.deleteByPrimaryKey(cartId);
					ifHave = 0;
					//此时要删掉这个为空的购物车
				}
			}else{
				//如果名下没购物车
				ifHave = 0;
			}
			if(ifHave==1){
//			if(MlfrontCartResList.size()>0){
				//如果有，获取该购物车的itemStr,
				MlfrontCart mlfrontCartUser = MlfrontCartResList.get(0);
				String cartitemIdstrUser = mlfrontCartUser.getCartitemIdstr();
				Integer cartId = mlfrontCartUser.getCartId();
				Integer cartUid = mlfrontCartUser.getCartUid();
				//判断是否有本次添加的产品，如果没有itemStr中加入本次的productId,
				Integer pid = mlfrontCartItem.getCartitemProductId();
				String skuIdstr = mlfrontCartItem.getCartitemProductskuIdstr();
				String skuIdnamestr = mlfrontCartItem.getCartitemProductskuIdnamestr();
				String skuNamestr =mlfrontCartItem.getCartitemProductskuNamestr();
				int proNumberNew =mlfrontCartItem.getCartitemProductNumber();
				//String pidStr = pid+"";
				String[] aa = cartitemIdstrUser.split(",");
				int number = 0;
				for(int i=0;i<aa.length;i++){
					number++;
					String CartItemId = aa[i];
					Integer CartItemIdInt =Integer.parseInt(CartItemId);
					MlfrontCartItem mlfrontCartItemFor = new MlfrontCartItem();
					mlfrontCartItemFor.setCartitemId(CartItemIdInt);
					mlfrontCartItemFor.setCartitemProductId(pid);
					mlfrontCartItemFor.setCartitemProductskuIdstr(skuIdstr);
					mlfrontCartItemFor.setCartitemProductskuIdnamestr(skuIdnamestr);
					mlfrontCartItemFor.setCartitemProductskuNamestr(skuNamestr);
					//查看该id+该pid+skuIdstr+skuIdnamestr+skuNamestr时候已经有了
					List<MlfrontCartItem> mlfrontCartItemListFor= mlfrontCartItemService.selectMlfrontCartItemOne(mlfrontCartItemFor);
					if(mlfrontCartItemListFor.size()>0){
						//如果存在
						MlfrontCartItem mlfrontCartItemOne = mlfrontCartItemListFor.get(0);
						int ProductNumber = mlfrontCartItemOne.getCartitemProductNumber();
						//该sku的Cartitem的number+1,
						ProductNumber= ProductNumber+proNumberNew;
						mlfrontCartItemOne.setCartitemId(CartItemIdInt);
						mlfrontCartItemOne.setCartitemProductNumber(ProductNumber);
						mlfrontCartItemOne.setCartitemCreatetime(nowTime);
						mlfrontCartItemOne.setCartitemMotifytime(nowTime);
						//更新
						mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemOne);
						mlfrontCartItem.setCartitemId(CartItemIdInt);
						mlfrontCartItemListBuyNow.add(mlfrontCartItem);
						break;
					}else{
						if(number <aa.length){
							continue;
						}else{
							//没有该sku的Cartitem
							//新增该条Cartitem sku
							//将该id写入cart对象的cartItemStr中
							System.out.println("操作说明：当前客户添加购物车,此前购物车中不包含本次添加的产品"); 
							//将本id加入原来的idstr中
							//更新一下该user的购物车中的cartitemIdstr字段
							mlfrontCartItem.setCartitemStatus(0);
							mlfrontCartItem.setCartitemCreatetime(nowTime);
							mlfrontCartItem.setCartitemMotifytime(nowTime);
							//折扣*10
							Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
							mlfrontCartItem.setCartitemProductActoff(accoff*10);
							mlfrontCartItemService.insertSelective(mlfrontCartItem);
							List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
							Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
							String cartItemIdStrnew = cartItemId+"";
							cartitemIdstrUser=cartitemIdstrUser+","+cartItemIdStrnew;
							MlfrontCart mlfrontCartAfter = new MlfrontCart();
							mlfrontCartAfter.setCartId(cartId);
							mlfrontCartAfter.setCartUid(cartUid);
							mlfrontCartAfter.setCartitemIdstr(cartitemIdstrUser);
							mlfrontCartAfter.setCartMotifytime(nowTime);
							mlfrontCartService.updateByPrimaryKeySelective(mlfrontCartAfter);
							//将本mlfrontCartItem插入mlfrontCartItem表中
							//更新本条cartitem,
							mlfrontCartItem.setCartitemId(cartItemId);
							mlfrontCartItem.setCartitemCartId(cartId);
							mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
							mlfrontCartItemListBuyNow.add(mlfrontCartItem);
							break;
						}
					}
				}
			}else{
				//这个ip没来过，直接新增一条即可mlfrontCartItem，将主键放入cart对象中，之后在新增该对象cart
				mlfrontCartItem.setCartitemCreatetime(nowTime);
				mlfrontCartItem.setCartitemMotifytime(nowTime);
				mlfrontCartItem.setCartitemStatus(0);
				//折扣*10
				Integer accoff =  mlfrontCartItem.getCartitemProductActoff();
				mlfrontCartItem.setCartitemProductActoff(accoff*10);
				mlfrontCartItemService.insertSelective(mlfrontCartItem);
				List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemService.selectMlfrontCartItemGetAll();
				Integer cartItemId = mlfrontCartItemList.get(0).getCartitemId();
				//拿回来主键ID		mlfrontCartItem
				MlfrontCart MlfrontCartItemReturn = new MlfrontCart();
				String cartItemIdStr = cartItemId+"";
				MlfrontCartItemReturn.setCartitemIdstr(cartItemIdStr);
				MlfrontCartItemReturn.setCartUid(uid);
				MlfrontCartItemReturn.setCartStatus(0);
				MlfrontCartItemReturn.setCartCreatetime(nowTime);
				MlfrontCartItemReturn.setCartMotifytime(nowTime);
				mlfrontCartService.insertSelective(MlfrontCartItemReturn);
				List<MlfrontCart> mlfrontCartInsertAfterList= mlfrontCartService.selectMlfrontCartGetAll();
				Integer cartAfterId = mlfrontCartInsertAfterList.get(0).getCartId();
				mlfrontCartItem.setCartitemId(cartItemId);
				mlfrontCartItem.setCartitemCartId(cartAfterId);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItem);
				mlfrontCartItemListBuyNow.add(mlfrontCartItem);
			}
			//loginUser加购已完毕,准备生成订单	
			BuyNowAndcartToOrder(rep,res,session, mlfrontCartItemListBuyNow);
		}
		return Msg.success().add("resMsg", "添加成功");
	}
	

	
	/**
	 * 方法
	 * 勿碰
	 * 购买中的任务
	 * */
	public void BuyNowAndcartToOrder(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody List<MlfrontCartItem> mlfrontCartItemList) throws Exception{
		//接收传递进来的参数
		System.out.println(mlfrontCartItemList);
		//从其中一个中获取cartId
		Integer cartId = 0;
		String sessionId = session.getId();
		Integer orderIdFinally = 0;
		//获取ip地址
		String Userip =sessionId;
		session.setAttribute("Userip", Userip);
		String nowTime = DateUtil.strTime14s();
		List<String> cartItemIdStr = new ArrayList<String>();
		List<String> orderItemIdList = new ArrayList<String>();
		String orderItemIdStr = "";
		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		MlfrontCartItem mlfrontCartItemGet = new MlfrontCartItem();
		if(loginUser==null){
			//loginUser为null
			MlfrontOrderItem mlfrontOrderItemNew = new MlfrontOrderItem();
			for(MlfrontCartItem mlfrontCartItem:mlfrontCartItemList){
				System.out.println(mlfrontCartItem);
				//取出本条cartItem
				Integer cartitemIdInt = mlfrontCartItem.getCartitemId();
				//cartId = mlfrontCartItem.getCartitemCartId();
				mlfrontCartItemGet.setCartitemId(cartitemIdInt);
				List<MlfrontCartItem> mlfrontCartItemGetRes =mlfrontCartItemService.selectMlfrontCartItemById(mlfrontCartItemGet);
				//将该购物项，改成已用
				mlfrontCartItemGet.setCartitemStatus(1);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemGet);
				MlfrontCartItem mlfrontCartItemreturn = mlfrontCartItemGetRes.get(0);
				cartId = mlfrontCartItemreturn.getCartitemCartId();
				String cartitemIdIntStrOne = cartitemIdInt+"";
				cartItemIdStr.add(cartitemIdIntStrOne);
				//封装mlfrontOrderItem对象，准备insert进入mlfrontOrderItem表
				mlfrontOrderItemNew.setOrderCartItemId(cartitemIdInt);
				mlfrontOrderItemNew.setOrderitemPid(mlfrontCartItem.getCartitemProductId());
				mlfrontOrderItemNew.setOrderitemPname(mlfrontCartItemreturn.getCartitemProductName());
				mlfrontOrderItemNew.setOrderitemProductMainimgurl(mlfrontCartItemreturn.getCartitemProductMainimgurl());
				mlfrontOrderItemNew.setOrderitemProductOriginalprice(mlfrontCartItemreturn.getCartitemProductOriginalprice());
				mlfrontOrderItemNew.setOrderitemProductAccoff(mlfrontCartItemreturn.getCartitemProductActoff());
				mlfrontOrderItemNew.setOrderitemPskuIdstr(mlfrontCartItemreturn.getCartitemProductskuIdstr());
				mlfrontOrderItemNew.setOrderitemPskuIdnamestr(mlfrontCartItemreturn.getCartitemProductskuIdnamestr());
				mlfrontOrderItemNew.setOrderitemPskuNamestr(mlfrontCartItemreturn.getCartitemProductskuNamestr());
				mlfrontOrderItemNew.setOrderitemPskuMoneystr(mlfrontCartItemreturn.getCartitemProductskuMoneystr());
				//mlfrontOrderItemNew.setOrderitemPskuReamoney("这个值是需要计算的");
				mlfrontOrderItemNew.setOrderitemPskuNumber(mlfrontCartItem.getCartitemProductNumber());
				mlfrontOrderItemNew.setOrderitemCreatetime(nowTime);
				mlfrontOrderItemNew.setOrderitemMotifytime(nowTime);
				mlfrontOrderItemService.insertSelective(mlfrontOrderItemNew);
				//获取新生成的id
				MlfrontOrderItem MlfrontOrderItemReallOne =mlfrontOrderItemService.selectMlfrontOrderItemAll().get(0);
				Integer orderItemNewId = MlfrontOrderItemReallOne.getOrderitemId();
				String orderItemNewIdStr = orderItemNewId+"";
				//存档便于以后用
				orderItemIdList.add(orderItemNewIdStr);
				orderItemIdStr=orderItemIdStr+","+orderItemNewIdStr;
			}
			//插入订单对象
			orderItemIdStr = orderItemIdStr.substring(1);
			MlfrontOrder mlfrontOrderNew  = new MlfrontOrder();
			mlfrontOrderNew.setOrderOrderitemidstr(orderItemIdStr);
			mlfrontOrderNew.setOrderIp(Userip);
			
			mlfrontOrderNew.setOrderStatus(0);//cart To Order
			mlfrontOrderNew.setOrderCreatetime(nowTime);
			mlfrontOrderNew.setOrderMotifytime(nowTime);
			
			//直接进入的时候，没有order表中没有数量字段
			MlfrontCartItem mlfrontCartItemBuyNow = mlfrontCartItemList.get(0);
			Integer ProductNumber = mlfrontCartItemBuyNow.getCartitemProductNumber();
			String ProductNumberStr = ProductNumber+"";
			mlfrontOrderNew.setOrderProNumStr(ProductNumberStr);
			
			mlfrontOrderService.insertSelective(mlfrontOrderNew);
			//获取新生成的id
			MlfrontOrder mlfrontOrdergetAllOne = mlfrontOrderService.selectMlfrontOrderAll().get(0);
			//后更新每个orderItem对象
			Integer orderId = mlfrontOrdergetAllOne.getOrderId();
			orderIdFinally = orderId;
			MlfrontOrderItem mlfrontOrderItemOldone = new MlfrontOrderItem();
			for(String orderItemIdOld:orderItemIdList){
				Integer orderItemIdOldInt =  Integer.parseInt(orderItemIdOld);
				mlfrontOrderItemOldone.setOrderitemId(orderItemIdOldInt);
				mlfrontOrderItemOldone.setOrderId(orderId);
				mlfrontOrderItemService.updateByPrimaryKeySelective(mlfrontOrderItemOldone);
			}
		}else{
			//loginUser不为null
			Integer Uid = loginUser.getUserId();
			MlfrontOrderItem mlfrontOrderItemNew = new MlfrontOrderItem();
			for(MlfrontCartItem mlfrontCartItem:mlfrontCartItemList){
				System.out.println(mlfrontCartItem);
				//取出本条cartItem
				Integer cartitemIdInt = mlfrontCartItem.getCartitemId();
				//cartId = mlfrontCartItem.getCartitemCartId();
				mlfrontCartItemGet.setCartitemId(cartitemIdInt);
				List<MlfrontCartItem> mlfrontCartItemGetRes =mlfrontCartItemService.selectMlfrontCartItemById(mlfrontCartItemGet);
				//将该购物项，改成已用
				mlfrontCartItemGet.setCartitemStatus(1);
				mlfrontCartItemService.updateByPrimaryKeySelective(mlfrontCartItemGet);
				MlfrontCartItem mlfrontCartItemreturn = mlfrontCartItemGetRes.get(0);
				cartId = mlfrontCartItemreturn.getCartitemCartId();
				String cartitemIdIntStrOne = cartitemIdInt+"";
				cartItemIdStr.add(cartitemIdIntStrOne);
				//封装mlfrontOrderItem对象，准备insert进入mlfrontOrderItem表
				mlfrontOrderItemNew.setOrderCartItemId(cartitemIdInt);
				mlfrontOrderItemNew.setOrderitemPid(mlfrontCartItem.getCartitemProductId());
				mlfrontOrderItemNew.setOrderitemPname(mlfrontCartItemreturn.getCartitemProductName());
				mlfrontOrderItemNew.setOrderitemProductMainimgurl(mlfrontCartItemreturn.getCartitemProductMainimgurl());
				mlfrontOrderItemNew.setOrderitemProductOriginalprice(mlfrontCartItemreturn.getCartitemProductOriginalprice());
				mlfrontOrderItemNew.setOrderitemProductAccoff(mlfrontCartItemreturn.getCartitemProductActoff());
				mlfrontOrderItemNew.setOrderitemPskuIdstr(mlfrontCartItemreturn.getCartitemProductskuIdstr());
				mlfrontOrderItemNew.setOrderitemPskuIdnamestr(mlfrontCartItemreturn.getCartitemProductskuIdnamestr());
				mlfrontOrderItemNew.setOrderitemPskuNamestr(mlfrontCartItemreturn.getCartitemProductskuNamestr());
				mlfrontOrderItemNew.setOrderitemPskuMoneystr(mlfrontCartItemreturn.getCartitemProductskuMoneystr());
				//mlfrontOrderItemNew.setOrderitemPskuReamoney("这个值是需要计算的");
				mlfrontOrderItemNew.setOrderitemPskuNumber(mlfrontCartItem.getCartitemProductNumber());
				mlfrontOrderItemNew.setOrderitemCreatetime(nowTime);
				mlfrontOrderItemNew.setOrderitemMotifytime(nowTime);
				mlfrontOrderItemService.insertSelective(mlfrontOrderItemNew);
				//获取新生成的id
				MlfrontOrderItem MlfrontOrderItemReallOne =mlfrontOrderItemService.selectMlfrontOrderItemAll().get(0);
				Integer orderItemNewId = MlfrontOrderItemReallOne.getOrderitemId();
				String orderItemNewIdStr = orderItemNewId+"";
				//存档便于以后用
				orderItemIdList.add(orderItemNewIdStr);
				orderItemIdStr=orderItemIdStr+","+orderItemNewIdStr;
			}
			//插入订单对象
			orderItemIdStr = orderItemIdStr.substring(1);
			MlfrontOrder mlfrontOrderNew  = new MlfrontOrder();
			mlfrontOrderNew.setOrderOrderitemidstr(orderItemIdStr);
			//mlfrontOrderNew.setOrderIp(Userip);
			mlfrontOrderNew.setOrderUid(Uid);//这是登录用户，存错登录状态
			mlfrontOrderNew.setOrderStatus(0);//cart To Order
			mlfrontOrderNew.setOrderCreatetime(nowTime);
			mlfrontOrderNew.setOrderMotifytime(nowTime);
			
			//直接进入的时候，没有order表中没有数量字段
			MlfrontCartItem mlfrontCartItemBuyNow = mlfrontCartItemList.get(0);
			Integer ProductNumber = mlfrontCartItemBuyNow.getCartitemProductNumber();
			String ProductNumberStr = ProductNumber+"";
			mlfrontOrderNew.setOrderProNumStr(ProductNumberStr);
			
			mlfrontOrderService.insertSelective(mlfrontOrderNew);
			//获取新生成的id
			MlfrontOrder mlfrontOrdergetAllOne = mlfrontOrderService.selectMlfrontOrderAll().get(0);
			//后更新每个orderItem对象
			Integer orderId = mlfrontOrdergetAllOne.getOrderId();
			orderIdFinally = orderId;
			MlfrontOrderItem mlfrontOrderItemOldone = new MlfrontOrderItem();
			for(String orderItemIdOld:orderItemIdList){
				Integer orderItemIdOldInt =  Integer.parseInt(orderItemIdOld);
				mlfrontOrderItemOldone.setOrderitemId(orderItemIdOldInt);
				mlfrontOrderItemOldone.setOrderId(orderId);
				mlfrontOrderItemService.updateByPrimaryKeySelective(mlfrontOrderItemOldone);
			}
		}
		session.setAttribute("orderId", orderIdFinally);
		//返回视图
	}
	

	/**
	 * 计算从detail--buyNow的结算数
	 * 
	 * */
	private void insertAddCheckOutViewBuyNow(MlfrontCartItem mlfrontCartItem, HttpSession session) {

		Integer productId = mlfrontCartItem.getCartitemProductId();
		
		MlbackProduct mlbackProductrep = new MlbackProduct();
		mlbackProductrep.setProductId(productId);
		
		List<MlbackProduct> mlbackProductresList = mlbackProductService.selectMlbackProduct(mlbackProductrep);
		MlbackProduct mlbackProductres = mlbackProductresList.get(0);
		
		String addcartviewdetailSeoname = mlbackProductres.getProductSeo();
		String addcartviewdetailProname = mlbackProductres.getProductName();
		
		//准备参数信息
		MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
		//浏览对象
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailSeoname(addcartviewdetailSeoname);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailProname(addcartviewdetailProname);
		//sessionID
		String sessionId =  session.getId();
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailSessionid(sessionId);
		//时间信息
		String nowTime = DateUtil.strTime14s();
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailCreatetime(nowTime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailMotifytime(nowTime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailActnum(1); //计数用户行为，0纯加购	，1点buyNow附带的加购
		mlbackAddCheakoutViewDetailService.insertSelective(mlbackAddCheakoutViewDetailreq);
	}

	/**
	 * 计算从detail--buyNow的加购数
	 * 
	 * */
	private void insertAddCartViewBuyNow(MlfrontCartItem mlfrontCartItem, HttpSession session) {
		Integer productId = mlfrontCartItem.getCartitemProductId();
		
		MlbackProduct mlbackProductrep = new MlbackProduct();
		mlbackProductrep.setProductId(productId);
		
		List<MlbackProduct> mlbackProductresList = mlbackProductService.selectMlbackProduct(mlbackProductrep);
		MlbackProduct mlbackProductres = mlbackProductresList.get(0);
		
		String addcartviewdetailSeoname = mlbackProductres.getProductSeo();
		String addcartviewdetailProname = mlbackProductres.getProductName();
		
		//准备参数信息
		MlbackAddCartViewDetail mlbackAddCartViewDetailreq = new MlbackAddCartViewDetail();
		//浏览对象
		mlbackAddCartViewDetailreq.setAddcartviewdetailSeoname(addcartviewdetailSeoname);
		mlbackAddCartViewDetailreq.setAddcartviewdetailProname(addcartviewdetailProname);
		//sessionID
		String sessionId =  session.getId();
		mlbackAddCartViewDetailreq.setAddcartviewdetailSessionid(sessionId);
		//时间信息
		String nowTime = DateUtil.strTime14s();
		mlbackAddCartViewDetailreq.setAddcartviewdetailCreatetime(nowTime);
		mlbackAddCartViewDetailreq.setAddcartviewdetailMotifytime(nowTime);
		mlbackAddCartViewDetailreq.setAddcartviewdetailActNum(1); //计数用户行为，0纯加购	，1点buyNow附带的加购
		mlbackProductViewDetailService.insertSelective(mlbackAddCartViewDetailreq);
		
	}
	
	
	/**
	 * 计算从CartList--Cheakout的结算数
	 * 
	 * */
	private void calcFormCartListToCheakoutPage(List<MlfrontCartItem> mlfrontCartItemList, HttpSession session) {
		
		for(MlfrontCartItem mlfrontCartItem:mlfrontCartItemList){
			
			Integer productId = mlfrontCartItem.getCartitemProductId();
			
			MlbackProduct mlbackProductrep = new MlbackProduct();
			mlbackProductrep.setProductId(productId);
			List<MlbackProduct> mlbackProductresList = mlbackProductService.selectMlbackProduct(mlbackProductrep);
			MlbackProduct mlbackProductres = mlbackProductresList.get(0);
			
			String addcartviewdetailSeoname = mlbackProductres.getProductSeo();
			String addcartviewdetailProname = mlbackProductres.getProductName();
			
			//准备参数信息
			MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
			//浏览对象
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailSeoname(addcartviewdetailSeoname);
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailProname(addcartviewdetailProname);
			//sessionID
			String sessionId =  session.getId();
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailSessionid(sessionId);
			//时间信息
			String nowTime = DateUtil.strTime14s();
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailCreatetime(nowTime);
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailMotifytime(nowTime);
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailActnum(0); //计数用户行为，0(从CartList--Cheakout)的结算数	，1(从buyNow--Cheakout)的结算数
			mlbackAddCheakoutViewDetailService.insertSelective(mlbackAddCheakoutViewDetailreq);
		}
	}
}
