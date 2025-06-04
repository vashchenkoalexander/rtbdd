package org.rtbdd.repository;

import org.rtbdd.model.Bids;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidsRepository extends JpaRepository<Bids, Long> {
}
