/**
 * 
 */
package com.abyster.tests.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abyster.tests.entities.Todo;

/**
 * TodoRepository
 * 
 * Spring data repository for Todos
 * 
 * @author KONGNUY Victorien on 28-09-2021
 *
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
