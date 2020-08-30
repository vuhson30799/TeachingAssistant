package packages.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import packages.models.Record;
import packages.models.Test;
import packages.repository.RecordRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;

    @Override
    public List<Record> findAllByTest(Test test) {
        return recordRepository.findAllByTest(test);
    }

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }
}
