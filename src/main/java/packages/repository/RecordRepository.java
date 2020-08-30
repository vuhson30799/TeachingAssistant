package packages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import packages.models.Record;
import packages.models.Test;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findAllByTest(Test test);
}
