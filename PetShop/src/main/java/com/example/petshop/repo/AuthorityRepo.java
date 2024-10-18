package com.example.petshop.repo;

import com.example.petshop.entity.Authority;
<<<<<<< HEAD

=======
>>>>>>> 1ca2bf2910c223089592b9fb43660604cf8a1054
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorityRepo extends JpaRepository<Authority, Integer> {

}
