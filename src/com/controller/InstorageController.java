package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Instorage;
import com.service.InstorageService;
import com.entity.Goods;
import com.entity.Admin;
import com.service.GoodsService;
import com.service.AdminService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/instorage", produces = "text/plain;charset=utf-8")
public class InstorageController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private InstorageService instorageService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AdminService adminService;

	// 准备添加数据
	@RequestMapping("createInstorage.action")
	public String createInstorage() {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "admin/addinstorage";
	}

	// 添加数据
	@RequestMapping("addInstorage.action")
	public String addInstorage(Instorage instorage) {
		instorage.setAddtime(VeDate.getStringDateShort());
		this.instorageService.insertInstorage(instorage);
		Goods goods = this.goodsService.getGoodsById(instorage.getGoodsid());
		int n = Integer.parseInt(goods.getStorage()) + Integer.parseInt(instorage.getNum());
		goods.setStorage("" + n);
		this.goodsService.updateGoods(goods);
		return "redirect:/instorage/createInstorage.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteInstorage.action")
	public String deleteInstorage(String id) {
		this.instorageService.deleteInstorage(id);
		return "redirect:/instorage/getAllInstorage.action";
	}

	// 批量删除数据
	@RequestMapping("deleteInstorageByIds.action")
	public String deleteInstorageByIds() {
		String[] ids = this.getRequest().getParameterValues("instorageid");
		for (String instorageid : ids) {
			this.instorageService.deleteInstorage(instorageid);
		}
		return "redirect:/instorage/getAllInstorage.action";
	}

	// 更新数据
	@RequestMapping("updateInstorage.action")
	public String updateInstorage(Instorage instorage) {
		this.instorageService.updateInstorage(instorage);
		return "redirect:/instorage/getAllInstorage.action";
	}

	// 显示全部数据
	@RequestMapping("getAllInstorage.action")
	public String getAllInstorage(String number) {
		List<Instorage> instorageList = this.instorageService.getAllInstorage();
		PageHelper.getPage(instorageList, "instorage", null, null, 10, number, this.getRequest(), null);
		return "admin/listinstorage";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryInstorageByCond.action")
	public String queryInstorageByCond(String cond, String name, String number) {
		Instorage instorage = new Instorage();
		if (cond != null) {
			if ("goodsid".equals(cond)) {
				instorage.setGoodsid(name);
			}
			if ("num".equals(cond)) {
				instorage.setNum(name);
			}
			if ("adminid".equals(cond)) {
				instorage.setAdminid(name);
			}
			if ("addtime".equals(cond)) {
				instorage.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.instorageService.getInstorageByLike(instorage), "instorage", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/queryinstorage";
	}

	// 按主键查询数据
	@RequestMapping("getInstorageById.action")
	public String getInstorageById(String id) {
		Instorage instorage = this.instorageService.getInstorageById(id);
		this.getRequest().setAttribute("instorage", instorage);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "admin/editinstorage";
	}

	public InstorageService getInstorageService() {
		return instorageService;
	}

	public void setInstorageService(InstorageService instorageService) {
		this.instorageService = instorageService;
	}

}

