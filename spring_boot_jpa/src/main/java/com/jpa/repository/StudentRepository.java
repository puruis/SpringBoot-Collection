package com.jpa.repository;

import com.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Description:
 * User: purui_zhang
 * Date: 2019-02-21
 * Time: 18:31
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
}
