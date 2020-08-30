package packages.services;

import packages.models.Record;
import packages.models.Test;

import java.util.List;

public interface RecordService {
    List<Record> findAllByTest(Test test);

    List<Record> findAll();
}
