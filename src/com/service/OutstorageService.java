package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Outstorage;

@Service("outstorageService")
public interface OutstorageService {
	// 插入数据 调用outstorageDAO里的insertOutstorage配置
	public int insertOutstorage(Outstorage outstorage);

	// 更新数据 调用outstorageDAO里的updateOutstorage配置
	public int updateOutstorage(Outstorage outstorage);

	// 删除数据 调用outstorageDAO里的deleteOutstorage配置
	public int deleteOutstorage(String outstorageid);

	// 查询全部数据 调用outstorageDAO里的getAllOutstorage配置
	public List<Outstorage> getAllOutstorage();

	// 按照Outstorage类里面的字段名称精确查询 调用outstorageDAO里的getOutstorageByCond配置
	public List<Outstorage> getOutstorageByCond(Outstorage outstorage);

	// 按照Outstorage类里面的字段名称模糊查询 调用outstorageDAO里的getOutstorageByLike配置
	public List<Outstorage> getOutstorageByLike(Outstorage outstorage);

	// 按主键查询表返回单一的Outstorage实例 调用outstorageDAO里的getOutstorageById配置
	public Outstorage getOutstorageById(String outstorageid);

}
