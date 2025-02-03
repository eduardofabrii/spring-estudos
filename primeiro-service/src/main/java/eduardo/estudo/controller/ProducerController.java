package eduardo.estudo.controller;

import eduardo.estudo.domain.Producer;
import eduardo.estudo.mapper.ProducerMapper;
import eduardo.estudo.request.ProducerPostRequest;
import eduardo.estudo.request.ProducerPutRequest;
import eduardo.estudo.response.ProducerGetResponse;
import eduardo.estudo.response.ProducerPostResponse;
import eduardo.estudo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/producers")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerMapper mapper;
    private final ProducerService service;

    @GetMapping
    public ResponseEntity<List<ProducerGetResponse>> listAll(@RequestParam(required = false) String name) {
        log.debug("Request received to list all producers, param name: '{}'", name);

        var producers = service.findAll(name);
        var producerGetResponses = mapper.toProducerGetResponseList(producers);

        return ResponseEntity.ok(producerGetResponses);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProducerGetResponse> findById(@PathVariable Long id) {
        log.debug("Request to find producer by id: '{}'", id);

        var producer = service.findByIdOrThrowNotFound(id);
        var producerGetResponse = mapper.toProducerGetResponse(producer);

        return ResponseEntity.ok(producerGetResponse);
    }


    @PostMapping(headers = "x-api-key")
    public ResponseEntity<ProducerPostResponse> save(@RequestBody ProducerPostRequest producerPostRequest,
                                                     @RequestHeader HttpHeaders headers) {
        log.info("{}" + headers);

        var producer = mapper.toProducer(producerPostRequest);
        Producer producerSaved = service.save(producer);
        var producerPostResponse = mapper.toProducerPostResponse(producerSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(producerPostResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.debug("Request to delete producer by id: '{}'", id);

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ProducerPutRequest request) {
        log.debug("Request to delete producer '{}'", request);

        var producerToUpdate = mapper.toProducer(request);

        service.update(producerToUpdate);

        return ResponseEntity.noContent().build();
    }
}
