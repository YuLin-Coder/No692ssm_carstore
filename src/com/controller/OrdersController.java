package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Details;
import com.entity.Orders;
import com.entity.Outstorage;
import com.entity.Users;
import com.service.DetailsService;
import com.service.OrdersService;
import com.service.OutstorageService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/orders", produces = "text/plain;charset=utf-8")
public class OrdersController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private OutstorageService outstorageService;

	// 准备添加数据
	@RequestMapping("createOrders.action")
	public String createOrders() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addorders";
	}

	// 添加数据
	@RequestMapping("addOrders.action")
	public String addOrders(Orders orders) {
		orders.setAddtime(VeDate.getStringDateShort());
		this.ordersService.insertOrders(orders);
		return "redirect:/orders/createOrders.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteOrders.action")
	public String deleteOrders(String id) {
		this.ordersService.deleteOrders(id);
		return "redirect:/orders/getAllOrders.action";
	}

	// 批量删除数据
	@RequestMapping("deleteOrdersByIds.action")
	public String deleteOrdersByIds() {
		String[] ids = this.getRequest().getParameterValues("ordersid");
		for (String ordersid : ids) {
			this.ordersService.deleteOrders(ordersid);
		}
		return "redirect:/orders/getAllOrders.action";
	}

	// 更新数据
	@RequestMapping("updateOrders.action")
	public String updateOrders(Orders orders) {
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getAllOrders.action";
	}

	// 发货
	@RequestMapping("send.action")
	public String send(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus("已发货");
		this.ordersService.updateOrders(orders);
		Details details = new Details();
		details.setOrdercode(orders.getOrdercode());
		List<Details> detailsList = this.detailsService.getDetailsByCond(details);
		for (int i = 0; i < detailsList.size(); i++) {
			Details u = detailsList.get(i);
			Outstorage outs = new Outstorage();
			outs.setOrdersid(id);
			outs.setGoodsid(u.getGoodsid());
			outs.setNum(u.getNum());
			outs.setAddtime(VeDate.getStringDateShort());
			outs.setAdminid((String) this.getSession().getAttribute("adminid"));
			this.outstorageService.insertOutstorage(outs);
		}
		return "redirect:/orders/getAllOrders.action";
	}

	// 显示全部数据
	@RequestMapping("getAllOrders.action")
	public String getAllOrders(String number) {
		List<Orders> ordersList = this.ordersService.getAllOrders();
		PageHelper.getPage(ordersList, "orders", null, null, 10, number, this.getRequest(), null);
		return "admin/listorders";
	}
	
	//显示订单详情
	@RequestMapping("details.action")
	public String details(String id) {
		Details det = new Details();
		det.setOrdercode(this.ordersService.getOrdersById(id).getOrdercode());
		List<Details> detailsList = this.detailsService.getDetailsByCond(det);
		this.getRequest().setAttribute("detailsList", detailsList);
		return "admin/listdetails";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryOrdersByCond.action")
	public String queryOrdersByCond(String cond, String name, String number) {
		Orders orders = new Orders();
		if (cond != null) {
			if ("ordercode".equals(cond)) {
				orders.setOrdercode(name);
			}
			if ("usersid".equals(cond)) {
				orders.setUsersid(name);
			}
			if ("total".equals(cond)) {
				orders.setTotal(name);
			}
			if ("status".equals(cond)) {
				orders.setStatus(name);
			}
			if ("addtime".equals(cond)) {
				orders.setAddtime(name);
			}
			if ("receiver".equals(cond)) {
				orders.setReceiver(name);
			}
			if ("address".equals(cond)) {
				orders.setAddress(name);
			}
			if ("contact".equals(cond)) {
				orders.setContact(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ordersService.getOrdersByLike(orders), "orders", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryorders";
	}

	// 按主键查询数据
	@RequestMapping("getOrdersById.action")
	public String getOrdersById(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editorders";
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

}

