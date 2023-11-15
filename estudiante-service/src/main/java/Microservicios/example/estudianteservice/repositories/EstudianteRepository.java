package Microservicios.example.estudianteservice.repositories;


import Microservicios.example.estudianteservice.entities.EstudianteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, Long> {

    EstudianteEntity findByRut(String rut);
}