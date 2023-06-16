package com.anushka.bookmark_tagging_s6.Repository;

import com.anushka.bookmark_tagging_s6.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
