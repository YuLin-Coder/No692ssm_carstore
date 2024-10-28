package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Instorage;

@Service("instorageService")
public interface InstorageService {
	// 插入数据 调用instorageDAO里的insertInstorage配置
	public int insertInstorage(Instorage instorage);

	// 更新数据 调用instorageDAO里的updateInstorage配置
	public int updateInstorage(Instorage instorage);

	// 删除数据 调用instorageDAO里的deleteInstorage配置
	public int deleteInstorage(String instorageid);

	// 查询全部数据 调用instorageDAO里的getAllInstorage配置
	public List<Instorage> getAllInstorage();

	// 按照Instorage类里面的字段名称精确查询 调用instorageDAO里的getInstorageByCond配置
	public List<Instorage> getInstorageByCond(Instorage instorage);

	// 按照Instorage类里面的字段名称模糊查询 调用instorageDAO里的getInstorageByLike配置
	public List<Instorage> getInstorageByLike(Instorage instorage);

	// 按主键查询表返回单一的Instorage实例 调用instorageDAO里的getInstorageById配置
	public Instorage getInstorageById(String instorageid);

}
