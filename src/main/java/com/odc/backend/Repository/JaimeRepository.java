package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.Jaime;
import com.odc.backend.Models.Niveau;
import com.odc.backend.Models.User;

public interface JaimeRepository extends JpaRepository<Jaime, Long> {
    
    Jaime findByUserAndConseil(User user, Conseil conseil);

        Jaime findByUserAndNiveau(User user, Niveau niveau);

}
