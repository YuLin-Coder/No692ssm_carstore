package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.InstorageDAO;
import com.entity.Instorage;
import com.service.InstorageService;

@Service("instorageService")
public class InstorageServiceImpl implements InstorageService {
	@Autowired
	private InstorageDAO instorageDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertInstorage(Instorage instorage) {
		return this.instorageDAO.insertInstorage(instorage);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateInstorage(Instorage instorage) {
		return this.instorageDAO.updateInstorage(instorage);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteInstorage(String instorageid) {
		return this.instorageDAO.deleteInstorage(instorageid);
	}

	@Override // 继承接口的查询全部
	public List<Instorage> getAllInstorage() {
		return this.instorageDAO.getAllInstorage();
	}

	@Override // 继承接口的按条件精确查询
	public List<Instorage> getInstorageByCond(Instorage instorage) {
		return this.instorageDAO.getInstorageByCond(instorage);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Instorage> getInstorageByLike(Instorage instorage) {
		return this.instorageDAO.getInstorageByLike(instorage);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Instorage getInstorageById(String instorageid) {
		return this.instorageDAO.getInstorageById(instorageid);
	}

}


