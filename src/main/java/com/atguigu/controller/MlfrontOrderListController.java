package com.atguigu.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackAreafreightService;
import com.atguigu.service.MlbackCouponService;
import com.atguigu.service.MlbackShipEmailService;
import com.atguigu.service.MlfrontAddressService;
import com.atguigu.service.MlfrontCartItemService;
import com.atguigu.service.MlfrontCartService;
import com.atguigu.service.MlfrontOrderItemService;
import com.atguigu.service.MlfrontOrderService;
import com.atguigu.service.MlfrontPayInfoService;

@Controller
@RequestMapping("/MlfrontOrderList")
public class MlfrontOrderListController {
		
	@Autowired
	MlfrontOrderService mlfrontOrderService;
	
	@Autowired
	MlfrontAddressService mlfrontAddressService;
	
	@Autowired
	MlbackAreafreightService mlbackAreafreightService;
	
	@Autowired
	MlfrontOrderItemService mlfrontOrderItemService;
	
	@Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
	
	@Autowired
	MlfrontCartItemService mlfrontCartItemService;
	
	@Autowired
	MlfrontCartService mlfrontCartService;
	
	@Autowired
	MlbackCouponService mlbackCouponService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	@Autowired
	MlbackShipEmailService mlbackShipEmailService;
	
	/**
	 * 1.0	UseNow	1219
	 * to	全部订单
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getOrderlistAllByUidPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOrderlistAllByUidPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		int PagNum = 10;//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderByUidOnly(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
	
	/**
	 * 2.0	UseNow	1219
	 * to	全部订单-未支付
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getOrderlistUnpayByUidPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOrderlistUnpayByUidPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		mlfrontOrder.setOrderStatus(0);//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		int PagNum = 10;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderByUidAndStatus(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
	
	/**
	 * 3.0	UseNow	1219
	 * to	全部订单-已支付
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getOrderlistPayByUidPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOrderlistPayByUidPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		mlfrontOrder.setOrderStatus(1);//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		int PagNum = 10;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderByUidAndStatus(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
	
	/**
	 * 4.0	UseNow	1219
	 * to	全部订单-已审核
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getOrderlistverifyByUidPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOrderlistverifyByUidPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		mlfrontOrder.setOrderStatus(3);//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		int PagNum = 10;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderByUidAndStatus(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
	/**
	 * 5.0	UseNow	1219
	 * to	全部订单-已发货
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getOrderlistShipByUidPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOrderlistShipByUidPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		mlfrontOrder.setOrderStatus(4);//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		int PagNum = 10;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderByUidAndStatus(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
	
	/**
	 * 6.0	UseNow	1219
	 * to	全部订单-已退款
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getOrderlistRefundByUidPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOrderlistRefundByUidPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		mlfrontOrder.setOrderStatus(5);//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		int PagNum = 10;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectMlfrontOrderByUidAndStatus(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
	
	
	/**
	 * 7.0	UseNow	1219
	 * to	全部订单-分状态查询
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/selectOrderlistBySearch",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectOrderlistBySearch(@RequestParam(value = "pn", defaultValue = "1") Integer pn,@RequestParam(value = "orderStatus") Integer orderStatus,HttpSession session) {

		MlfrontUser loginUser = (MlfrontUser) session.getAttribute("loginUser");
		Integer Uid = loginUser.getUserId();
		MlfrontOrder mlfrontOrder = new MlfrontOrder();
		mlfrontOrder.setOrderUid(Uid);
		if(orderStatus==999){
			System.out.println("orderStatus==999,不筛选状态");
		}else{
			mlfrontOrder.setOrderStatus(orderStatus);//0未支付//1支付成功//2支付失败//3审单完毕 //4发货完毕//5已退款
		}
		int PagNum = 5;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontOrder> mlfrontOrderList = mlfrontOrderService.selectOrderListByUidAndStatus(mlfrontOrder);
		PageInfo page = new PageInfo(mlfrontOrderList, PagNum);
		mlfrontOrderList = page.getList();
		//2遍历mlfrontOrderList，3读取每个的orderItemIdStr,4切割，5再遍历产寻单条的获取orderItemId对象
		String orderitemidstr="";
		MlfrontOrderItem mlfrontOrderItemReq = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemRes = new MlfrontOrderItem();
		List<MlfrontOrderItem> mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		List<MlfrontOrderItem> mlfrontOrderItemReturnList = new ArrayList<MlfrontOrderItem>();
		List<Integer> sizeList = new ArrayList<Integer>();
		for(MlfrontOrder mlfrontOrderOne:mlfrontOrderList){
			orderitemidstr = mlfrontOrderOne.getOrderOrderitemidstr();
			String orderitemidArr[] = orderitemidstr.split(",");
			Integer size = orderitemidArr.length;
			sizeList.add(size);
			for(int i=0;i<orderitemidArr.length;i++){
				String orderitemid = orderitemidArr[i];
				Integer orderitemidInt = Integer.valueOf(orderitemid);
				mlfrontOrderItemReq.setOrderitemId(orderitemidInt); 
				mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemReq);
				mlfrontOrderItemRes = mlfrontOrderItemList.get(0);
				mlfrontOrderItemReturnList.add(mlfrontOrderItemRes);
			}
		}
		return Msg.success().add("pageInfo", page).add("sizeList", sizeList).add("mlfrontOrderItemReturnList", mlfrontOrderItemReturnList);
	}
}
