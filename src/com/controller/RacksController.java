package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Racks;
import com.service.RacksService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/racks", produces = "text/plain;charset=utf-8")
public class RacksController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private RacksService racksService;

	// 准备添加数据
	@RequestMapping("createRacks.action")
	public String createRacks() {
		return "admin/addracks";
	}

	// 添加数据
	@RequestMapping("addRacks.action")
	public String addRacks(Racks racks) {
		this.racksService.insertRacks(racks);
		return "redirect:/racks/createRacks.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRacks.action")
	public String deleteRacks(String id) {
		this.racksService.deleteRacks(id);
		return "redirect:/racks/getAllRacks.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRacksByIds.action")
	public String deleteRacksByIds() {
		String[] ids = this.getRequest().getParameterValues("racksid");
		for (String racksid : ids) {
			this.racksService.deleteRacks(racksid);
		}
		return "redirect:/racks/getAllRacks.action";
	}

	// 更新数据
	@RequestMapping("updateRacks.action")
	public String updateRacks(Racks racks) {
		this.racksService.updateRacks(racks);
		return "redirect:/racks/getAllRacks.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRacks.action")
	public String getAllRacks(String number) {
		List<Racks> racksList = this.racksService.getAllRacks();
		PageHelper.getPage(racksList, "racks", null, null, 10, number, this.getRequest(), null);
		return "admin/listracks";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRacksByCond.action")
	public String queryRacksByCond(String cond, String name, String number) {
		Racks racks = new Racks();
		if (cond != null) {
			if ("racksno".equals(cond)) {
				racks.setRacksno(name);
			}
			if ("contents".equals(cond)) {
				racks.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.racksService.getRacksByLike(racks), "racks", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryracks";
	}

	// 按主键查询数据
	@RequestMapping("getRacksById.action")
	public String getRacksById(String id) {
		Racks racks = this.racksService.getRacksById(id);
		this.getRequest().setAttribute("racks", racks);
		return "admin/editracks";
	}

	public RacksService getRacksService() {
		return racksService;
	}

	public void setRacksService(RacksService racksService) {
		this.racksService = racksService;
	}

}

