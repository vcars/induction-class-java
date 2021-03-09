package id.bmri.induction.be.day2.be.induction.be.day2.service.impl;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.JobsDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Jobs;
import id.bmri.induction.be.day2.be.induction.be.day2.repository.JobsRepository;
import id.bmri.induction.be.day2.be.induction.be.day2.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl implements JobsService {

    @Autowired
    JobsRepository jobsRepository;


    @Override
    public void mergeFromEmployee() {
        try {
            this.jobsRepository.mergeDataFromEmployee();
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong");
        }

    }

    private JobsDto getFetchToDto (Jobs mapper) {

        JobsDto jobsDto = new JobsDto();
        jobsDto.setJobTitle(mapper.getJobTitle());
        jobsDto.setMinSalary(mapper.getMinSalary());
        jobsDto.setMaxSalary(mapper.getMaxSalary());

        return  jobsDto;
    }
}
