package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RacksDAO;
import com.entity.Racks;
import com.service.RacksService;

@Service("racksService")
public class RacksServiceImpl implements RacksService {
	@Autowired
	private RacksDAO racksDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertRacks(Racks racks) {
		return this.racksDAO.insertRacks(racks);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateRacks(Racks racks) {
		return this.racksDAO.updateRacks(racks);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteRacks(String racksid) {
		return this.racksDAO.deleteRacks(racksid);
	}

	@Override // 继承接口的查询全部
	public List<Racks> getAllRacks() {
		return this.racksDAO.getAllRacks();
	}

	@Override // 继承接口的按条件精确查询
	public List<Racks> getRacksByCond(Racks racks) {
		return this.racksDAO.getRacksByCond(racks);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Racks> getRacksByLike(Racks racks) {
		return this.racksDAO.getRacksByLike(racks);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Racks getRacksById(String racksid) {
		return this.racksDAO.getRacksById(racksid);
	}

}


