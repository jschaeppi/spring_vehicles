package services;
import com.astontech.hr.Application;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ElementServiceTest {
    
    @Autowired
    private ElementService elementService;
    
    @Autowired
    private ElementTypeService elementTypeService;
    
    
    @Test
    public void elementSaveServiceTest() {
    
        //setup an elememt
        Element element = new Element();
        element.setElementName("Phone");
    
        //save element, verify it has an ID after the save.
        Assert.isNull(element.getId(), "This object is null");
        elementService.saveElement(element);
        Assert.notNull(element.getId(), "This object is hydrated");
    
        //fetch
        Element fetchedElement = elementService.getElementById(element.getId());
        Assert.isTrue(element.getId().equals(fetchedElement.getId()), "Theses id's aren't equal");
    
        //update
        fetchedElement.setElementName("Email");
        elementService.saveElement(fetchedElement);
    
        Element updatedElement = elementService.getElementById(fetchedElement.getId());
        Assert.isTrue(updatedElement.getElementName() == "Email", "The requested element wasn't found");
    }
    
    @Test
    public void elementTypeServiceTest() {
        ElementType elementType = new ElementType();
        Assert.isNull(elementType.getId(), "Element type isn't empty");
        elementTypeService.saveElementType(elementType);
        Assert.notNull(elementType.getId(), "Element type is null");
        
        ElementType fetchedElementType = elementTypeService.findElementTypeById(elementType.getId());
        Assert.isTrue(elementType.getId() == fetchedElementType.getId(), "Element types don't match");
        
        fetchedElementType.setElementTypeName("Phone");
        elementTypeService.saveElementType(fetchedElementType);
        
        elementTypeService.getElementTypeByType("Phone");
        Assert.notNull(fetchedElementType.getElementTypeName(), "Element type didn't match search criteria");
        
        ElementType updatedElementType = elementTypeService.getElementTypeById(fetchedElementType.getId());
        Assert.isTrue(updatedElementType.getElementTypeName() == "Phone", "Element type doesn't match search criteria");
    
        List<ElementType> elementTypeList = new ArrayList<>();
        elementTypeList.add(new ElementType("Phone"));
        elementTypeList.add(new ElementType("Phone"));
        elementTypeList.add(new ElementType("Phone"));
        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Work"));
        elementTypeList.add(new ElementType("Computer"));
        elementTypeList.add(new ElementType("Home"));
        elementTypeList.add(new ElementType("Headset"));
        
        elementTypeService.saveElementTypeList(elementTypeList);
        
        int count = elementTypeService.countNumElementType("Phone");
        
        Assert.isTrue(count == 4, "Number of elements don't match");
    }
}
