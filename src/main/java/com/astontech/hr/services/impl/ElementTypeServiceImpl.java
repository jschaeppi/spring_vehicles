package com.astontech.hr.services.impl;

import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementTypeServiceImpl implements ElementTypeService {
    
    @Autowired
    ElementTypeRepository elementTypeRepository;
    
    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepository.save(elementType);
    }
    
    @Override
    public Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable) {
        return elementTypeRepository.saveAll(elementTypeIterable);
    }
    
    @Override
    public Iterable<ElementType> listAllElementTypes() {
        return elementTypeRepository.findAll();
    }
    
    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteElementType(int id) {
        elementTypeRepository.deleteById(id);
    }
    
    @Override
    public List<ElementType> findAllByElementType(String keyword) {
        return elementTypeRepository.findAllByElementTypeName(keyword);
    }
    
    @Override
    public List<ElementType> findAllByElementTypeIgnoreCase(String keyword) {
        return elementTypeRepository.findAllByElementTypeName(keyword);
    }
    
    @Override
    public List<ElementType> findAllByElementTypeContains(String keyword) {
        return findAllByElementTypeContains(keyword);
    }
    
    @Override
    public ElementType findElementTypeById(Integer id) {
        return elementTypeRepository.findElementById(id);
    }
    
    @Override
    public int countNumElementType(String keyword) {
        return elementTypeRepository.countOfElementType("Phone");
    }
    
    @Override
    public ElementType getElementTypeByType(String keyword) {
        return elementTypeRepository.findElementTypeByType(keyword);
    }
}
