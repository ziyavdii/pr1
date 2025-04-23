
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Election {
    private String name;
    private LocalDate endDate;
    private List<Candidate> candidates;

    public Election(String name, LocalDate endDate) {
        this.name = name;
        this.endDate = endDate;
        this.candidates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }
}
