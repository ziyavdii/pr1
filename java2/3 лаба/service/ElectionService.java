
package service;

import model.Candidate;
import model.Election;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElectionService {
    private List<Election> elections = new ArrayList<>();

    public void createElection(String name, LocalDate endDate) {
        elections.add(new Election(name, endDate));
        System.out.println("Голосование '" + name + "' создано. Завершится: " + endDate);
    }

    public List<Election> getElections() {
        return elections;
    }

    public void listElections() {
        if (elections.isEmpty()) {
            System.out.println("Нет активных голосований.");
        } else {
            for (int i = 0; i < elections.size(); i++) {
                Election e = elections.get(i);
                System.out.println(i + ". " + e.getName() + " (до " + e.getEndDate() + ")");
            }
        }
    }

    public void addCandidateToElection(int electionIndex, Candidate candidate) {
        if (electionIndex >= 0 && electionIndex < elections.size()) {
            elections.get(electionIndex).addCandidate(candidate);
            System.out.println("Кандидат добавлен.");
        } else {
            System.out.println("Неверный индекс голосования.");
        }
    }
}
