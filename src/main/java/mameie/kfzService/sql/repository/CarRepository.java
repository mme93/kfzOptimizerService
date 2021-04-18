package mameie.kfzService.sql.repository;

import mameie.kfzService.sql.model.Car;
import mameie.kfzService.sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    default List<Car> findByLastName(String lastName) {
        return null;
    }

    User findById(long id);
}