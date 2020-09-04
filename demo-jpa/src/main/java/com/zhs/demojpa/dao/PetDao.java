package com.zhs.demojpa.dao;

import com.zhs.demojpa.domin.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: zhs
 * @date: 2020/9/4 12:51
 */
public interface PetDao extends JpaRepository<Pet,Integer> {
    /**
     * 根据颜色查询
     * @param color 颜色
     * @return
     */
    List<Pet> findByColor(String color);

    /**
     * 根据颜色和名称查
     * @param color
     * @param name
     * @return
     */
    List<Pet> findAllByColorAndName(String color,String name);

    /**
     * jpql查询
     */
    @Query("select new com.zhs.demojpa.domin.Pet(id,name,color) from com.zhs.demojpa.domin.Pet")
    List<Pet> loadPetList(Integer id);


    @Query("select name from t_pet where id=id")
    List<Object[]> load(Integer id);
}
