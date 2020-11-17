package com.lambdaschool.bwafricanmarket.repositories;

import com.lambdaschool.bwafricanmarket.models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Object> findAllById(long id);
}
