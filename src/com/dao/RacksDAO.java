package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Racks;

@Repository("racksDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface RacksDAO {

	/**
	 * RacksDAO 接口 可以按名称直接调用racks.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包racks.xml里的insertRacks配置 返回值0(失败),1(成功)
	public int insertRacks(Racks racks);

	// 更新数据 调用entity包racks.xml里的updateRacks配置 返回值0(失败),1(成功)
	public int updateRacks(Racks racks);

	// 删除数据 调用entity包racks.xml里的deleteRacks配置 返回值0(失败),1(成功)
	public int deleteRacks(String racksid);

	// 查询全部数据 调用entity包racks.xml里的getAllRacks配置 返回List类型的数据
	public List<Racks> getAllRacks();

	// 按照Racks类里面的值精确查询 调用entity包racks.xml里的getRacksByCond配置 返回List类型的数据
	public List<Racks> getRacksByCond(Racks racks);

	// 按照Racks类里面的值模糊查询 调用entity包racks.xml里的getRacksByLike配置 返回List类型的数据
	public List<Racks> getRacksByLike(Racks racks);

	// 按主键查询表返回单一的Racks实例 调用entity包racks.xml里的getRacksById配置
	public Racks getRacksById(String racksid);

}
