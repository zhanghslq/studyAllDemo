package com.zhs.demojpa;

import com.zhs.demojpa.dao.PetDao;
import com.zhs.demojpa.domin.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    private PetDao petDao;
    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @Test
    public void testAdd(){
        Pet pet = new Pet();
        pet.setColor("yello色");
        pet.setName("狗");
        petDao.save(pet);
    }

    @Test
    public void testFind(){
        Optional<Pet> byId = petDao.findById(2);

    }
    @Test
    public void testFindAll(){
        List<Pet> all = petDao.findAll(Sort.by("id").descending());
        System.out.println(all);
    }

    @Test
    public void find(){
        Page<Pet> page = petDao.findAll(PageRequest.of(1, 2));
        System.out.println(page.getContent());
    }

    @Test
    public void testLoad(){
        List<Pet> pets = petDao.loadPetList(1);
        System.out.println(pets);
    }

    @Test
    public void te(){
        List<Object[]> load = petDao.load(1);
        for (Object[] objects : load) {
            for (Object object : objects) {
                System.out.println(object.toString());
            }
        }
        System.out.println(load);
    }

}
