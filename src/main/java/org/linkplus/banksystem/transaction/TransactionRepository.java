package org.linkplus.banksystem.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {


    List<TransactionEntity> findByOriginatingAccountIdOrResultingAccountId(Long id, Long id1);
}
