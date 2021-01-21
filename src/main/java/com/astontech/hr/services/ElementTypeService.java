package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

public interface ElementTypeService {
    
    ElementType saveElementType(ElementType elementType);
    
    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);
    
    Iterable<ElementType> listAllElementTypes();
    
    ElementType getElementTypeById(Integer id);
    
    void deleteElementType(int id);
    
    List<ElementType> findAllByElementType(String keyword);
    
    List<ElementType> findAllByElementTypeIgnoreCase(String keyword);
    
    List<ElementType> findAllByElementTypeContains(String keyword);
    
    ElementType findElementTypeById(Integer id);
    ElementType getElementTypeByType(String keyword);
    
    int countNumElementType(String keyword);
}
