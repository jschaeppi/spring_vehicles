package repositories;


import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
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
@SpringBootTest(classes = RepositoryConfiguration.class)
@WebAppConfiguration
public class ElementRepositoryTest {

    
    @Autowired
    private ElementRepository elementRepository;
    
    @Autowired
    private ElementTypeRepository elementTypeRepository;
    
    @Test
    public void testSaveElement() {
        //setup an elememt
        Element element = new Element();
        element.setElementName("Phone");
        
        //save element, verify it has an ID after the save.
        Assert.isNull(element.getId(), "This object is null");
        elementRepository.save(element);
        Assert.notNull(element.getId(), "This object is hydrated");
        
        //fetch
        Element fetchedElement = elementRepository.findById(element.getId()).orElse(null);
        Assert.isTrue(element.getId().equals(fetchedElement.getId()), "Theses id's aren't equal");
        
        //update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);
        
        Element updatedElement = elementRepository.findById(fetchedElement.getId()).orElse(null);
        Assert.isTrue(updatedElement.getElementName() == "Email", "The requested element wasn't found");
    }
    
    @Test
    public void testSaveElementList() {
        List<Element> elementList = new ArrayList<>();
        
        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));
        
        elementRepository.saveAll(elementList);
        
        Iterable<Element> fetchedElementList = elementRepository.findAll();
        
        int count = 0;
        for (Element e : fetchedElementList) {
            count++;
        }
        
        Assert.isTrue(4 == count, "The amount of elements found is incorrect");
    }
    
    @Test
    public void testFindByName() {
        Element element = new Element("FindTest");
        elementRepository.save(element);
        
        Element foundByNameElement = elementRepository.findByElementName(("FindTest"));
        
        Assert.isTrue(element.getId() == foundByNameElement.getId(), "Didn't find element requested");
    }
    
    @Test
    public void testFindAllByName() {
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);
        
        List<Element> foundAllByNameElement = elementRepository.findAllByElementName(("FindTest"));
        
        Assert.isTrue(foundAllByNameElement.size() == 3, "Correct number of elements not found");
        
    }
    
    @Test
    public void testCustomQueries() {
        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("iPhone 6S"));
        elementList.add(new Element("Samsung s10"));
        elementList.add(new Element("Samsung s10"));
        elementList.add(new Element("Samsung s10"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("HP"));
        elementRepository.saveAll(elementList);
        
        Element topElementFound = elementRepository.findTopBy();
        
        Assert.notNull(topElementFound, "Element is null");
        
        List<Element> elementsFound = elementRepository.findAllByElementName("Samsung s10");
        
        Assert.notEmpty(elementsFound, "Collection of elements is empty");
        
        int numOfElements = elementRepository.countElementByElementName("Dell");
        
        Assert.isTrue(numOfElements == 2, "This returned false");
        
    }
    
    @Test
    public void testCustomTypeQueries() {
        List<ElementType> elementTypeList = new ArrayList<>();
        elementTypeList.add(new ElementType("Computer"));
        elementTypeList.add(new ElementType("Phone"));
        elementTypeList.add(new ElementType("TV"));
        elementTypeList.add(new ElementType("email"));
        elementTypeList.add(new ElementType("email"));
        elementTypeList.add(new ElementType("email"));
        elementTypeRepository.saveAll(elementTypeList);
        
        List<ElementType> allElementsList = elementTypeRepository.findAllByElementTypeNameContains("mail");
        
        Assert.isTrue(allElementsList.size() == 3, "This returned incorrect number of elementTypes");
        
        ElementType elementType = elementTypeRepository.findElementById(4);
        
        Assert.isTrue(elementType.getId() == 4, "No id was found");
    }
}
