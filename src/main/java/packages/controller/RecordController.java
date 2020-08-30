package packages.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import packages.models.Record;
import packages.services.RecordService;

import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping("/all")
    public ResponseEntity<List<Record>> getRecords() {
        return new ResponseEntity<>(recordService.findAll(), HttpStatus.OK);
    }
}
