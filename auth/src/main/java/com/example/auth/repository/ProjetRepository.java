package com.example.auth.repository;
import com.example.auth.modal.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
