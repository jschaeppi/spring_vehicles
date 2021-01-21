package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {
    
    List<ElementType> findAllByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeNameContains(String keyword);
    
    
    @Query("SELECT count(t) FROM ElementType t WHERE t.elementTypeName = :keyword")
    int countOfElementType(@Param("keyword") String keyword);
    
    @Query("SELECT t FROM ElementType t WHERE t.id = :id" )
    ElementType findElementById(@Param("id") Integer id);
    
    @Query("SELECT t FROM ElementType t WHERE t.elementTypeName = :keyword")
    ElementType findElementTypeByType(@Param("keyword") String keyword);
}
