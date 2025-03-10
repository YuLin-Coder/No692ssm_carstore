package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.entity.Cate;
import com.entity.Goods;
import com.entity.Orders;
import com.entity.Topic;
import com.entity.Users;
import com.service.CateService;
import com.service.GoodsService;
import com.service.OrdersService;
import com.service.TopicService;
import com.service.UsersService;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private CateService cateService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UsersService usersService;

	@RequestMapping("preChartUser.action")
	public String preChartUser() {
		return "admin/chartUser";
	}

	@RequestMapping("chartUser.action")
	@ResponseBody
	public String chartUser() {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		long days = VeDate.getDays(end, start) + 1;
		JSONArray total = new JSONArray();
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(start, "" + i);
			Users users = new Users();
			users.setRegdate(nxtDay);
			List<Users> list = this.usersService.getUsersByCond(users);
			total.add(list.size());
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("total", total.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("preChartOrders.action")
	public String preChartOrders() {
		return "admin/chartOrders";
	}

	@RequestMapping("chartOrders.action")
	@ResponseBody
	public String chartOrders() {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		long days = VeDate.getDays(end, start) + 1;
		JSONArray total = new JSONArray();
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(start, "" + i);
			Orders orders = new Orders();
			orders.setAddtime(nxtDay);
			List<Orders> list = this.ordersService.getOrdersByCond(orders);
			total.add(list.size());
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("total", total.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("preNum.action")
	public String preNum() {
		return "admin/chartnum";
	}

	@RequestMapping("getNum.action")
	@ResponseBody
	public String getNum() {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		long days = VeDate.getDays(start, end) + 1;
		JSONArray total = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "" + i);
			Orders orders = new Orders();
			orders.setAddtime(nxtDay);
			List<Orders> list = this.ordersService.getOrdersByCond(orders);
			double sellTotal = 0;
			double sellCount = 0;
			for (Orders x : list) {
				sellTotal += Double.parseDouble(x.getTotal());
			}
			sellCount = list.size();
			total.add(VeDate.getDouble(sellTotal));
			count.add(sellCount);
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("sellCount", count.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("preChartTopic.action")
	public String preChartTopic() {
		return "admin/chartTopic";
	}

	@RequestMapping("chartTopic.action")
	@ResponseBody
	public String chartPie() throws JSONException {
		JSONArray names = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		int stars1 = 0;
		int stars2 = 0;
		int stars3 = 0;
		int stars4 = 0;
		int stars5 = 0;
		names.add("非常满意");
		names.add("满意");
		names.add("一般");
		names.add("不满意");
		names.add("非常不满意");
		List<Topic> topicList = this.topicService.getAllTopic();
		for (Topic topic : topicList) {
			if ("1".equals(topic.getNum())) {
				stars1++;
			}
			if ("2".equals(topic.getNum())) {
				stars2++;
			}
			if ("3".equals(topic.getNum())) {
				stars3++;
			}
			if ("4".equals(topic.getNum())) {
				stars4++;
			}
			if ("5".equals(topic.getNum())) {
				stars5++;
			}

		}
		count.add(stars5);
		count.add(stars4);
		count.add(stars3);
		count.add(stars2);
		count.add(stars1);
		JSONObject json = new JSONObject();
		json.put("count", count.toString());
		json.put("names", names.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("preCate.action")
	public String preCate() {
		return "admin/chartCate";
	}

	@RequestMapping("chartCate.action")
	@ResponseBody
	public String chartCate() {
		JSONArray names = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		List<Cate> cateList = this.cateService.getAllCate();
		for (Cate c : cateList) {
			names.add(c.getCatename());
			Goods goods = new Goods();
			goods.setCateid(c.getCateid());
			List<Goods> goodsList = this.goodsService.getGoodsByCond(goods);
			int num = 0;
			for (Goods g : goodsList) {
				num += Integer.parseInt(g.getSellnum());
			}
			count.add(num);
		}
		JSONObject json = new JSONObject();
		json.put("count", count.toString());
		json.put("names", names.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
