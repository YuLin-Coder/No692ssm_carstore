package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Outstorage;
import com.service.OutstorageService;
import com.entity.Orders;
import com.entity.Goods;
import com.entity.Admin;
import com.service.OrdersService;
import com.service.GoodsService;
import com.service.AdminService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/outstorage", produces = "text/plain;charset=utf-8")
public class OutstorageController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private OutstorageService outstorageService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AdminService adminService;

	// 准备添加数据
	@RequestMapping("createOutstorage.action")
	public String createOutstorage() {
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "admin/addoutstorage";
	}

	// 添加数据
	@RequestMapping("addOutstorage.action")
	public String addOutstorage(Outstorage outstorage) {
		outstorage.setAddtime(VeDate.getStringDateShort());
		this.outstorageService.insertOutstorage(outstorage);
		return "redirect:/outstorage/createOutstorage.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteOutstorage.action")
	public String deleteOutstorage(String id) {
		this.outstorageService.deleteOutstorage(id);
		return "redirect:/outstorage/getAllOutstorage.action";
	}

	// 批量删除数据
	@RequestMapping("deleteOutstorageByIds.action")
	public String deleteOutstorageByIds() {
		String[] ids = this.getRequest().getParameterValues("outstorageid");
		for (String outstorageid : ids) {
			this.outstorageService.deleteOutstorage(outstorageid);
		}
		return "redirect:/outstorage/getAllOutstorage.action";
	}

	// 更新数据
	@RequestMapping("updateOutstorage.action")
	public String updateOutstorage(Outstorage outstorage) {
		this.outstorageService.updateOutstorage(outstorage);
		return "redirect:/outstorage/getAllOutstorage.action";
	}

	// 显示全部数据
	@RequestMapping("getAllOutstorage.action")
	public String getAllOutstorage(String number) {
		List<Outstorage> outstorageList = this.outstorageService.getAllOutstorage();
		PageHelper.getPage(outstorageList, "outstorage", null, null, 10, number, this.getRequest(), null);
		return "admin/listoutstorage";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryOutstorageByCond.action")
	public String queryOutstorageByCond(String cond, String name, String number) {
		Outstorage outstorage = new Outstorage();
		if (cond != null) {
			if ("ordersid".equals(cond)) {
				outstorage.setOrdersid(name);
			}
			if ("goodsid".equals(cond)) {
				outstorage.setGoodsid(name);
			}
			if ("num".equals(cond)) {
				outstorage.setNum(name);
			}
			if ("adminid".equals(cond)) {
				outstorage.setAdminid(name);
			}
			if ("addtime".equals(cond)) {
				outstorage.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.outstorageService.getOutstorageByLike(outstorage), "outstorage", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/queryoutstorage";
	}

	// 按主键查询数据
	@RequestMapping("getOutstorageById.action")
	public String getOutstorageById(String id) {
		Outstorage outstorage = this.outstorageService.getOutstorageById(id);
		this.getRequest().setAttribute("outstorage", outstorage);
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "admin/editoutstorage";
	}

	public OutstorageService getOutstorageService() {
		return outstorageService;
	}

	public void setOutstorageService(OutstorageService outstorageService) {
		this.outstorageService = outstorageService;
	}

}

