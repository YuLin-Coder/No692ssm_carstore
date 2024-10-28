package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Supplier;
import com.service.SupplierService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/supplier", produces = "text/plain;charset=utf-8")
public class SupplierController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private SupplierService supplierService;

	// 准备添加数据
	@RequestMapping("createSupplier.action")
	public String createSupplier() {
		return "admin/addsupplier";
	}

	// 添加数据
	@RequestMapping("addSupplier.action")
	public String addSupplier(Supplier supplier) {
		this.supplierService.insertSupplier(supplier);
		return "redirect:/supplier/createSupplier.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSupplier.action")
	public String deleteSupplier(String id) {
		this.supplierService.deleteSupplier(id);
		return "redirect:/supplier/getAllSupplier.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSupplierByIds.action")
	public String deleteSupplierByIds() {
		String[] ids = this.getRequest().getParameterValues("supplierid");
		for (String supplierid : ids) {
			this.supplierService.deleteSupplier(supplierid);
		}
		return "redirect:/supplier/getAllSupplier.action";
	}

	// 更新数据
	@RequestMapping("updateSupplier.action")
	public String updateSupplier(Supplier supplier) {
		this.supplierService.updateSupplier(supplier);
		return "redirect:/supplier/getAllSupplier.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSupplier.action")
	public String getAllSupplier(String number) {
		List<Supplier> supplierList = this.supplierService.getAllSupplier();
		PageHelper.getPage(supplierList, "supplier", null, null, 10, number, this.getRequest(), null);
		return "admin/listsupplier";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySupplierByCond.action")
	public String querySupplierByCond(String cond, String name, String number) {
		Supplier supplier = new Supplier();
		if (cond != null) {
			if ("supname".equals(cond)) {
				supplier.setSupname(name);
			}
			if ("contents".equals(cond)) {
				supplier.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.supplierService.getSupplierByLike(supplier), "supplier", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querysupplier";
	}

	// 按主键查询数据
	@RequestMapping("getSupplierById.action")
	public String getSupplierById(String id) {
		Supplier supplier = this.supplierService.getSupplierById(id);
		this.getRequest().setAttribute("supplier", supplier);
		return "admin/editsupplier";
	}

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

}

