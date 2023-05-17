package com.example.auth.repository;
import com.example.auth.modal.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache,Long> {
}
