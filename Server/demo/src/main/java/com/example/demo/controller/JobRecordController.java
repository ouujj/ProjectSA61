package com.example.demo.controller;

        import com.example.demo.respository.jobrecordrepos;
        import com.example.demo.entity.job_record;

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
    private  jobrecordrepos repository;

    public JobRecordController(jobrecordrepos repository){
        this.repository=repository;
    }

    @GetMapping()
    public Collection<job_record> job_record() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping()
    public  job_record  Record(@RequestBody  job_record body){
        return repository.save(body);
    }


}
