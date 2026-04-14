package de.adesso.react_crash_course.note.api;

import org.springframework.web.bind.annotation.RestController;

import de.adesso.react_crash_course.note.application.NoteService;
import de.adesso.react_crash_course.note.application.dto.CreateNoteRequest;
import de.adesso.react_crash_course.note.application.dto.NoteDto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("v1/notes")
public class NoteControllerV1 {

    NoteService noteService;

    public NoteControllerV1(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> findAll() {
        return new ResponseEntity<>(noteService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NoteDto> create(@RequestBody CreateNoteRequest createNoteRequest) {
        return new ResponseEntity<>(noteService.create(createNoteRequest), HttpStatus.CREATED);
    }
}
