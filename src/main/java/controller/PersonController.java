package controller;

import domains.person.Person;
import domains.person.PersonDTO;
import domains.person.PersonService;
import domains.person.PersonTransformer;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Transactional
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("persons")
public class PersonController {

    @Inject
    PersonService service;

    @POST
    public PersonDTO createNewPerson(PersonDTO personDTO) {
        Person personToCreate = PersonTransformer.toEntity(personDTO);
        Person createdPerson = service.creatPerson(personToCreate);
        return PersonTransformer.toDTO(createdPerson);
    }
}
