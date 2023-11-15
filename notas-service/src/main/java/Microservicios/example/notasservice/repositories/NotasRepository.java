package Microservicios.example.notasservice.repositories;

import Microservicios.example.notasservice.entities.NotasEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasRepository extends CrudRepository<NotasEntity, Long> {

    List<NotasEntity> findByRut(String rut);
}