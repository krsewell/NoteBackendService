package com.ksdev.notesvc.record;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TextRecordService {

    private final TextRecordRepository repository;
    public TextRecordService(TextRecordRepository repository) {
        this.repository = repository;
    }

    public Optional<TextRecord> get(long id) {
        return repository.findById(id);
    }

    public Iterable<TextRecord> getAll() {
        return repository.findAll();
    }

    public TextRecord save(TextRecord textRecord){
        return repository.save(textRecord);
    }

    public Iterable<TextRecord> saveAll(List<TextRecord> textRecords) {
        return repository.saveAll(textRecords);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public TextRecord update(long id, TextRecord textRecord) {
        TextRecord current = repository.findById(id).orElseThrow();
        if (textRecord.hasTitle()) {
            current.setTitle(textRecord.getTitle());
        }
        if (textRecord.hasContent()) {
            current.setContent(textRecord.getContent());
        }
        if (textRecord.hasLicense()) {
            current.setLicense(textRecord.getLicense());
        }
        if (textRecord.hasDocumentId()) {
            current.setDocumentId(textRecord.getDocumentId());
        }
        current.setUpdatedAt(Instant.now().toEpochMilli());
        return repository.save(current);
    }

    public Iterable<TextRecord> updateAll(List<TextRecord>  textRecords) {
        return textRecords.stream().map(r -> update(r.getId(), r)).collect(Collectors.toList());
    }



}
