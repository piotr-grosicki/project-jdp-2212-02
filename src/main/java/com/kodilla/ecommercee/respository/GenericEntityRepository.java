<<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/repository/GenericEntityRepository.java

package com.kodilla.ecommercee.repository;

========
package com.kodilla.ecommercee.respository;

>>>>>>>> JDP221202-1:src/main/java/com/kodilla/ecommercee/respository/GenericEntityRepository.java
import com.kodilla.ecommercee.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> { }
