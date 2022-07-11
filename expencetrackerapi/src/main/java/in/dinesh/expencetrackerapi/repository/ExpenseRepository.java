package in.dinesh.expencetrackerapi.repository;

import in.dinesh.expencetrackerapi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
