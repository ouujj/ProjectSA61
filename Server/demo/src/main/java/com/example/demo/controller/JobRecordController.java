package com.example.demo.controller;

        import com.example.demo.respository.*;
        import com.example.demo.entity.*;

        import java.util.Collection;
        import java.util.Optional;
        import java.util.Map;
        import javax.validation.Valid;
        import java.util.Date;

        import org.springframework.http.MediaType;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;
        import java.util.Collection;
        import java.util.stream.Collectors;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Records")

class JobRecordController {

    @Autowired  private  jobrecordrepos repository;
    @Autowired private Personrepos personRepository;


    public JobRecordController(jobrecordrepos repository){
        this.repository=repository;
    }

    @GetMapping()
    public Collection<job_record> job_record() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()
    public  job_record  Record(job_record newrecord ,@RequestBody  Map<String,Object> body){


        Optional<personnel> person = personRepository.findById(Long.valueOf(body.get("person").toString()));

        newrecord.setPerson(person.get());
        newrecord.setTime(new Date());
        return repository.save(newrecord);

    }


}
