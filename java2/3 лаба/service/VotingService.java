
package service;

import model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingService {
    private Map<Election, Map<Candidate, Integer>> results = new HashMap<>();
    private Map<String, Boolean> votedUsers = new HashMap<>();

    public void vote(Voter voter, Election election, Candidate candidate) {
        if (votedUsers.getOrDefault(voter.getLogin() + election.getName(), false)) {
            System.out.println("Вы уже голосовали в этом голосовании.");
            return;
        }

        results.putIfAbsent(election, new HashMap<>());
        Map<Candidate, Integer> electionResults = results.get(election);
        electionResults.put(candidate, electionResults.getOrDefault(candidate, 0) + 1);
        votedUsers.put(voter.getLogin() + election.getName(), true);

        System.out.println("Голос засчитан!");
    }

    public void showResults(Election election) {
        Map<Candidate, Integer> electionResults = results.getOrDefault(election, new HashMap<>());
        System.out.println("Результаты голосования: " + election.getName());
        for (Candidate c : election.getCandidates()) {
            int votes = electionResults.getOrDefault(c, 0);
            System.out.println("- " + c.getLogin() + ": " + votes + " голосов");
        }
    }
}
