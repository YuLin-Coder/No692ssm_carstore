package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Goods;
import com.service.GoodsService;
import com.entity.Cate;
import com.entity.Supplier;
import com.entity.Racks;
import com.service.CateService;
import com.service.SupplierService;
import com.service.RacksService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/goods", produces = "text/plain;charset=utf-8")
public class GoodsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CateService cateService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private RacksService racksService;

	// 准备添加数据
	@RequestMapping("createGoods.action")
	public String createGoods() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Supplier> supplierList = this.supplierService.getAllSupplier();
		this.getRequest().setAttribute("supplierList", supplierList);
		List<Racks> racksList = this.racksService.getAllRacks();
		this.getRequest().setAttribute("racksList", racksList);
		return "admin/addgoods";
	}

	// 添加数据
	@RequestMapping("addGoods.action")
	public String addGoods(Goods goods) {
		goods.setSellnum("0");
		goods.setHits("0");
		goods.setAddtime(VeDate.getStringDateShort());
		this.goodsService.insertGoods(goods);
		return "redirect:/goods/createGoods.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteGoods.action")
	public String deleteGoods(String id) {
		this.goodsService.deleteGoods(id);
		return "redirect:/goods/getAllGoods.action";
	}

	// 批量删除数据
	@RequestMapping("deleteGoodsByIds.action")
	public String deleteGoodsByIds() {
		String[] ids = this.getRequest().getParameterValues("goodsid");
		for (String goodsid : ids) {
			this.goodsService.deleteGoods(goodsid);
		}
		return "redirect:/goods/getAllGoods.action";
	}

	// 更新数据
	@RequestMapping("updateGoods.action")
	public String updateGoods(Goods goods) {
		this.goodsService.updateGoods(goods);
		return "redirect:/goods/getAllGoods.action";
	}

	// 显示全部数据
	@RequestMapping("getAllGoods.action")
	public String getAllGoods(String number) {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		PageHelper.getPage(goodsList, "goods", null, null, 10, number, this.getRequest(), null);
		return "admin/listgoods";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryGoodsByCond.action")
	public String queryGoodsByCond(String cond, String name, String number) {
		Goods goods = new Goods();
		if (cond != null) {
			if ("goodsname".equals(cond)) {
				goods.setGoodsname(name);
			}
			if ("cateid".equals(cond)) {
				goods.setCateid(name);
			}
			if ("brand".equals(cond)) {
				goods.setBrand(name);
			}
			if ("type".equals(cond)) {
				goods.setType(name);
			}
			if ("size".equals(cond)) {
				goods.setSize(name);
			}
			if ("seating".equals(cond)) {
				goods.setSeating(name);
			}
			if ("image".equals(cond)) {
				goods.setImage(name);
			}
			if ("color".equals(cond)) {
				goods.setColor(name);
			}
			if ("supplierid".equals(cond)) {
				goods.setSupplierid(name);
			}
			if ("racksid".equals(cond)) {
				goods.setRacksid(name);
			}
			if ("price".equals(cond)) {
				goods.setPrice(name);
			}
			if ("storage".equals(cond)) {
				goods.setStorage(name);
			}
			if ("sellnum".equals(cond)) {
				goods.setSellnum(name);
			}
			if ("hits".equals(cond)) {
				goods.setHits(name);
			}
			if ("recommend".equals(cond)) {
				goods.setRecommend(name);
			}
			if ("special".equals(cond)) {
				goods.setSpecial(name);
			}
			if ("addtime".equals(cond)) {
				goods.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.goodsService.getGoodsByLike(goods), "goods", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querygoods";
	}

	// 按主键查询数据
	@RequestMapping("getGoodsById.action")
	public String getGoodsById(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Supplier> supplierList = this.supplierService.getAllSupplier();
		this.getRequest().setAttribute("supplierList", supplierList);
		List<Racks> racksList = this.racksService.getAllRacks();
		this.getRequest().setAttribute("racksList", racksList);
		return "admin/editgoods";
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

}

