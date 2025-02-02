package com.skverma.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = {"http://localhost:3000",
        "http://challenge-application-live.s3-website.eu-north-1.amazonaws.com/"})
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges(){

        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded =
                challengeService.addChallenge(challenge);
        if (isChallengeAdded) {
            return new ResponseEntity("Challenges Added Successfully",
                    HttpStatus.OK);
        }else {
            return new ResponseEntity("Challenges Not Added Successfully",
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getAChallenge(@PathVariable String month){
        Challenge challenge =
                challengeService.getChallenge(month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
        if (isChallengeUpdated) {
            return new ResponseEntity("Challenges Added Successfully",
                    HttpStatus.OK);
        }else {
            return new ResponseEntity("Challenges Not Added Successfully",
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if (isChallengeDeleted) {
            return new ResponseEntity("Challenges Deleted Successfully",
                    HttpStatus.OK);
        }else {
            return new ResponseEntity("Challenges Not Deleted",
                    HttpStatus.NOT_FOUND);
        }
    }
}
