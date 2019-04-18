package com.example.codeclan.pirateservice.repository.RaidRepository;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public interface RaidRepositoryCustom {
    public List<Pirate> getPiratesForRaid(Raid raid);
}
