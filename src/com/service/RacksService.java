package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Racks;

@Service("racksService")
public interface RacksService {
	// 插入数据 调用racksDAO里的insertRacks配置
	public int insertRacks(Racks racks);

	// 更新数据 调用racksDAO里的updateRacks配置
	public int updateRacks(Racks racks);

	// 删除数据 调用racksDAO里的deleteRacks配置
	public int deleteRacks(String racksid);

	// 查询全部数据 调用racksDAO里的getAllRacks配置
	public List<Racks> getAllRacks();

	// 按照Racks类里面的字段名称精确查询 调用racksDAO里的getRacksByCond配置
	public List<Racks> getRacksByCond(Racks racks);

	// 按照Racks类里面的字段名称模糊查询 调用racksDAO里的getRacksByLike配置
	public List<Racks> getRacksByLike(Racks racks);

	// 按主键查询表返回单一的Racks实例 调用racksDAO里的getRacksById配置
	public Racks getRacksById(String racksid);

}
