package in.cts.budgetanalysis.profiles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cts.budgetanalysis.profiles.entities.AccountHolder;
import in.cts.budgetanalysis.profiles.exceptions.BadProfileException;
import in.cts.budgetanalysis.profiles.services.AccountHolderService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ProfilesRestController {

	@Autowired
	private AccountHolderService ahService;

	@GetMapping
	public ResponseEntity<List<AccountHolder>> getAllAccountHolders() {
		return ResponseEntity.ok(ahService.getAll());
	}
	
	@GetMapping("/{ahid}")
	public ResponseEntity<AccountHolder> getAccountHolderByIdAction(@PathVariable("ahid") Long ahid) throws BadProfileException {
		AccountHolder model = ahService.getById(ahid);
		return model==null? ResponseEntity.notFound().build() : ResponseEntity.ok(model);
	}
	
	@GetMapping("/{ahid}/exists")
	public ResponseEntity<Boolean> existsAccountHolderByIdAction(@PathVariable("ahid") Long ahid) throws BadProfileException {
		return ResponseEntity.ok(ahService.existsById(ahid));
	}
	
	@PostMapping
	public ResponseEntity<AccountHolder> addAction(@RequestBody AccountHolder model) throws BadProfileException{
		return new ResponseEntity<AccountHolder>(ahService.add(model), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<AccountHolder> modifyAction(@RequestBody AccountHolder model) throws BadProfileException{
		return new ResponseEntity<AccountHolder>(ahService.modify(model), HttpStatus.ACCEPTED);
	}
}
