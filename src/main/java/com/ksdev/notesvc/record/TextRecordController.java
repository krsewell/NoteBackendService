package com.ksdev.notesvc.record;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/api/records", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TextRecordController {
    private final TextRecordService textRecordService;

    public TextRecordController(TextRecordService textRecordService) {
        this.textRecordService = textRecordService;
    }

    @GetMapping("/{id}")
    public TextRecord get(@PathVariable long id) {
        return textRecordService.get(id).orElseThrow();
    }

    @PostMapping
    public TextRecord save(@RequestBody TextRecord textRecord) {
        return textRecordService.save(textRecord);
    }

    @PatchMapping("/{id}")
    public TextRecord update(@PathVariable long id, @RequestBody TextRecord textRecord) {
        return textRecordService.update(id, textRecord);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        textRecordService.delete(id);
    }

    @GetMapping
    public Iterable<TextRecord> getAll() {
        return textRecordService.getAll();
    }

    @PatchMapping("/batch")
    public Iterable<TextRecord> updateAll(@RequestBody List<TextRecord> textRecords) {
        return textRecordService.updateAll(textRecords);
    }

    @PostMapping("/batch")
    public Iterable<TextRecord> saveAll(@RequestBody List<TextRecord> textRecords) {
        return textRecordService.saveAll(textRecords);
    }

}
